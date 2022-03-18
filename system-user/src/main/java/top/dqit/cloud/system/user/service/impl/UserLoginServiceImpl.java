package top.dqit.cloud.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dqit.cloud.system.user.mapper.UserLoginMapper;
import top.dqit.cloud.system.user.model.entity.UserLogin;
import top.dqit.cloud.system.user.service.UserLoginService;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/18
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {
	
	@Override
	public boolean existsByLoginName(String loginName) {
		Boolean exists = baseMapper.existsByLoginName(loginName);
		return exists != null;
	}
	
	@Override
	public Optional<UserLogin> getByLoginName(String loginName) {
		return Optional.ofNullable(baseMapper.getByLoginName(loginName));
	}
}
