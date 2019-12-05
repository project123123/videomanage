package com.zhiyou.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 * 	DROP TABLE IF EXISTS `course`;
	CREATE TABLE `course` (
  	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`course_title` varchar(200) DEFAULT NULL,
  	`course_desc` varchar(200) DEFAULT NULL,
  	`subject_id` int(11) DEFAULT NULL,
  	PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
 *
 */
@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class Course {
	private Integer id;
	private String course_title;
	private String course_desc;
	private Integer subject_id;
	
	private List<Video> videos ;
}
