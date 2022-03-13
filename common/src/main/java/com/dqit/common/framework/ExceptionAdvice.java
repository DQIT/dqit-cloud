package com.dqit.common.framework;

import com.dqit.common.constants.ResultCodeEnum;
import com.dqit.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 异常拦截
 * @author HuangQing
 * @since 2022/3/12
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionAdvice {
	
	//全局异常拦截
	@ExceptionHandler(value = Exception.class)
	public Result<?> globalExceptionHandler(Exception e) {
		log.error("请求异常", e);
		return Result.fail("系统错误，请稍后再试");
	}
	
	//参数校验异常拦截 todo 入参日志脱敏
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Result<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
		List<String> errors = exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.toList());
		String message = String.join("；", errors);
		
		//参数非法不会进入日志切
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		log.info("----------------------------------------");
		log.info("请求参数非法: {}", message);
		log.info("URL：{}", request.getRequestURL().toString());
		log.info("I P：{}", request.getRemoteAddr());
		log.info("入参：{}", exception.getBindingResult().getTarget());
		log.info("----------------------------------------");
		
		return Result.fail(ResultCodeEnum.INVALID_PARAM_ERROR.getCode(), message);
	}
	
}
