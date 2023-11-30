package ex.ecommerce.userservice.controller.response;

import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;
import ex.ecommerce.userservice.service.response.GetUserServiceResponse;
import lombok.Builder;

@Builder
public record UserWebResponse(
	Long id,
	String email,
	String name,
	String userId
) {
	public static UserWebResponse of(GetUserServiceResponse response) {
		return UserWebResponse.builder()
			.id(response.id())
			.email(response.email())
			.name(response.name())
			.userId(response.userId())
			.build();
	}
}
