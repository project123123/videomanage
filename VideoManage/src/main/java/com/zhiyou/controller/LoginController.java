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

import com.zhiyou.model.User;
import com.zhiyou.model.Video;
import com.zhiyou.service.LoginService;
import com.zhiyou.util.MD5;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("/show")
	public String show(HttpServletRequest request, HttpServletResponse response) {

		return "forward:在线公开课-智游教育_java_大数据_HTML5_python_UI_PHP视频教程.jsp";
	}

	@RequestMapping("loginUser")
	@ResponseBody
	public void loginUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {
		
		User user = loginService.loginUser(email, password, response);
		if (user != null) {
			request.getSession().setAttribute("user", user);
		}
	}

	// Web前端入门小项目
	@RequestMapping("webShow")
	public String webShow(HttpServletRequest request, HttpServletResponse response) {

		List<Video> list = loginService.webShow();
		request.setAttribute("list", list);

		return "课程展示";
	}

	// 回显个人中心和修改密码
	@RequestMapping("updateDataCenter")
	public String personCenter(int service, HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", loginService.personCenter(user.getAccounts()));
		if (service == 0) {
			return "个人中心";
		}else if(service == 1){
			return "修改资料";
		}else if(service == 2) {
			return "修改头像";
		}else{
			return "修改密码";
		}
	}
	// 回显个人中心数据
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
		if(MD5.getInstance().getMD5(password).equals(user.getPassword())) {
			return "success";
		}
		return null;
	}

	// 注册账号密码
	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public void insertUser(String email, String password, HttpServletRequest request, HttpServletResponse response) {
		loginService.insertUser(email, password, response);
	}
	//上传头像
	@RequestMapping("upload")
	public String upload(MultipartFile image_file, Integer id, HttpServletRequest request,HttpServletResponse response) {
		
		loginService.upload(image_file,id);

		return "forward:updateDataCenter?service=0";
	}
	//用户报名
	@RequestMapping("applyUser")
	public String applyUser(User user, HttpServletRequest request,HttpServletResponse response) {
		loginService.applyUser(user);	 
		return "redirect:index.jsp";
	}
	//视频展示页面
	@RequestMapping("videoCourse")
	public String videoCourse(HttpServletRequest request,HttpServletResponse response) {
		
		return "视频播放";
	}
	
}
