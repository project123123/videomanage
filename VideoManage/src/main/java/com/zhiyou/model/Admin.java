package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 * 
 *	DROP TABLE IF EXISTS `admin`;
 *	CREATE TABLE `admin` (
 * 	`admin_id` int(11) NOT NULL AUTO_INCREMENT,
  	`accounts` varchar(200) DEFAULT NULL,
  	`password` varchar(200) DEFAULT NULL,
  	`admin_remark` varchar(200) DEFAULT NULL,
  	PRIMARY KEY (`admin_id`)
	) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */
@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class Admin {

	private Integer admin_id;
	private String accounts;
    private String password;
	private String admin_remark;
}
