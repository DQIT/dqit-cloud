package top.dqit.cloud.security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 身份验证切面处理
 * @author mr_hqing@163.com
 * @since 2022/3/16
 */
@Aspect
@Component
public class AuthAspect {
	
	@Pointcut("@annotation(top.dqit.cloud.security.annation.Auth)")
	public void pointcut(){}
	
	@Before("pointcut()")
	public void before(JoinPoint point){
		
		System.out.println("auth check before...");
	}
	
	@Around("pointcut()")
	public Object before(ProceedingJoinPoint point) throws Throwable {
		System.out.println("auth check around...");
		return point.proceed();
	}
	
	@After("pointcut()")
	public void after(){
		System.out.println("auth check after...");
	}
}
