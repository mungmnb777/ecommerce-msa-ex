package ex.ecommerce.catalogservice.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "catalog")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CatalogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120, unique = true)
	private String productId;

	@Column(nullable = false)
	private String productName;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private Integer unitPrice;

	@Column(nullable = false, updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@Builder
	public CatalogEntity(Long id, String productId, String productName, Integer stock, Integer unitPrice) {
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.stock = stock;
		this.unitPrice = unitPrice;
	}
}
