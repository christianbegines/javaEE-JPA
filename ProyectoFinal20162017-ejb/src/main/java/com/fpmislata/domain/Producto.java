/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chrisianbegines
 */
@Entity
@Table(name="productos")
@NamedQueries({
@NamedQuery(name="producto.findAll", query ="SELECT p"
        + " FROM Producto p ORDER BY p.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id; 
    
    @ManyToOne
    @JoinColumn(name="categoria")    
    private Categoria categoria;
    
    @Column(nullable=true,length=50)
    private String nombre;
    
    @Column(nullable=true)
    private float precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
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
        final Producto other = (Producto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
    
}
