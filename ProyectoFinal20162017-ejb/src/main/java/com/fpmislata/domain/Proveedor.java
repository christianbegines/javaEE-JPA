package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
@Entity
@Table(name="proveedores")
@NamedQueries({
@NamedQuery(name="proveedor.findAll", query ="SELECT p"
        + " FROM Proveedor p ORDER BY p.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id; 
    
    @Column(name="nombre",length=50,nullable=true)
    private String nombre;
    
    @Column(name="direccion",length=50,nullable=true)
    private String direccion;
    
    @Column(name="telefono",length=9,nullable=true)
    private String telefono;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="proveedor-cliente",
            joinColumns=@JoinColumn(name="proveedor"),
            inverseJoinColumns=@JoinColumn(name="cliente"))    
    private Set<Cliente> clientes;

    public Proveedor() {
    }

    public Proveedor(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", clientes=" + clientes + '}';
    }
    
    
}
