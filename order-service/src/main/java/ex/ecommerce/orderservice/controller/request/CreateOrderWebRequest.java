package ex.ecommerce.orderservice.controller.request;

import ex.ecommerce.orderservice.service.request.CreateOrderServiceRequest;

public record CreateOrderWebRequest(
	String productId,
	Integer quantity,
	Integer unitPrice
) {
	public CreateOrderServiceRequest convert() {
		return CreateOrderServiceRequest.builder()
			.productId(this.productId)
			.quantity(this.quantity)
			.unitPrice(this.unitPrice)
			.build();
	}
}
