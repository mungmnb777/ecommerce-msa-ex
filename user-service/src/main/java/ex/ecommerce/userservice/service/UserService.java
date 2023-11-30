package ex.ecommerce.userservice.service;

import ex.ecommerce.userservice.service.request.CreateUserServiceRequest;
import ex.ecommerce.userservice.service.response.CreateUserServiceResponse;

public interface UserService {
	CreateUserServiceResponse create(CreateUserServiceRequest request);
}
