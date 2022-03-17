package top.dqit.cloud.system.user.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import top.dqit.common.model.BaseTableEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author mr_hqing@163.com
 * @since 2022/3/12
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_sys_user")
@SQLDelete(sql = "update t_sys_user set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@Accessors(chain = true)
public class User extends BaseTableEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 64)
	private String name;
	
	@Column(name = "login_password")
	private String loginPassword;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "born_date")
	private LocalDate bornDate;
	
	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, orphanRemoval = true)
	@ToString.Exclude
	private List<UserLogin> loginList;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
