/*
 Source Server Type : MySQL
 Source Schema      : spring-cloud-cloud
 Date               : 2022/03/14
*/
use 'dqit-cloud';
SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT primary key,
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `login_password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `born_date` date DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  UNIQUE KEY `t_sys_user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sys_user_login
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_login`;
CREATE TABLE `t_sys_user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT primary key,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `login_mode` varchar(32) NOT NULL COMMENT '登录方式',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录账号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_login_id_uindex` (`id`),
  UNIQUE KEY `t_user_login_login_name_uindex` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
