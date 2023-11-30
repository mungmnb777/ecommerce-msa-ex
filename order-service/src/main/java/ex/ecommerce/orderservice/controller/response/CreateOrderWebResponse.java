package ex.ecommerce.orderservice.controller.response;

import ex.ecommerce.orderservice.service.response.CreateOrderServiceResponse;
import lombok.Builder;

@Builder
public record CreateOrderWebResponse(
	Long id,
	String productId,
	Integer quantity,
	Integer unitPrice,
	Integer totalPrice,
	String orderId,
	String userId
) {
	public static CreateOrderWebResponse of(CreateOrderServiceResponse response) {
		return CreateOrderWebResponse.builder()
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
