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
@Table(name = "detalles_compras")
public class DetallesCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private Repuesto repuestos;

    @Column(columnDefinition = "INT", nullable = false)
    private Long cantidad;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double precio_unitario;

    public DetallesCompras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Repuesto getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(Repuesto repuestos) {
        this.repuestos = repuestos;
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
