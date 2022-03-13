package com.dqit.demo.system.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * 启动类
 * @author HuangQing
 * @since 2022/3/12
 */
@SpringBootApplication
@ComponentScans(value = {
		@ComponentScan("com.dqit.common")
})
public class SystemUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemUserApplication.class, args);
	}
}
