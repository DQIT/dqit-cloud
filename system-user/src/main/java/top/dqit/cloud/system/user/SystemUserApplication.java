package top.dqit.cloud.system.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SystemUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemUserApplication.class, args);
	}
}
