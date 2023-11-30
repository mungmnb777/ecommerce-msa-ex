package ex.ecommerce.orderservice.service;

import ex.ecommerce.orderservice.service.request.CreateOrderServiceRequest;
import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;

public interface OrderService {
	CreateOrderServiceResponse createOrder(CreateOrderServiceRequest request);
}
