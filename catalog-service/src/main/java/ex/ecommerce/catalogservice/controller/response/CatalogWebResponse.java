package ex.ecommerce.catalogservice.controller.response;

import java.time.LocalDateTime;

import ex.ecommerce.catalogservice.service.response.CatalogServiceResponse;
import lombok.Builder;

@Builder
public record CatalogWebResponse(
	Long id,
	String productId,
	String productName,
	Integer stock,
	Integer unitPrice,
	Integer totalPrice,
	LocalDateTime createdAt
) {
	public static CatalogWebResponse of(CatalogServiceResponse response) {
		return CatalogWebResponse.builder()
			.id(response.id())
			.productId(response.productId())
			.productName(response.productName())
			.stock(response.stock())
			.unitPrice(response.unitPrice())
			.totalPrice(response.stock() * response.unitPrice())
			.createdAt(response.createdAt())
			.build();
	}
}
