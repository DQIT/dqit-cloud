package top.dqit.cloud.system.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.dqit.common.model.BaseTableEntity;

import java.time.LocalDate;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_sys_user")
@Accessors(chain = true)
public class User extends BaseTableEntity {
	
	@TableField(value = "name")
	private String name;
	
	@TableField(value = "login_password")
	private String loginPassword;
	
	@TableField(value = "gender")
	private Boolean gender;
	
	@TableField(value = "born_date")
	private LocalDate bornDate;
	
}
