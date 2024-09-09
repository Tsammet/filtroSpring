package com.filtrospring.filtrospring.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "date", nullable = false)
    public Date fecha;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    public Proveedor proveedores;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    public Double total;

    public Compras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedor proveedores) {
        this.proveedores = proveedores;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    
}
