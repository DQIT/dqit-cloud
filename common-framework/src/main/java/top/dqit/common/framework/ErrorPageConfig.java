package top.dqit.common.framework;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;

/**
 * 错误页面注册
 * @author mr_hqing@163.com
 * @since 2022/3/15
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
	
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage errorPage = new ErrorPage("/404.html");
		registry.addErrorPages(errorPage);
	}
}