package ex.ecommerce.userservice.service.response;

import ex.ecommerce.userservice.repository.entity.UserEntity;
import lombok.Builder;

@Builder
public record CreateUserServiceResponse(
	Long id,
	String email,
	String name,
	String userId,
	String encryptedPassword
) {
	public static CreateUserServiceResponse of(UserEntity entity) {
		return CreateUserServiceResponse.builder()
			.id(entity.getId())
			.email(entity.getEmail())
			.name(entity.getName())
			.userId(entity.getUserId())
			.encryptedPassword(entity.getPassword())
			.build();
	}
}
