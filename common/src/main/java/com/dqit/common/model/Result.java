package com.dqit.common.model;

import com.dqit.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求统一返回数据
 * @author HuangQing
 * @since 2022/3/12
 */
@Data
@ApiModel("返回结果标准结构")
@Accessors(chain = true)
public class Result<T> {
	/**
	 * 数据
	 */
	@ApiModelProperty(name = "返回数据", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
	private T data;
	
	/**
	 * 是否成功
	 */
	@ApiModelProperty(name = "是否成功", notes = "是否成功", example = "true", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
	private Boolean success;
	
	/**
	 * 消息
	 */
	@ApiModelProperty(name = "返回消息", notes = "返回消息", example = "查询成功！", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
	private String message;
	
	/**
	 * 状态码
	 */
	@ApiModelProperty(name = "返回状态码", notes = "返回状态码", example = "200",  accessMode = ApiModelProperty.AccessMode.READ_ONLY)
	private Integer code;
	
	public static <T> Result<T> success(){
		Result<T> result = new Result<>();
		result.setSuccess(true);
		result.setData(null);
		result.setCode(ResultCodeEnum.DEFAULT_SUCCESS.getCode());
		result.setMessage(ResultCodeEnum.DEFAULT_SUCCESS.getMessage());
		return result;
	}
	
	public static <T> Result<T> success(T data){
		Result<T> result = new Result<>();
		result.setSuccess(true);
		result.setData(data);
		result.setCode(ResultCodeEnum.DEFAULT_SUCCESS.getCode());
		result.setMessage(ResultCodeEnum.DEFAULT_SUCCESS.getMessage());
		return result;
	}
	
	public static <T> Result<T> success(T data, String message){
		Result<T> result = new Result<>();
		result.setSuccess(true);
		result.setData(data);
		result.setCode(ResultCodeEnum.DEFAULT_SUCCESS.getCode());
		return result;
	}
	
	public static <T> Result<T> success(T data, Integer code, String message){
		Result<T> result = new Result<>();
		result.setSuccess(true);
		result.setCode(code);
		result.setData(data);
		result.setMessage(message);
		return result;
	}
	
	public static <T> Result<T> fail(String message){
		Result<T> result = new Result<>();
		result.setSuccess(false);
		result.setMessage(message);
		result.setCode(ResultCodeEnum.DEFAULT_ERROR.getCode());
		return result;
	}
	
	public static <T> Result<T> fail(T data, String message){
		Result<T> result = new Result<>();
		result.setData(data);
		result.setSuccess(false);
		result.setCode(ResultCodeEnum.DEFAULT_ERROR.getCode());
		result.setMessage(message);
		return result;
	}
	
	public static <T> Result<T> fail(Integer code, String message){
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setSuccess(false);
		result.setMessage(message);
		return result;
	}
	
	public static <T> Result<T> fail(T data, Integer code, String message){
		Result<T> result = new Result<>();
		result.setData(data);
		result.setCode(code);
		result.setSuccess(false);
		result.setMessage(message);
		return result;
	}
}
