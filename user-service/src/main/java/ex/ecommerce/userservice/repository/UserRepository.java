package ex.ecommerce.userservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ex.ecommerce.userservice.repository.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserId(String userId);
}
