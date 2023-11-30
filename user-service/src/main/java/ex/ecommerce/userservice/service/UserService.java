package ex.ecommerce.userservice.service;

import java.util.List;

import ex.ecommerce.userservice.service.request.CreateUserServiceRequest;
import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;
import ex.ecommerce.userservice.service.response.GetUserServiceResponse;

public interface UserService {
	CreateUserServiceResponse create(CreateUserServiceRequest request);

	GetUserServiceResponse getUserById(String userId);

	List<GetUserServiceResponse> getAllUsers();
}
