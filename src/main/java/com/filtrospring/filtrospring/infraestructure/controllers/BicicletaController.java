package com.filtrospring.filtrospring.infraestructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filtrospring.filtrospring.application.service.bicicleta.BicicletaService;
import com.filtrospring.filtrospring.domain.entities.Bicicleta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bicicletaapi")
public class BicicletaController {

    @Autowired
    private BicicletaService bicicletaService;

    @PostMapping
    private ResponseEntity<Bicicleta> creaEntity(@Valid @RequestBody Bicicleta bicicleta){
        Bicicleta newBicicleta = bicicletaService.save(bicicleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBicicleta);
    }

    @GetMapping("/allbicicletas")
    public ResponseEntity<Page<Bicicleta>> findAll(Pageable pageable){
        Page<Bicicleta> BicicletaPage = bicicletaService.findAll(pageable);

        if(BicicletaPage.hasContent()){
            return ResponseEntity.ok(BicicletaPage);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Bicicleta> updateBici(@Valid @RequestBody Bicicleta bicicleta){
        Bicicleta updateBicicleta = bicicletaService.update(bicicleta);
        return ResponseEntity.ok(updateBicicleta);
        
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBici(@RequestParam Long bicicletaId){
        bicicletaService.remove(bicicletaId);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

}
