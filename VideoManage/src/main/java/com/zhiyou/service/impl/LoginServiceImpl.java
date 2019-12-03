package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.dao.LoginDao;
import com.zhiyou.model.Admin;
import com.zhiyou.model.User;
import com.zhiyou.model.Video;
import com.zhiyou.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	public User loginUser(String email, String password,HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		User user  = loginDao.loginUser(email);
		if(user!=null) {
			if(email.equals(user.getAccounts())&&password.equals(user.getPassword())) {
				try {
					response.getWriter().write("success");
					return user;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				try {
					response.getWriter().write("用户名或密码错误");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
				
			try {
				response.getWriter().write("用户名不存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//Web前端入门小项目
	public List<Video>  webShow() {
		return loginDao.webShow();
	}
	
	//修改个人资料
	public void saveData(User user) {
		 loginDao.saveData(user);
	}

}
