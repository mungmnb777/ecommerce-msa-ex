package ex.ecommerce.userservice.service.response;

import ex.ecommerce.userservice.repository.entity.UserEntity;
import lombok.Builder;

@Builder
public record GetUserServiceResponse(
	Long id,
	String email,
	String name,
	String userId
) {
	public static GetUserServiceResponse of(UserEntity entity) {
		return GetUserServiceResponse.builder()
			.id(entity.getId())
			.email(entity.getEmail())
			.name(entity.getName())
			.userId(entity.getUserId())
			.build();
	}
}
