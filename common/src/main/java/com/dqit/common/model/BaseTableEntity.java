package com.dqit.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author HuangQing
 * @since 2022/3/12
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
public class BaseTableEntity {
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	
	/**
	 * 是否已删除
	 */
	@Column(name = "is_deleted")
	private Boolean isDeleted;
}
