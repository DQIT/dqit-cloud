package top.dqit.common.constants;

import lombok.Getter;

/**
 * 错误码枚举
 * @author mr_hqing@163.com
 * @since 2022/3/13
 */
@Getter
public enum ErrorCode {
	DEFAULT_ERROR_CODE(500, "系统错误"),
	INVALID_REQUEST_PARAM(1001, "请求参数非法"),
	LOGIN_NAME_ALREADY_EXIST(1002, "账号已存在")
	
	;
	/**
	 * 错误码
	 */
	private final int code;
	
	/**
	 * 错误信息
	 */
	private final String message;
	
	ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
