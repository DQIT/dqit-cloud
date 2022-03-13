package com.dqit.demo.system.user.repository;

import com.dqit.demo.system.user.model.entity.SystemUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {
}
