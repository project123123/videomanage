package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.User;
import com.zhiyou.service.LoginService;
import com.zhiyou.util.MD5;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("loginUser")
	@ResponseBody
	public void loginUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {

		User user = loginService.loginUser(email, password, response);
		if (user != null) {
			request.getSession().setAttribute("user", user);
		}
	}

	@RequestMapping("/show")
	public String show(Integer service, HttpServletRequest request, HttpServletResponse response) {

		List<Subject> list = loginService.selectSubject();
		request.setAttribute("list", list);
		if (service != null) {

			List<Course> webShow = loginService.webShow(service);

			request.setAttribute("list1", webShow);
			request.setAttribute("service", service);
			return "课程展示";
		} else {
			return "forward:在线公开课-智游教育_java_大数据_HTML5_python_UI_PHP视频教程.jsp";
		}

	}

	// 回显个人中心和修改密码
	@RequestMapping("updateDataCenter")
	public String personCenter(int service, HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			request.setAttribute("user", loginService.personCenter(user.getAccounts()));
		} else {
			return "redirect:index.jsp";
		}

		if (service == 0) {
			return "个人中心";
		} else if (service == 1) {
			return "修改资料";
		} else if (service == 2) {
			return "修改头像";
		} else {
			return "修改密码";
		}
	}

	// 保存个人中心数据
	@RequestMapping(value = "saveData", method = RequestMethod.POST)
	public String saveData(User user, HttpServletRequest request, HttpServletResponse response) {
		loginService.saveData(user);
		return "forward:updateDataCenter?service=0";
	}

	// 验证邮箱是否存在
	@RequestMapping(value = "validateEmail", method = RequestMethod.POST)
	public void validateEmail(String email, HttpServletRequest request, HttpServletResponse response) {
		loginService.validateEmail(email, response);
	}

	// 验证密码是否存在
	@RequestMapping(value = "verifyPassWord", method = RequestMethod.POST)
	@ResponseBody
	public String verifyPassWord(String password, HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (MD5.getInstance().getMD5(password).equals(user.getPassword())) {
			return "success";
		}
		return null;
	}

	// 注册账号密码
	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {
		int success = loginService.insertUser(email, password);
		if(success==1) {
			return 200;
		}
		return null;
	}

	// 上传头像
	@RequestMapping("upload")
	public String upload(MultipartFile image_file, Integer id, HttpServletRequest request,
			HttpServletResponse response) {

		loginService.upload(image_file, id);

		return "forward:updateDataCenter?service=0";
	}

	// 用户报名
	@RequestMapping("applyUser")
	public String applyUser(User user, HttpServletRequest request, HttpServletResponse response) {
		loginService.applyUser(user);
		return "redirect:index.jsp";
	}

	// 视频播放页面
	@RequestMapping("videoCourse")
	public String videoCourse(Integer speaker_id, Integer video_id, HttpServletRequest request,
			HttpServletResponse response) {

		/*
		 * List<Subject> list = loginService.selectSubject();
		 * request.setAttribute("list", list);
		 */

		List<Speaker> speakers = loginService.videoCourse(speaker_id);
		request.setAttribute("speakers", speakers);
		request.setAttribute("video_id", video_id);
		return "视频播放";
	}

	// 用户退出
	@RequestMapping("exitUser")
	public String exitUser(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		return "redirect:index.jsp";
	}

}
