package ex.ecommerce.orderservice.controller.request;

import ex.ecommerce.orderservice.service.request.CreateOrderServiceRequest;

public record CreateOrderWebRequest(
	String productId,
	Integer quantity,
	Integer unitPrice,
	String userId
) {
	public CreateOrderServiceRequest convert() {
		return CreateOrderServiceRequest.builder()
			.productId(this.productId)
			.quantity(this.quantity)
			.unitPrice(this.unitPrice)
			.userId(this.userId)
			.build();
	}
}
