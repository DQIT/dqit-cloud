package top.dqit.common.framework;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
@Slf4j
public class SwaggerConfig {
	@Value("${common.swagger.enable:false}")
	private Boolean enable;
	@Value("${server.port}")
	private String port;
	
	@Bean
	public Docket docket() {
		if (enable) {
			log.info("swagger访问地址: http://localhost:" + port + "/doc.html");
		}
		
		Contact contact = new Contact("DQIT", "个人链接", "mr_hqing@163.com");
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Spring-cloud-cloud 接口文档")
				.description("spring-cloud-cloud 接口文档")
				.termsOfServiceUrl("terms of service url")
				.contact(contact)
				.version("0.0.1-Snapshot")
				.license("许可")
				.licenseUrl("许可链接")
				.build();
		return new Docket(DocumentationType.OAS_30)
				.enable(enable)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}
}
