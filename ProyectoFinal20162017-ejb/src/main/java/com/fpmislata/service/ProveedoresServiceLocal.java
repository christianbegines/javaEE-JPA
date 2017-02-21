/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ProveedoresServiceLocal {

    List listProveedores();

    void addProveedor(Proveedor proveedor);

   
    
}
