package ex.ecommerce.userservice.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.ecommerce.userservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserId(String userId);
}
