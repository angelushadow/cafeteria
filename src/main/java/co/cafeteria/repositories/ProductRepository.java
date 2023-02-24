package co.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.cafeteria.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
