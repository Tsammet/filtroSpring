package com.filtrospring.filtrospring.application.service.ventas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.filtrospring.filtrospring.domain.entities.Venta;

public interface VentasService {

    Venta save(Venta venta);

    Page<Venta> findAll(Pageable pageable);

    Venta update(Venta venta);

    void remove(Long id);
}
