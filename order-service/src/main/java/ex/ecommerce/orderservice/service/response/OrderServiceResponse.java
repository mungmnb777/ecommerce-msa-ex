package ex.ecommerce.orderservice.service.response;

import java.time.LocalDateTime;

import ex.ecommerce.orderservice.entity.OrderEntity;
import lombok.Builder;

@Builder
public record OrderServiceResponse(
	Long id,
	String productId,
	Integer quantity,
	Integer unitPrice,
	Integer totalPrice,
	String orderId,
	String userId,
	LocalDateTime createdAt
) {
	public static OrderServiceResponse of(OrderEntity entity) {
		return OrderServiceResponse.builder()
			.id(entity.getId())
			.productId(entity.getProductId())
			.quantity(entity.getQuantity())
			.unitPrice(entity.getUnitPrice())
			.totalPrice(entity.getQuantity() * entity.getUnitPrice())
			.orderId(entity.getOrderId())
			.userId(entity.getUserId())
			.createdAt(entity.getCreatedAt())
			.build();
	}
}
