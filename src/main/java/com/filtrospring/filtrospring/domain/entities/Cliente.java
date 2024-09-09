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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private Long telefono;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudades;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ciudad getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudad ciudades) {
        this.ciudades = ciudades;
    }


}
