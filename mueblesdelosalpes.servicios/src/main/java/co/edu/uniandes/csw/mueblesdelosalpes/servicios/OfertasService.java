/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USER
 */
@Path("/Ofertas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OfertasService {
    
    @EJB
    private IServicioOfertaMockLocal ofertaEjb;
    
    
   @GET
   public List<Oferta> getOfertas() {
       return ofertaEjb.getOferts();
   }
   
   @POST
   @Path("add/")
   public void addOfertas(Oferta oferta) {
       ofertaEjb.addOfert(oferta);
   }
   
   @DELETE
   @Path("delete/{id}")
   public void deleteOferta(@PathParam("id") long id){
       ofertaEjb.removeOfert(id);
   }
    
}
