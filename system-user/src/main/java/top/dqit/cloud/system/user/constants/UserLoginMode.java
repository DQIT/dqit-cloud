package top.dqit.cloud.system.user.constants;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 用户登录方式枚举
 * @author mr_hqing@163.com
 * @since 2022/3/13
 */
@Getter
public enum UserLoginMode {
	/**
	 *
	 */
	NONE("none", "未知"),
	/**
	 * 邮箱
	 */
	EMAIL("email", "邮箱"),
	/**
	 * 手机号
	 */
	PHONE_NUMBER("phone_number", "手机号"),
	/**
	 * 用户名
	 */
	USERNAME("username", "用户名");
	
	@EnumValue
	private final String code;
	private final String name;
	
	UserLoginMode(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	/**
	 * 通过 code 获取枚举
	 * @param code 编码
	 * @return UserLoginMode
	 */
	public UserLoginMode getByCode(String code){
		for (UserLoginMode userLoginMode : values()) {
			if (userLoginMode.code.equalsIgnoreCase(code)) {
				return userLoginMode;
			}
		}
		return NONE;
	}
}
