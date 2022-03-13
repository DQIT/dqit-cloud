package com.dqit.common.constants;

import lombok.Getter;

/**
 * 请求结果状态码枚举
 * @author HuangQing
 * @since 2022/3/12
 */
@Getter
public enum ResultCodeEnum {
	/**
	 * 成功-默认
	 */
	DEFAULT_SUCCESS(200, "成功"),
	/**
	 * 失败-默认
	 */
	DEFAULT_ERROR(500, "系统错误"),
	/**
	 * 失败-请求参数不合法
	 */
	INVALID_PARAM_ERROR(501, "请求参数非法");
	
	private final Integer code;
	private final String message;
	
	ResultCodeEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
}
