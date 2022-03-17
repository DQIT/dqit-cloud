package top.dqit.cloud.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dqit.cloud.security.util.PasswordUtil;
import top.dqit.cloud.system.user.constants.UserLoginMode;
import top.dqit.cloud.system.user.exception.UserOperationException;
import top.dqit.cloud.system.user.mapper.UserMapper;
import top.dqit.cloud.system.user.model.RegisterForm;
import top.dqit.cloud.system.user.model.entity.User;
import top.dqit.cloud.system.user.model.entity.UserLogin;
import top.dqit.cloud.system.user.service.UserLoginService;
import top.dqit.cloud.system.user.service.UserService;
import top.dqit.common.constants.ErrorCode;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Override
	public void register(RegisterForm registerForm) {
		//查询账号是否存在
		boolean exist = userLoginService.existsByLoginName(registerForm.getLoginName());
		if (exist) {
			throw new UserOperationException(ErrorCode.LOGIN_NAME_ALREADY_EXIST);
		}
		//生成一个用户
		String password = PasswordUtil.encode(registerForm.getLoginPassword());
		User user = new User().setLoginPassword(password);
		this.save(user);
		//生成一个用户登录方式
		UserLogin login = new UserLogin()
				.setUserId(user.getId())
				.setLoginMode(UserLoginMode.USERNAME)
				.setLoginName(registerForm.getLoginName());
		userLoginService.save(login);
	}
	
	@Override
	public Optional<User> getUserByLoginName(String loginName){
		return Optional.ofNullable(baseMapper.getByLoginName(loginName));
	}
}
