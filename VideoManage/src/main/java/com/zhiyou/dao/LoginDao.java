package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.User;
import com.zhiyou.model.Video;

public interface LoginDao {

	User loginUser(String email);

	//Web前端入门小项目
	List<Video>  webShow();

	//修改个人资料
	void saveData(User user);
	//注册账号及密码
	 int insertUser( String email, String password);

	void applyUser(User user);

}
