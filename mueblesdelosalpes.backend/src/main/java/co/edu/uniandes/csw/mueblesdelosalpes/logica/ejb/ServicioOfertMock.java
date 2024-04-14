/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.logica.ejb;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Oferta;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioOfertaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.mueblesdelosalpes.persistencia.mock.ServicioPersistenciaMock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@Stateless
public class ServicioOfertMock implements IServicioOfertaMockLocal {
    
    
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioOfertMock() {
        persistencia = new ServicioPersistenciaMock();
    }

    @Override
    public void addOfert(Oferta oferta){
        try {
            persistencia.create(oferta);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioOfertMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Oferta> getOferts() {
       return persistencia.findAll(Oferta.class);
    }

    @Override
    public void removeOfert(long id) {
        try {
            Oferta v = (Oferta) persistencia.findById(Oferta.class, id);
            persistencia.delete(v);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioOfertMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
