package top.dqit.common.constants;

import lombok.Getter;

/**
 * 请求结果状态码枚举
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Getter
public enum ResultCode {
	/**
	 * 成功-默认
	 */
	DEFAULT_SUCCESS(200, "成功"),
	/**
	 * 失败-默认
	 */
	DEFAULT_ERROR(500, "系统错误");
	
	private final Integer code;
	private final String message;
	
	ResultCode(Integer code, String message){
		this.code = code;
		this.message = message;
	}
}
