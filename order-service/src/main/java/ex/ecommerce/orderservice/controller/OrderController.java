package ex.ecommerce.orderservice.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.ecommerce.orderservice.controller.request.CreateOrderWebRequest;
import ex.ecommerce.orderservice.controller.response.CreateOrderWebResponse;
import ex.ecommerce.orderservice.service.OrderService;
import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;
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
}
