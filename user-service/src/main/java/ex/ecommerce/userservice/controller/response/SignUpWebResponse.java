package ex.ecommerce.userservice.controller.response;

import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;
import lombok.Builder;

@Builder
public record SignUpWebResponse(
	Long id,
	String email,
	String name,
	String userId,
	String encryptedPassword
) {
	public static SignUpWebResponse of(CreateUserServiceResponse response) {
		return SignUpWebResponse.builder()
			.id(response.id())
			.email(response.email())
			.name(response.name())
			.userId(response.userId())
			.encryptedPassword(response.encryptedPassword())
			.build();
	}
}
