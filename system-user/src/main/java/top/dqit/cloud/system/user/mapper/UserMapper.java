package top.dqit.cloud.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.dqit.cloud.system.user.model.entity.User;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
public interface UserMapper extends BaseMapper<User> {
	
	User getByLoginName(String loginName);
}
