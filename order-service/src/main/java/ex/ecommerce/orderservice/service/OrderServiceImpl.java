package ex.ecommerce.orderservice.service;

import org.springframework.stereotype.Service;

import ex.ecommerce.orderservice.entity.OrderEntity;
import ex.ecommerce.orderservice.entity.repository.OrderRepository;
import ex.ecommerce.orderservice.service.request.CreateOrderServiceRequest;
import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	@Override
	public CreateOrderServiceResponse createOrder(CreateOrderServiceRequest request) {
		OrderEntity entity = request.convert();

		OrderEntity savedEntity = orderRepository.save(entity);
		return CreateOrderServiceResponse.of(savedEntity);
	}
}
