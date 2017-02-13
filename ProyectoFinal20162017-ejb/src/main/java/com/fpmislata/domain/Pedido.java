/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alumno
 */
@Entity
@Table(name="pedidos")
@NamedQueries({
@NamedQuery(name="pedido.findAll", query ="SELECT p "
        + " FROM Pedido p ORDER BY p.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pedido implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    
    @OneToMany(mappedBy="pedido",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @XmlTransient
    private Set<LineaPedido> lineas;
    
    @Column(nullable=false,length=50)
    private String descripcion;
    
    @Column(nullable=false)
    private int estado;

    public Pedido() {
        lineas= new HashSet<LineaPedido>();
    }

    public Pedido(String descripcion, int estado) {
        this.descripcion = descripcion;
        this.estado = estado;
        lineas= new HashSet<LineaPedido>();  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Set<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(Set<LineaPedido> lineas) {
        this.lineas = lineas;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", lineas=" + lineas + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    
    
}
