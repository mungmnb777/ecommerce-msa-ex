package ex.ecommerce.userservice.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.ecommerce.userservice.controller.request.SignUpWebRequest;
import ex.ecommerce.userservice.controller.response.SignUpWebResponse;
import ex.ecommerce.userservice.controller.response.UserWebResponse;
import ex.ecommerce.userservice.service.UserService;
import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;
import ex.ecommerce.userservice.service.response.GetUserServiceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<SignUpWebResponse> createUser(@Valid @RequestBody SignUpWebRequest request) {
		CreateUserServiceResponse response = userService.create(request.convert());

		return ResponseEntity
			.created(URI.create("/users/" + response.id()))
			.body(SignUpWebResponse.of(response));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserWebResponse> getUser(@PathVariable String userId) {
		GetUserServiceResponse response = userService.getUserById(userId);

		return ResponseEntity.ok(UserWebResponse.of(response));
	}
}
