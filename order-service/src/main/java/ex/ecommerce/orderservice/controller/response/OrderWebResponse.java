package ex.ecommerce.orderservice.controller.response;

import ex.ecommerce.orderservice.service.response.OrderServiceResponse;
import lombok.Builder;

@Builder
public record OrderWebResponse(
	Long id,
	String productId,
	Integer quantity,
	Integer unitPrice,
	Integer totalPrice,
	String orderId,
	String userId
) {
	public static OrderWebResponse of(OrderServiceResponse response) {
		return OrderWebResponse.builder()
			.id(response.id())
			.productId(response.productId())
			.quantity(response.quantity())
			.unitPrice(response.unitPrice())
			.totalPrice(response.totalPrice())
			.orderId(response.orderId())
			.userId(response.userId())
			.build();
	}
}
