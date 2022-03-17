package top.dqit.cloud.system.user.model;

import top.dqit.common.annotation.SensitiveField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * 注册表单
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Data
@Schema(description = "注册表单")
public class RegisterForm {
	@Schema(description = "用户名", pattern = ".{5,30}", nullable = true)
	@Pattern(regexp = ".{5,30}", message = "用户名格式不正确")
	private String loginName;
	
	@Schema(description = "密码", pattern = ".{5,30}", nullable = true)
	@Pattern(regexp = ".{5,30}", message = "密码格式不正确")
	@SensitiveField
	private String loginPassword;
}
