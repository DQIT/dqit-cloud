package top.dqit.cloud.system.user.repository;

import top.dqit.cloud.system.user.model.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 用户登录信息持久层
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	
	boolean existsByLoginName(String loginName);
	
	Optional<UserLogin> getUserLoginByLoginName(String loginName);

}