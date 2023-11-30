package ex.ecommerce.userservice.service.request;

import java.util.UUID;

import ex.ecommerce.userservice.repository.entity.UserEntity;
import lombok.Builder;

@Builder
public record CreateUserServiceRequest(
	String email,
	String name,
	String password
) {

	public UserEntity convert() {
		return UserEntity.builder()
			.email(this.email)
			.name(this.name)
			.password(this.password)
			.userId(UUID.randomUUID().toString())
			.build();
	}
}
