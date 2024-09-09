package com.filtrospring.filtrospring.infraestructure.repositories.bicicleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.filtrospring.filtrospring.application.service.bicicleta.BicicletaService;
import com.filtrospring.filtrospring.domain.entities.Bicicleta;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BicicletaAdapter implements BicicletaService{

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @Override
    public Bicicleta save(Bicicleta bicicleta){
        return bicicletaRepository.save(bicicleta);
    }

    @Override
    public Page<Bicicleta> findAll(Pageable pageable){
        return bicicletaRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Bicicleta update(Bicicleta bicicleta){
        if(bicicletaRepository.existsById(bicicleta.getId())){
            return bicicletaRepository.save(bicicleta);
        }else{
            throw new EntityNotFoundException("Bicicleta x");
        }
    }

    @Override
    @Transactional
    public void remove(Long id){
        bicicletaRepository.removeById(id);
    }

}
