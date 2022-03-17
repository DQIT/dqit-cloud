package top.dqit.cloud.system.user.repository;

import top.dqit.cloud.system.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> getByLoginListLoginName(String loginName);
}
