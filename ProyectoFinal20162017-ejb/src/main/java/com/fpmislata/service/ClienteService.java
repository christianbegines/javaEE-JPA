/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.repository.ClienteDAOLocal;
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
public class ClienteService implements ClienteServiceLocal {

    @EJB
    private ClienteDAOLocal clienteDAO;
    
    
    @Resource
    private SessionContext contexto;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listClientes() {
       try{
            return clienteDAO.listClientes();
        }catch(Exception e){
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        try{
            return clienteDAO.findClienteById(cliente);
        }catch(Exception e){
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCliente(Cliente cliente) {
        try{
            clienteDAO.addCliente(cliente);
        }catch(Exception e){
            contexto.setRollbackOnly();
            e.printStackTrace();
            
            
        }
    }
    
    
    
    
    
    
    
}
