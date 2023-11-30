package ex.ecommerce.catalogservice.service.response;

import java.time.LocalDateTime;

import ex.ecommerce.catalogservice.entity.CatalogEntity;
import lombok.Builder;

@Builder
public record CatalogServiceResponse(
	Long id,
	String productId,
	String productName,
	Integer stock,
	Integer unitPrice,
	Integer totalPrice,
	LocalDateTime createdAt
) {
	public static CatalogServiceResponse of(CatalogEntity entity) {
		return CatalogServiceResponse.builder()
			.id(entity.getId())
			.productId(entity.getProductId())
			.productName(entity.getProductName())
			.stock(entity.getStock())
			.unitPrice(entity.getUnitPrice())
			.totalPrice(entity.getStock() * entity.getUnitPrice())
			.createdAt(entity.getCreatedAt())
			.build();
	}
}
