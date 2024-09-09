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

import com.filtrospring.filtrospring.application.service.ventas.VentasService;
import com.filtrospring.filtrospring.domain.entities.Venta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ventaapi")
public class VentaController {


    @Autowired
    private VentasService ventasService;

    @PostMapping
    private ResponseEntity<Venta> creaEntity(@Valid @RequestBody Venta venta){
        Venta newVenta = ventasService.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVenta);
    }

    @GetMapping("/allventas")
    public ResponseEntity<Page<Venta>> findAll(Pageable pageable){
        Page<Venta> ventaPage = ventasService.findAll(pageable);

        if(ventaPage.hasContent()){
            return ResponseEntity.ok(ventaPage);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Venta> updateVenta(@Valid @RequestBody Venta venta){
        Venta updateVenta = ventasService.update(venta);
        return ResponseEntity.ok(updateVenta);
        
    }

    @DeleteMapping
    public ResponseEntity<String> deleteVenta(@RequestParam Long ventaId){
        ventasService.remove(ventaId);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

}
