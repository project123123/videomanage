package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.User;
import com.zhiyou.model.Video;

public interface LoginService {

	List<Subject> selectSubject();
	
	User loginUser(String email, String password, HttpServletResponse response);

	List<Course>  webShow(Integer service);

	//修改个人资料
	 void saveData(User user);
	 //验证邮箱
	void validateEmail(String email, HttpServletResponse response);
	//注册账号密码
	
	  void insertUser(String email, String password, HttpServletResponse response);

	User personCenter(String accounts);

	void upload(MultipartFile image_file, Integer id);

	void applyUser(User user);
	//视频播放
	List<Speaker> videoCourse(Integer speaker_id);
	 

}
