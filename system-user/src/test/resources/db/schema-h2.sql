-- 单元测试 H2

-- t_sys_user
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`
(
    `id`             varchar(64) NOT NULL UNIQUE primary key,
    `name`           varchar(64)          DEFAULT NULL COMMENT '姓名',
    `login_password` varchar(255)         DEFAULT NULL COMMENT '登录密码',
    `gender`         tinyint              DEFAULT NULL COMMENT '性别,false-女, true-男',
    `born_date`      date                 DEFAULT NULL COMMENT '出生日期',
    `create_time`    datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_deleted`     tinyint     NOT NULL DEFAULT false COMMENT '是否已删除'
);

-- t_sys_user_login
DROP TABLE IF EXISTS `t_sys_user_login`;
CREATE TABLE `t_sys_user_login`
(
    `id`          varchar(64) NOT NULL UNIQUE PRIMARY KEY,
    `user_id`     varchar(64) NOT NULL COMMENT '用户id',
    `login_mode`  varchar(32) NOT NULL COMMENT '登录方式',
    `login_name`  varchar(255)         DEFAULT NULL COMMENT '登录账号',
    `create_time` datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `is_deleted`  tinyint     NOT NULL DEFAULT false COMMENT '是否已删除'
);
