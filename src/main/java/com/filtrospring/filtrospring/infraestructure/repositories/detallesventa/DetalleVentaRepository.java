package com.filtrospring.filtrospring.infraestructure.repositories.detallesventa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtrospring.filtrospring.domain.entities.DetalleVentas;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentas,Long>{

    void removeById(Long id);

}
