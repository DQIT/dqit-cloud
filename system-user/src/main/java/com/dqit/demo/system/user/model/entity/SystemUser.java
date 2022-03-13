package com.dqit.demo.system.user.model.entity;

import com.dqit.common.model.BaseTableEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@Data
@Entity
@Table(name = "t_sys_user")
@SQLDelete(sql = "update t_sys_user set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
public class SystemUser extends BaseTableEntity {
	
	@Id
	private Long id;
	
	@Column(name = "name", length = 64)
	private String name;
	
	@Column(name = "login_password")
	private String loginPassword;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "born_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bornDate;
	
}
