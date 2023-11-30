package ex.ecommerce.orderservice.entity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.ecommerce.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	Optional<OrderEntity> findByOrderId(String orderId);

	List<OrderEntity> findByUserId(String userId);
}
