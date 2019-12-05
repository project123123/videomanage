package com.zhiyou.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 *	DROP TABLE IF EXISTS `subject`;
	CREATE TABLE `subject` (
  	`subject_id` int(11) NOT NULL AUTO_INCREMENT,
  	`subject_name` varchar(200) DEFAULT NULL,
  	PRIMARY KEY (`subject_id`)
	) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
 */
@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class Subject {
	
	private Integer subject_id;
	private String  subject_name;	

}
