package top.dqit.cloud.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dqit.cloud.system.user.model.entity.UserLogin;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/18
 */
public interface UserLoginService extends IService<UserLogin> {
	
	boolean existsByLoginName(String loginName);
	
	Optional<UserLogin> getByLoginName(String loginName);
}
