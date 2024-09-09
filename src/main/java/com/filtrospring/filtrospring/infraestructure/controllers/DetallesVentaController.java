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

import com.filtrospring.filtrospring.application.service.detallesventa.DetallesVentaService;
import com.filtrospring.filtrospring.domain.entities.DetalleVentas;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/detallesventaapi")
public class DetallesVentaController {

    @Autowired
    private DetallesVentaService detallesVentaService;

    @PostMapping
    private ResponseEntity<DetalleVentas> creaEntity(@Valid @RequestBody DetalleVentas detalleVentas){
        DetalleVentas newDetallesVenta = detallesVentaService.save(detalleVentas);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDetallesVenta);
    }

    @GetMapping("/alldetallesventas")
    public ResponseEntity<Page<DetalleVentas>> findAll(Pageable pageable){
        Page<DetalleVentas> detallesVentaPage = detallesVentaService.findAll(pageable);

        if(detallesVentaPage.hasContent()){
            return ResponseEntity.ok(detallesVentaPage);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<DetalleVentas> updateVenta(@Valid @RequestBody DetalleVentas detalleVentas){
        DetalleVentas updateDetallesVenta = detallesVentaService.update(detalleVentas);
        return ResponseEntity.ok(updateDetallesVenta);
        
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDetalleVenta(@RequestParam Long detalleVentaId){
        detallesVentaService.remove(detalleVentaId);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }
}
