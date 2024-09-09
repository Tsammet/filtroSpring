package com.filtrospring.filtrospring.infraestructure.repositories.detallesventa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.filtrospring.filtrospring.application.service.detallesventa.DetallesVentaService;
import com.filtrospring.filtrospring.domain.entities.DetalleVentas;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DetalleVentaAdapter implements DetallesVentaService{

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVentas save(DetalleVentas detalleVentas){
        return detalleVentaRepository.save(detalleVentas);
    }

    @Override
    public Page<DetalleVentas> findAll(Pageable pageable){
        return detalleVentaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public DetalleVentas update(DetalleVentas detalleVentas){
        if(detalleVentaRepository.existsById(detalleVentas.getId())){
            return detalleVentaRepository.save(detalleVentas);
        }else{
            throw new EntityNotFoundException("Bicicleta x");
        }
    }

    @Override
    @Transactional
    public void remove(Long id){
        detalleVentaRepository.removeById(id);
    }
}
