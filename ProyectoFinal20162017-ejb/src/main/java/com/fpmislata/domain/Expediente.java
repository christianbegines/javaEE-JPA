/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "expedientes")
@NamedQueries({
    @NamedQuery(name = "expediente.findAll", query = "SELECT e"
            + " FROM Expediente e ORDER BY e.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Expediente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_expediente")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="cliente")
    private Cliente cliente;
    
    @Column(name="numero_cuenta",nullable=false)
    private int numeroCuenta;
    
    @Column(name="fecha_subscripcion",nullable=false)
    private Timestamp fechasubscripcion;

    public Expediente() {
    }

    public Expediente(int id, Cliente cliente, int numeroCuenta, Timestamp fechasubscripcion) {
        this.id = id;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.fechasubscripcion = fechasubscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Timestamp getFechasubscripcion() {
        return fechasubscripcion;
    }

    public void setFechasubscripcion(Timestamp fechasubscripcion) {
        this.fechasubscripcion = fechasubscripcion;
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
        final Expediente other = (Expediente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Expediente{" + "id=" + id + ", cliente=" + cliente + ", numeroCuenta=" + numeroCuenta + ", fechasubscripcion=" + fechasubscripcion + '}';
    }
    
    
    
}
