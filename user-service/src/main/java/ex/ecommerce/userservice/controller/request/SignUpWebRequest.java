package ex.ecommerce.userservice.controller.request;

import ex.ecommerce.userservice.service.request.CreateUserServiceRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record SignUpWebRequest(

	@NotNull(message = "이메일을 반드시 입력해주세요.")
	@Email(message = "이메일 포맷을 지켜 전송해주세요.")
	String email,

	@NotNull(message = "이름을 반드시 입력해주세요.")
	@Size(min = 2, max = 8, message = "이름을 2 ~ 8글자로 입력해주세요.")
	String name,

	@NotNull(message = "비밀번호를 반드시 입력해주세요.")
	@Size(min = 8, max = 16, message = "비밀번호를 8 ~ 16글자로 입력해주세요.")
	@Pattern(
		regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).*",
		message = "영문, 숫자, 특수문자가 반드시 조합되어야 합니다.")
	String password
) {

	public CreateUserServiceRequest convert() {
		return CreateUserServiceRequest.builder()
			.email(this.email)
			.name(this.name)
			.password(this.password)
			.build();
	}
}
