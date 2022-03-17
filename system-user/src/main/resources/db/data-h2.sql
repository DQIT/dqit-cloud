-- 仅用于单元测试

-- 用户
INSERT INTO t_sys_user (id, name, login_password, gender, born_date, create_time, is_deleted) VALUES ('1504533263312101378', 'test_user', '$2a$10$Lwv9HRys/YVsI5jzPToQ1uhRr03VItNkonYARG0pm0141pqW3zV6S', 1, '2020-01-01', '2022-03-17 19:00:57', 0);

-- 用户登录
INSERT INTO t_sys_user_login (id, user_id, login_mode, login_name, create_time, is_deleted) VALUES ('1504533263337267202', '1504533263312101378', 'USERNAME', 'test_user', '2022-03-17 19:00:57', 0);
