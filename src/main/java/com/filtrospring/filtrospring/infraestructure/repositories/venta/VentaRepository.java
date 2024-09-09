package com.filtrospring.filtrospring.infraestructure.repositories.venta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtrospring.filtrospring.domain.entities.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

    void removeById(Long id);

}
