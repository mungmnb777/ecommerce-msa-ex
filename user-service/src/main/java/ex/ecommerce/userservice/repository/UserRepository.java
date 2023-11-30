package ex.ecommerce.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import ex.ecommerce.userservice.repository.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
