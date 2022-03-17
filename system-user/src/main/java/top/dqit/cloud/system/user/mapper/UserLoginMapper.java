package top.dqit.cloud.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.dqit.cloud.system.user.model.entity.UserLogin;

/**
 * 用户登录信息持久层
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
public interface UserLoginMapper extends BaseMapper<UserLogin> {
	
	Boolean existsByLoginName(String loginName);
	
	UserLogin getByLoginName(String loginName);

}