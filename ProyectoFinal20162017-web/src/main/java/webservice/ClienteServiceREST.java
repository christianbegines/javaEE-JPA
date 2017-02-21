/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Cliente;
import com.fpmislata.service.ClienteServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author christian
 */
@Path("/ClientesService")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
@Stateless
public class ClienteServiceREST {

    @EJB
    private ClienteServiceLocal clienteService;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @GET
    @Produces({"application/json;charset=UTF-8"})    
    @Path("/Clientes")
    public List<Cliente> listClientes() {
        return clienteService.listClientes();
    }

    
    
    @GET
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Clientes/findClienteById/{id}")
    public Cliente findClienteById(@PathParam("id")int id) {
        Cliente c = new Cliente();
        c.setId(id);
        return clienteService.findClienteById(c);
        
    }
    
    
    
}
