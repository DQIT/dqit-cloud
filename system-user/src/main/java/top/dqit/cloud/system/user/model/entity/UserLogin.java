package top.dqit.cloud.system.user.model.entity;

import top.dqit.common.model.BaseTableEntity;
import top.dqit.cloud.system.user.constants.UserLoginMode;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_sys_user_login")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SQLDelete(sql = "update t_sys_user_login set is_deleted = 1 where id = ?")
@Where(clause = "is_deleted = 0")
@Accessors(chain = true)
public class UserLogin extends BaseTableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "login_name")
	private String loginName;
	
	@Column(name = "login_mode", nullable = false)
	private UserLoginMode loginMode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false, referencedColumnName = "id")
	@ToString.Exclude
	private User user;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserLogin login = (UserLogin) o;
		return id != null && Objects.equals(id, login.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}