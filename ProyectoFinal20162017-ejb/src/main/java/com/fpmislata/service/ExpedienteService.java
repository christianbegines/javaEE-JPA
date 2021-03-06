/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.repository.ExpedienteDAOLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ExpedienteService implements ExpedienteServiceLocal {

    @EJB
    private ExpedienteDAOLocal expedienteDAO;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List listExpediente() {
        return expedienteDAO.listExpedientes();
    }
    
   
}
