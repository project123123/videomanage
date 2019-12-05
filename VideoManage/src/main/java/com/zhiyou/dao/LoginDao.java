package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.User;
import com.zhiyou.model.Video;

public interface LoginDao {

	List<Subject> selectSubject();
	
	User loginUser(String email);

	//Web前端入门小项目
	List<Course>  webShow(Integer service);

	//修改个人资料
	void saveData(User user);
	//注册账号及密码
	 int insertUser( String email, String password);

	void applyUser(User user);
	//视频播放
	List<Speaker> videoCourse(Integer speaker_id);

}
