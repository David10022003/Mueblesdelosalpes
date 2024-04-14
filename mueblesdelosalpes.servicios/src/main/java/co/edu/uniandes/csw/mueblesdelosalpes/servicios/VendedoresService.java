/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb.ServicioVendedoresMock;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USER
 */
@Path("/Vendedores")
@Stateful
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendedoresService {
    @EJB
    private IServicioVendedoresMockLocal vendedoresEjb
            = new ServicioVendedoresMock();
    
    
    @Path("add/")
    @POST    
    public void agregarVendedor(Vendedor vendedor){
        try {
            vendedoresEjb.agregarVendedor(vendedor);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(VendedoresService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @DELETE
    @Path("delete/{id}")
    public void eliminarVendedor(@PathParam("id") long id) {
        try {
            vendedoresEjb.eliminarVendedor(id);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(VendedoresService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    public List<Vendedor> getVendedores(){
        return vendedoresEjb.getVendedores();
    } 
    
    
}
