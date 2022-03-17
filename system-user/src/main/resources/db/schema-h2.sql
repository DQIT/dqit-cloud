-- 仅用于单元测试

-- ----------------------------
-- t_sys_user
-- 用户表，存储用户基本信息，以及登录密码
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(64) NOT NULL primary key,
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `login_password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `gender` int DEFAULT NULL COMMENT '性别',
  `born_date` date DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int NOT NULL DEFAULT false COMMENT '是否已删除'
);

-- ----------------------------
-- t_sys_user_login
-- 用户登录表，存储用户不同登录方式的账号
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_login`;
CREATE TABLE `t_sys_user_login` (
  `id` varchar(64) NOT NULL primary key,
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `login_mode` varchar(32) NOT NULL COMMENT '登录方式',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录账号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int NOT NULL DEFAULT false COMMENT '是否已删除'
);
