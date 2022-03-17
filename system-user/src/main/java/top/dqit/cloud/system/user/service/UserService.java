package top.dqit.cloud.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dqit.cloud.system.user.model.RegisterForm;
import top.dqit.cloud.system.user.model.entity.User;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
public interface UserService extends IService<User> {
	/**
	 * 注册
	 * @param registerForm 注册参数
	 */
	void register(RegisterForm registerForm);
	
	/**
	 * 通过loginName查询用户
	 * @param loginName 登录账号
	 * @return 用户
	 */
	Optional<User> getUserByLoginName(String loginName);
}
