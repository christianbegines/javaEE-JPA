/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.fpmislata.domain.Expediente;
import com.fpmislata.service.ExpedienteServiceLocal;
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
@Path("/ExpedientesService")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
@Stateless
public class ExpedienteServiceREST {

    @EJB
    private ExpedienteServiceLocal expedienteService;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @GET
    @Produces({"application/json;charset=UTF-8"})    
    @Path("/Expedientes")
    public List<Expediente> listExpedientes() {
        return expedienteService.listExpediente();
    }
}
