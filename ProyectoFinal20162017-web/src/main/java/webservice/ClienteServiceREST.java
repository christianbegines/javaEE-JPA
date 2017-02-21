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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    
    @POST
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    @Path("/Clientes/add")
    public Response addCliente(Cliente cliente) {
        try {
            clienteService.addCliente(cliente);
            return Response.ok().entity(cliente)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"))
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8"))
                    .build();
        }
    }
    
    
    
    
}
