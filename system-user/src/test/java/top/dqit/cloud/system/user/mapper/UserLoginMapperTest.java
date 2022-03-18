package top.dqit.cloud.system.user.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.dqit.cloud.system.user.model.entity.UserLogin;

/**
 * 单元测试 UserLoginMapper
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@MybatisPlusTest
public class UserLoginMapperTest {
	
	@Autowired
	private UserLoginMapper userLoginMapper;
	
	/**
	 * {@link UserLoginMapper#existsByLoginName(java.lang.String)}
	 */
	@Test
	public void existsByLoginNameTest(){
		Boolean exists = userLoginMapper.existsByLoginName("test_user");
		Assertions.assertTrue(exists);
		exists = userLoginMapper.existsByLoginName("test_user_not_exist");
		Assertions.assertNull(exists);
	}
	
	/**
	 * {@link UserLoginMapper#getByLoginName(java.lang.String)}
	 */
	@Test
	public void getByLoginNameTest(){
		UserLogin userLogin = userLoginMapper.getByLoginName("test_user");
		Assertions.assertNotNull(userLogin.getId());
	}
}