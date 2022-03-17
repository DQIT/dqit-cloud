package top.dqit.common.framework;

import com.alibaba.fastjson.JSONObject;
import top.dqit.common.annotation.SensitiveField;
import top.dqit.common.model.HttpRequestLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Rest日志切面
 *
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Aspect
@Component
@Slf4j
public class RestLogAspect {
	
	@Pointcut("execution(public * top.dqit..controller.*.*(..))")
	public void restLog() {
	}
	
	@Around("restLog()")
	public Object recordLog(ProceedingJoinPoint point) throws Throwable {
		long nowTimestamp = System.currentTimeMillis();
		HttpRequestLog httpRequestLog = new HttpRequestLog();
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		httpRequestLog
				.setRemoteAddress(request.getRemoteAddr())
				.setUrl(request.getRequestURL().toString())
				.setParam(getDesensitizationArgs(point.getArgs()));
		
		Object proceed = point.proceed();
		
		httpRequestLog.setTimeMillis(System.currentTimeMillis() - nowTimestamp);
		log.info("RestLog: {}", JSONObject.toJSONString(httpRequestLog));
		
		return proceed;
	}
	
	/**
	 * 参数值脱敏
	 * TODO 感觉目前不够优雅，后续有机会优化一下
	 */
	public HashMap<String, Object> getDesensitizationArgs(Object[] args) {
		if (args == null || args.length == 0) {
			return null;
		}
		HashMap<String, Object> params = new HashMap<>();
		for (Object arg : args) {
			String className = arg.getClass().getSimpleName();
			params.put(className, getArgDesensitizationString(arg));
		}
		return params;
	}
	
	/**
	 * 单个类型日志脱敏
	 *
	 * @param arg 参数
	 * @return 脱敏后内容
	 */
	public Object getArgDesensitizationString(Object arg) {
		if (arg.getClass().isPrimitive() || arg instanceof String) {
			return arg.toString();
		}
		Class<?> clazz = arg.getClass();
		Field[] myFields = clazz.getDeclaredFields();
		
		// 获取父类的字段
		Class<?> superClass = clazz.getSuperclass();
		Field[] fields = ArrayUtils.addAll(myFields, superClass.getDeclaredFields());
		if (superClass != Object.class){
			superClass = superClass.getSuperclass();
			fields = ArrayUtils.addAll(myFields, superClass.getDeclaredFields());
		}
		
		HashMap<String, Object> param = new HashMap<>();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = null;
			try {
				value = field.get(arg);
			} catch (IllegalAccessException e) {
				log.error("HTTP请求入参日志生成异常", e);
			}
			field.setAccessible(false);
			// 如果不是基本类型或包装类
			if (value == null) {
				continue;
			}
			value = getArgDesensitizationString(value);
			for (Annotation annotation : field.getAnnotations()) {
				if (annotation instanceof SensitiveField) {
					value = "******";
					break;
				}
			}
			param.put(field.getName(), value);
		}
		
		return param;
	}
	
	
}
