/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Set;
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
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "cliente.findAll", query = "SELECT c"
            + " FROM Cliente c ORDER BY c.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToMany(mappedBy="clientes")  
    private Set<Proveedor> proveedores;
    
    @Column(name="nombre",length=50, nullable=false)
    private String nombre;
    
    @Column(name="apellidos",length=100,nullable=false)
    private String apellidos;
    
    @Column(name="nif",length=9,nullable=false)
    private String nif;
    
    @Column(name="direccion",length=100,nullable=true)
    private String direccion;
    
    @Column(name="poblacion",length=100,nullable=true)
    private String poblacion;
    
    @Column(name="codigo_postal",length=5,nullable=true)
    private String codigoPostal;
    
    @Column(name="provincia",length=100,nullable=true)
    private String provincia;
    
    @Column(name="telefono",length=9,nullable=false)
    private String telefono;    
  

    public Cliente() {
    }

    public Cliente(int id, Set<Proveedor> proveedores, String nombre, String apellidos, String nif, String direccion, String poblacion, String codigoPostal, String provincia, String telefono) {
        this.id = id;
        this.proveedores = proveedores;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.telefono = telefono;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal + ", provincia=" + provincia + ", telefono=" + telefono +  '}';
    }

    
}
