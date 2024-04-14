/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.dto;

/**
 *
 * @author USER
 */
public class Oferta {
  
    private long id;
    private Mueble mueble;
    private double precioOferta;

    public Oferta() {
        
    }
    
    public Oferta(Mueble mueble, double precioOferta, long id) {
        this.id = id;
        this.mueble = mueble;
        this.precioOferta = precioOferta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    
    
    
    /**
     * @return the mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * @param mueble the mueble to set
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * @return the precioOferta
     */
    public double getPrecioOferta() {
        return precioOferta;
    }

    /**
     * @param precioOferta the precioOferta to set
     */
    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }
    
    
}
