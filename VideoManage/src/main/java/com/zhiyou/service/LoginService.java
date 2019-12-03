package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.model.Video;

public interface LoginService {

	User loginUser(String email, String password, HttpServletResponse response);

	List<Video>  webShow();

	//修改个人资料
	 void saveData(User user);

}
