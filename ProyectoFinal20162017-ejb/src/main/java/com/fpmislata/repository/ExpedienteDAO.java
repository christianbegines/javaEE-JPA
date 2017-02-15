/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Expediente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ExpedienteDAO implements ExpedienteDAOLocal {
    
    @PersistenceContext(unitName = "proyectoPU")
    EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listExpedientes() {
        List<Expediente> lista = em.createNamedQuery("expediente.findAll").getResultList();
        return lista;
    }
}
