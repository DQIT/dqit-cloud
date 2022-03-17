package top.dqit.common.framework;

import top.dqit.common.constants.ErrorCode;
import top.dqit.common.exception.BizException;
import top.dqit.common.model.ParamNotValidInfoUnit;
import top.dqit.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 异常拦截
 *
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionAdvice {
	
	//全局异常拦截
	@ExceptionHandler(value = Exception.class)
	public Result<?> globalExceptionHandler(Exception exception) {
		log.error("请求异常", exception);
		ErrorCode errorCode = ErrorCode.DEFAULT_ERROR_CODE;
		return Result.fail(errorCode);
	}
	
	/**
	 * 业务异常拦截
	 *
	 * @param exception 业务异常
	 * @return 返回
	 */
	@ExceptionHandler(value = BizException.class)
	public Result<?> globalExceptionHandler(BizException exception) {
		ErrorCode errorCode = exception.getErrorCode();
		log.info("业务异常：{}", exception.getErrorCode().getMessage());
		return Result.fail(errorCode);
	}
	
	/**
	 * 参数校验异常拦截
	 * todo 入参日志脱敏
	 *
	 * @param exception 方法参数无效异常
	 * @return 返回
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Result<ArrayList<ParamNotValidInfoUnit>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
		ArrayList<ParamNotValidInfoUnit> data = new ArrayList<>();
		StringJoiner message = new StringJoiner("；");
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			String fieldMessage = fieldError.getDefaultMessage();
			message.add(fieldMessage);
			ParamNotValidInfoUnit paramNotValidInfo = ParamNotValidInfoUnit.builder()
					.fieldName(fieldError.getField())
					.message(fieldMessage)
					.build();
			data.add(paramNotValidInfo);
		});
		
		//参数非法不会进入日志切
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		log.info("请求参数非法: {}, URL: {}, IP: {}, 入参: {}",
				message,
				request.getRequestURL().toString(),
				request.getRemoteAddr(),
				exception.getBindingResult().getTarget()
		);
		
		return Result.fail(data, ErrorCode.INVALID_REQUEST_PARAM.getCode(), message.toString());
	}
	
}
