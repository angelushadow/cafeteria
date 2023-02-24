package co.cafeteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.cafeteria.entities.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

}
