package ex.ecommerce.orderservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

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
@Table(name = "orders")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String productId;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private Integer unitPrice;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, unique = true)
	private String orderId;

	@Column(nullable = false, updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@Builder
	public OrderEntity(Long id, String productId, Integer quantity, Integer unitPrice, String userId, String orderId, LocalDateTime createdAt) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.userId = userId;
		this.orderId = orderId;
		this.createdAt = createdAt;
	}
}
