package com.filtrospring.filtrospring.application.service.detallesventa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.filtrospring.filtrospring.domain.entities.DetalleVentas;

public interface DetallesVentaService {

    DetalleVentas save(DetalleVentas detalleVentas);

    Page<DetalleVentas> findAll(Pageable pageable);

    DetalleVentas update(DetalleVentas detalleVentas);

    void remove(Long id);
}
