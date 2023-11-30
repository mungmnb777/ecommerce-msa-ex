package ex.ecommerce.orderservice.service.request;

import java.util.UUID;

import ex.ecommerce.orderservice.entity.OrderEntity;
import lombok.Builder;

@Builder
public record CreateOrderServiceRequest(
	String productId,
	Integer quantity,
	Integer unitPrice,
	String orderId,
	String userId
) {
	public OrderEntity convert() {
		return OrderEntity.builder()
			.productId(productId)
			.quantity(quantity)
			.unitPrice(unitPrice)
			.orderId(UUID.randomUUID().toString())
			.userId(UUID.randomUUID().toString())
			.build();
	}
}
