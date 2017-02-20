/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Proveedor;
import com.fpmislata.service.ProveedoresServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author alumno
 */
@Path("/ProveedoresService")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
@Stateless

public class ProveedorServiceREST {

    @EJB
    private ProveedoresServiceLocal proveedoresService;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @GET
    @Produces({"application/json;charset=UTF-8"})    
    @Path("/Proveedores")
    public List<Proveedor> listProveedores() {
         return proveedoresService.listProveedores();
    }
}
