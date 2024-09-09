package com.filtrospring.filtrospring.infraestructure.repositories.bicicleta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtrospring.filtrospring.domain.entities.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{

    void removeById(Long id);

}

