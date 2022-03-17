package top.dqit.common.model;

import top.dqit.common.constants.ErrorCode;
import top.dqit.common.constants.ResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求统一返回数据
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Data
@Schema(description = "返回标准结构")
@Accessors(chain = true)
public class Result<T> {
	/**
	 * 数据
	 */
	@Schema(name = "返回数据", accessMode = Schema.AccessMode.READ_ONLY)
	private T data;
	
	/**
	 * 是否成功
	 */
	@Schema(name = "是否成功", description = "是否成功", example = "true", accessMode = Schema.AccessMode.READ_ONLY)
	private Boolean success;
	
	/**
	 * 消息
	 */
	@Schema(name = "返回消息", description = "返回消息", example = "查询成功！", accessMode = Schema.AccessMode.READ_ONLY)
	private String message;
	
	/**
	 * 状态码
	 */
	@Schema(name = "返回状态码", description = "返回状态码", example = "200",  accessMode = Schema.AccessMode.READ_ONLY)
	private Integer code;
	
	public static <T> Result<T> success(){
		return success(null);
	}
	
	public static <T> Result<T> success(T data){
		return success(data, ResultCode.DEFAULT_SUCCESS.getCode(), ResultCode.DEFAULT_SUCCESS.getMessage());
	}
	
	public static <T> Result<T> success(T data, String message){
		return success(data, ResultCode.DEFAULT_SUCCESS.getCode(), message);
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
		return fail(null, ResultCode.DEFAULT_ERROR.getCode(), message);
	}
	
	public static <T> Result<T> fail(Integer code, String message){
		return fail(null, code, message);
	}
	
	public static <T> Result<T> fail(T data, Integer code, String message){
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setSuccess(false);
		result.setMessage(message);
		result.setData(data);
		return result;
	}
	
	public static <T> Result<T> fail(ErrorCode errorCode){
		return fail(errorCode.getCode(), errorCode.getMessage());
	}
	
}
