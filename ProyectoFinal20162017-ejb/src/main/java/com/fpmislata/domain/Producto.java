/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chrisianbegines
 */
@Entity
@Table(name="categorias")
@NamedQueries({
@NamedQuery(name="categoria.findAll", query ="SELECT c "
        + " FROM Categoria c ORDER BY c.id")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Producto {
    
}
