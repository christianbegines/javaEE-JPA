/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ClienteDAO implements ClienteDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "proyectoPU")
    EntityManager em;

    @Override
    public List listClientes() {
        List<Cliente> lista = em.createNamedQuery("cliente.findAll").getResultList();
        return lista;
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        return em.find(Cliente.class, cliente.getId());
    }

    
    
    
    
}
