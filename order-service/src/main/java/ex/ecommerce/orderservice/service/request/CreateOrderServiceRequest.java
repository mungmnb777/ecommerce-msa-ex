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
			.productId(this.productId)
			.quantity(this.quantity)
			.unitPrice(this.unitPrice)
			.orderId(UUID.randomUUID().toString())
			.userId(this.userId)
			.build();
	}
}
