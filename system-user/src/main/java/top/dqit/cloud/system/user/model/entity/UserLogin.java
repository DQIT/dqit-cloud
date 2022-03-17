package top.dqit.cloud.system.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.dqit.cloud.system.user.constants.UserLoginMode;
import top.dqit.common.model.BaseTableEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_user_login")
@Accessors(chain = true)
public class UserLogin extends BaseTableEntity {
	
	@TableField(value = "user_id")
	private String userId;
	
	@TableField(value = "login_name")
	private String loginName;
	
	@TableField(value = "login_mode")
	private UserLoginMode loginMode;
}