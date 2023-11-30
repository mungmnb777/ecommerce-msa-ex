package ex.ecommerce.orderservice.service;

import java.util.List;

import ex.ecommerce.orderservice.service.request.CreateOrderServiceRequest;
import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;
import ex.ecommerce.orderservice.service.response.OrderServiceResponse;

public interface OrderService {
	CreateOrderServiceResponse createOrder(CreateOrderServiceRequest request);

	List<OrderServiceResponse> getOrdersByUserId(String userId);
}
