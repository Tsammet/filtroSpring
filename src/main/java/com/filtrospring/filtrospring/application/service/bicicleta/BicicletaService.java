package com.filtrospring.filtrospring.application.service.bicicleta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.filtrospring.filtrospring.domain.entities.Bicicleta;

public interface BicicletaService {

    Bicicleta save(Bicicleta bicicleta);

    Page<Bicicleta> findAll(Pageable pageable);

    Bicicleta update(Bicicleta bicicleta);

    void remove(Long id);
}
