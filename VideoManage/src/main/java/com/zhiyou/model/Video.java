package com.zhiyou.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 *
 *DROP TABLE IF EXISTS `video`;
	CREATE TABLE `video` (
  	`video_id` int(11) NOT NULL AUTO_INCREMENT,
  	`title` varchar(200) DEFAULT NULL,
  	`detail` varchar(100) DEFAULT NULL,
  	`time` int(11) DEFAULT NULL,
  	`speaker_id` int(11) DEFAULT NULL,
  	`course_id` int(11) DEFAULT NULL,
  	`video_url` varchar(200) DEFAULT NULL,
  	`image_url` varchar(200) DEFAULT NULL,
  	`play_num` int(11) DEFAULT NULL,
  	PRIMARY KEY (`video_id`)
	) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8;
 */

@Data // 生成 get set方法
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
public class Video {
	private Integer video_id;
	private String title;
	private String detail;
	private Integer time;
	private Integer speaker_id;
	private Integer course_id;
	private String video_url;
	private String image_url;
	private Integer play_num;

}
