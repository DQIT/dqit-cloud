package com.dqit.demo.system.user.service.impl;

import com.dqit.demo.system.user.repository.SystemUserRepository;
import com.dqit.demo.system.user.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
	
	@Autowired
	private SystemUserRepository systemUserRepository;
	
	@Override
	public SystemUserRepository getSysUserRepository(){
		return this.systemUserRepository;
	}
}
