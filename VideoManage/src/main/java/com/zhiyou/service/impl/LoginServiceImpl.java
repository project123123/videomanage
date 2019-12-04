package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.dao.LoginDao;
import com.zhiyou.model.Admin;
import com.zhiyou.model.User;
import com.zhiyou.model.Video;
import com.zhiyou.service.LoginService;
import com.zhiyou.util.FTPUtil;
import com.zhiyou.util.MD5;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	public User loginUser(String email, String password, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		User user = loginDao.loginUser(email);
		if (user != null) {
			if (email.equals(user.getAccounts())
					&& MD5.getInstance().getMD5(password).equals(user.getPassword())) {
				try {
					response.getWriter().write("success");
					return user;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					response.getWriter().write("用户名或密码错误");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {

			try {
				response.getWriter().write("用户名不存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Web前端入门小项目
	public List<Video> webShow() {
		return loginDao.webShow();
	}

	// 修改个人资料
	public void saveData(User user) {
		loginDao.saveData(user);
	}

	public void validateEmail(String email, HttpServletResponse response) {

		User user = loginDao.loginUser(email);
		if (user == null) {
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertUser(String email, String password, HttpServletResponse response) {
		int number = loginDao.insertUser(email, MD5.getInstance().getMD5(password));
		if (number == 1) {
			try {
				response.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public User personCenter(String accounts) {
		return loginDao.loginUser(accounts);
	}
	public void upload(MultipartFile image_file,Integer id) {
	 try {
		 User user = new User();
		String upload = FTPUtil.upload(image_file.getInputStream(),image_file.getOriginalFilename());
		user.setImgurl(upload);
		user.setId(id);
		loginDao.saveData(user);
		
	} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public void applyUser(User user) {
		loginDao.applyUser(user);
	}

}
