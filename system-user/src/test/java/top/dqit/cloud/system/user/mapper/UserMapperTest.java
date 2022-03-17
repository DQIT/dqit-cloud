package top.dqit.cloud.system.user.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.dqit.cloud.system.user.model.entity.User;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/18
 */
@MybatisPlusTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void getByLoginNameTest(){
		User user = userMapper.getByLoginName("test");
		Assertions.assertNotNull(user.getId());
	}
	
}
