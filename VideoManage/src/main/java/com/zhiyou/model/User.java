package com.zhiyou.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Administrator
 * 
 * DROP TABLE IF EXISTS `user`;
	CREATE TABLE `user` (
  	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`accounts` varchar(200) DEFAULT NULL,
  	`phone` varchar(200) DEFAULT NULL,
  	`password` varchar(200) DEFAULT NULL,
  	`nickname` varchar(200) DEFAULT NULL,
  	`sex` varchar(5) DEFAULT NULL,
  	`birthday` varchar(100) DEFAULT NULL,
  	`address` varchar(100) DEFAULT NULL,
  	`imgurl` varchar(100) DEFAULT NULL,
  	`createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  	PRIMARY KEY (`id`)
	) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
 *
 */

@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class User {
	private Integer id;
	private String accounts;
	private String phone;
	private String password;
	private String nickname;
	private String sex;
	private String birthday;
	private String address;
	private String imgurl;
    private Date createtime;
}
