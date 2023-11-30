package ex.ecommerce.orderservice.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.ecommerce.orderservice.controller.request.CreateOrderWebRequest;
import ex.ecommerce.orderservice.controller.response.CreateOrderWebResponse;
import ex.ecommerce.orderservice.controller.response.OrderWebResponse;
import ex.ecommerce.orderservice.service.OrderService;
import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;
import ex.ecommerce.orderservice.service.response.OrderServiceResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<CreateOrderWebResponse> createOrder(@RequestBody CreateOrderWebRequest request) {
		CreateOrderServiceResponse response = orderService.createOrder(request.convert());

		return ResponseEntity.created(URI.create("/orders/" + response.orderId()))
			.body(CreateOrderWebResponse.of(response));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<OrderWebResponse>> getOrder(@PathVariable String userId) {
		List<OrderServiceResponse> response = orderService.getOrdersByUserId(userId);

		return ResponseEntity.ok(
			response.stream()
				.map(OrderWebResponse::of)
				.collect(Collectors.toList())
		);
	}
}
