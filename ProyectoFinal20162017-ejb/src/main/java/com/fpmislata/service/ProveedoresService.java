/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Proveedor;
import com.fpmislata.repository.ProveedorDAOLocal;
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
public class ProveedoresService implements ProveedoresServiceLocal {

    @EJB
    private ProveedorDAOLocal proveedorDAO;
    
    
    @Resource
    private SessionContext contexto;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listProveedores() {
        try{
            return proveedorDAO.listProveedores();
        }catch(Exception e){
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
        try{
            proveedorDAO.addProveedor(proveedor);
        }catch(Exception e){
            contexto.setRollbackOnly();
            e.printStackTrace();   
        }
    }
    
    
    
}
