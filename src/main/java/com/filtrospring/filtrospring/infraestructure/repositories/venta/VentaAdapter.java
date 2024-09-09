package com.filtrospring.filtrospring.infraestructure.repositories.venta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.filtrospring.filtrospring.application.service.ventas.VentasService;
import com.filtrospring.filtrospring.domain.entities.Venta;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VentaAdapter implements VentasService{
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta save(Venta venta){
        return ventaRepository.save(venta);
    }

    @Override
    public Page<Venta> findAll(Pageable pageable){
        return ventaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Venta update(Venta venta){
        if(ventaRepository.existsById(venta.getId())){
            return ventaRepository.save(venta);
        }else{
            throw new EntityNotFoundException("Bicicleta x");
        }
    }

    @Override
    @Transactional
    public void remove(Long id){
        ventaRepository.removeById(id);
    }

}
