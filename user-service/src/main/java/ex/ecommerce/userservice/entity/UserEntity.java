package ex.ecommerce.userservice.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50, unique = true)
	private String email;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, unique = true)
	private String password;

	@Column(nullable = false, unique = true)
	private String userId;


	@Builder
	public UserEntity(Long id, String email, String name, String userId, String password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public void encrypt(PasswordEncoder encoder) {
		this.password = encoder.encode(this.password);
	}
}
