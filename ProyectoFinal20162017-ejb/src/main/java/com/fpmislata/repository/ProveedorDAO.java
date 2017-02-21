/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ProveedorDAO implements ProveedorDAOLocal {
    
    @PersistenceContext(unitName = "proyectoPU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listProveedores() {
        List<Proveedor> lista = em.createNamedQuery("proveedor.findAll").getResultList();
        return lista;
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
        em.persist(proveedor);
    }
    
    
}

