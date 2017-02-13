/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;


import com.fpmislata.domain.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductoDAO implements ProductoDAOLocal {
    @PersistenceContext(unitName = "proyectoPU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Producto> listProductos() {
         List<Producto> lista = em.createNamedQuery("producto.findAll").getResultList();
        return lista;
    }

    @Override
    public Producto findProductoById(Producto producto) {
       return em.find(Producto.class,producto.getId());
    }
    
    
    
    
}
