package com.dqit.common.framework;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Rest日志切面
 * todo 入参日志脱敏
 * @author HuangQing
 * @since 2022/3/12
 */
@Aspect
@Component
@Slf4j
public class RestLogAspect {
	
	@Pointcut("execution(public * com.dqit..controller.*.*(..))")
	public void restLog() {
	}
	
	@Around("restLog()")
	public Object recordLog(ProceedingJoinPoint point) throws Throwable {
		long nowTimestamp = System.currentTimeMillis();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		log.info("--------------监测到HTTP请求--------------");
		log.info("URL：{}", request.getRequestURL().toString());
		log.info("I P：{}", request.getRemoteAddr());
		log.info("入参：{}", point.getArgs());
		Object proceed = point.proceed();
		log.info("耗时：{}ms", System.currentTimeMillis() - nowTimestamp);
		log.info("----------------------------------------");
		return proceed;
	}
}
