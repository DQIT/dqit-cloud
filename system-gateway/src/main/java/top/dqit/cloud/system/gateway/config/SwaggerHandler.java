package top.dqit.cloud.system.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.util.Optional;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/14
 */
@RestController
public class SwaggerHandler {
	
	@Autowired(required = false)
	private UiConfiguration uiConfiguration;
	
	private final SwaggerResourcesProvider swaggerResources;
	
	@Autowired
	public SwaggerHandler(SwaggerResourcesProvider swaggerResources) {
		this.swaggerResources = swaggerResources;
	}
	
	@GetMapping("/swagger-resources/configuration/ui")
	public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
		return Mono.just(new ResponseEntity<>(
				Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
	}
	
	@GetMapping("/swagger-resources")
	public Mono<ResponseEntity> swaggerResources() {
		return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
	}
}
