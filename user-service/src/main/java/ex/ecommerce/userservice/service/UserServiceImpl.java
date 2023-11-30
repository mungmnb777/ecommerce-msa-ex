package ex.ecommerce.userservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ex.ecommerce.userservice.entity.repository.UserRepository;
import ex.ecommerce.userservice.entity.UserEntity;
import ex.ecommerce.userservice.service.request.CreateUserServiceRequest;
import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;
import ex.ecommerce.userservice.service.response.GetUserServiceResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;

	@Override
	public CreateUserServiceResponse create(CreateUserServiceRequest request) {
		UserEntity entity = request.convert();
		entity.encrypt(encoder);

		UserEntity savedEntity = userRepository.save(entity);
		return CreateUserServiceResponse.of(savedEntity);
	}

	@Override
	public GetUserServiceResponse getUserById(String userId) {
		UserEntity entity = userRepository.findByUserId(userId).orElseThrow(IllegalArgumentException::new);
		return GetUserServiceResponse.of(entity);
	}

	@Override
	public List<GetUserServiceResponse> getAllUsers() {
		List<UserEntity> entities = userRepository.findAll();
		return entities.stream()
			.map(GetUserServiceResponse::of)
			.collect(Collectors.toList());
	}
}
