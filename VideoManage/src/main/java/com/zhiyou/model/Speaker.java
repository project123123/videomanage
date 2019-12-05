package com.zhiyou.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 * 
 * 	DROP TABLE IF EXISTS `speaker`;
	CREATE TABLE `speaker` (
  	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`speaker_name` varchar(200) DEFAULT NULL,
  	`speaker_desc` varchar(200) DEFAULT NULL,
  	`speaker_job` varchar(200) DEFAULT NULL,
  	`pic_url` varchar(200) DEFAULT NULL,
  	PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

 */
@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class Speaker {
	private Integer id;
	private String speaker_name;
	private String speaker_desc;
	private String speaker_job;
	private String pic_url;
	
	private List<Video> videos ;
	
}