package com.filtrospring.filtrospring.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_ventas")
public class DetalleVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta ventas;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicletas;

    @Column(columnDefinition = "INT", nullable = false)
    private Long cantidad;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double precio_unitario;

    public DetalleVentas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVentas() {
        return ventas;
    }

    public void setVentas(Venta ventas) {
        this.ventas = ventas;
    }

    public Bicicleta getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(Bicicleta bicicletas) {
        this.bicicletas = bicicletas;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    

}
