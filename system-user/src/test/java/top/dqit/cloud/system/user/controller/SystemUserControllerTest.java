package top.dqit.cloud.system.user.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import top.dqit.cloud.system.user.model.RegisterForm;
import top.dqit.cloud.system.user.model.UserInfo;
import top.dqit.cloud.system.user.repository.UserRepository;
import top.dqit.common.model.Result;

/**
 * SystemUserController单元测试
 *
 * @author mr_hqing@163.com
 * @since 2022/3/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemUserControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * TEST: /user/register
	 * {@link top.dqit.cloud.system.user.controller.SystemUserController#register(RegisterForm)}
	 */
	@Test
	public void registerTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String param = SystemUserControllerTestConstants.registerTestJsonParam;
		HttpEntity<String> httpEntity = new HttpEntity<>(param, headers);
		ResponseEntity<Result> responseEntity = testRestTemplate.postForEntity(
				SystemUserControllerTestConstants.registerTestUrl,
				httpEntity,
				Result.class
		);
		Assert.assertNotNull(responseEntity);
		Result<Object> body = responseEntity.getBody();
		Assert.assertNotNull(body);
		Assert.assertTrue(body.getSuccess());
	}
	
	/**
	 * TEST: /user/getCurrentUserInfo
	 * {@link top.dqit.cloud.system.user.controller.SystemUserController#getCurrentUserInfo(String)}
	 */
	@Test
	public void getCurrentUserInfoTest(){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<Result> responseEntity = testRestTemplate.getForEntity(
				SystemUserControllerTestConstants.getCurrentUserInfoTestUrl,
				Result.class,
				SystemUserControllerTestConstants.getCurrentUserInfoUrlParam
		);
		Assert.assertNotNull(responseEntity);
		Result<UserInfo> body = responseEntity.getBody();
		Assert.assertNotNull(body);
	}
	
	interface SystemUserControllerTestConstants {
		String registerTestUrl = "/user/register";
		String registerTestJsonParam = "{\"loginName\": \"test-user\", \"loginPassword\": \"test-password\"}";
		
		String getCurrentUserInfoTestUrl = "/user/getCurrentUserInfo?loginName={1}";
		String getCurrentUserInfoUrlParam = "test-user";
	}
}
