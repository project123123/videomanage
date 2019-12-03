package com.zhiyou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.model.User;
import com.zhiyou.model.Video;
import com.zhiyou.service.LoginService;

@Controller

public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("/show" )
	public String show(HttpServletRequest request,HttpServletResponse response) {
	
		return "forward:在线公开课-智游教育_java_大数据_HTML5_python_UI_PHP视频教程.jsp";
	}
	
	@RequestMapping("loginUser")
	public void loginUser(String email, String password, HttpServletRequest request,HttpServletResponse response) {
		User user =  loginService.loginUser(email,password,response);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
		}
	}
	
	//Web前端入门小项目
	@RequestMapping("webShow")
	public String webShow(HttpServletRequest request,HttpServletResponse response) {
		
		List<Video>  list = loginService.webShow();
		request.setAttribute("list", list);
	
		return "课程展示";
	}
	//回显个人中心数据
	@RequestMapping("personCenter")
	public String personCenter(HttpServletRequest request,HttpServletResponse response) {
		return "个人中心";
	}
	//回显个人中心数据
	@RequestMapping("updateData")
	public String updateData(HttpServletRequest request,HttpServletResponse response) {
		return "修改资料";
	}
	//回显个人中心数据
	@RequestMapping("updateHeadPortrait")
	public String updateHeadPortrait(HttpServletRequest request,HttpServletResponse response) {
		return "修改头像";
	}
	//回显个人中心数据
	@RequestMapping("updatePassWord")
	public String updatePassWord(HttpServletRequest request,HttpServletResponse response) {
		return "修改密码";
	}
	//回显个人中心数据
		@RequestMapping(value =  "saveData",method = RequestMethod.POST)
		public String saveData(User user ,HttpServletRequest request,HttpServletResponse response) {
			 loginService.saveData(user);
			return "forward:personCenter";
		}
}
