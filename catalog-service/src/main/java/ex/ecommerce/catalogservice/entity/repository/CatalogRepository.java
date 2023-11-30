package ex.ecommerce.catalogservice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ex.ecommerce.catalogservice.entity.CatalogEntity;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
