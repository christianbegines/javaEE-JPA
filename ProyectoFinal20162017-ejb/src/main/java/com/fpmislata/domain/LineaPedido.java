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
 * @author christian
 */
@Entity
@Table(name="lineas_pedido")
@NamedQueries({
@NamedQuery(name="LineaPedido.findAll", query ="SELECT l "
        + " FROM  LineaPedido l ORDER BY l.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LineaPedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_lineas_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    
    @ManyToOne
    @JoinColumn(name="pedido")
    private Pedido pedido;
    
    @Column(nullable=false, length=50)
    private String producto;
    
    @Column(nullable=false)
    private int cantidad;
    
    @Column(nullable=false)
    private float precio;

    public LineaPedido() {
    }

    public LineaPedido(Pedido pedido, String producto, int cantidad, float precio) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
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
        final LineaPedido other = (LineaPedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
}
