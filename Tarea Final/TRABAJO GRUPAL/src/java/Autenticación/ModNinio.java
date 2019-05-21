/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.ADMINISTRADOR;
import acoes.CCJ;
import acoes.HISTORIAL_APADRINAMIENTO;
import acoes.JOVEN_NIÑO;
import acoes.SOCIO;
import acoes.USUARIO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "aniadirNinio")
@RequestScoped
public class ModNinio {
    
    private JOVEN_NIÑO n;

    public JOVEN_NIÑO getN() {
        return n;
    }

    public void setN(JOVEN_NIÑO n) {
        this.n = n;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    
    
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Apadrinar
     */
    public ModNinio() {
        
        Date fecha = new Date(110, 5,3);
        Date fecha2 = new Date(112, 5,3);
        CCJ c = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        
        List<JOVEN_NIÑO> ninios = new ArrayList<JOVEN_NIÑO>();
        
        JOVEN_NIÑO n3 = new JOVEN_NIÑO("Paco", "Suárez", "Gutiérrez", "Bolivia", "Sin hogar", fecha, c);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2, c);
        
        ninios.add(n3);
        ninios.add(n2);
        
        /*
        
        historiales = new ArrayList<HISTORIAL_APADRINAMIENTO>();
        
        HISTORIAL_APADRINAMIENTO hp1 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, socio);
        //hp1.add(fecha, fecha2, true, n2, socio);
        HISTORIAL_APADRINAMIENTO hp2 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, socio);
        
        historiales.add(hp1);
        historiales.add(hp2);
        
        */
         
    }

    public String aniadir() throws ParseException {  // Pasar parámetros del login
        
        
                
        
         // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir a un niño, inténtelo más tarde", "No ha sido posible añadir a un niño, inténtelo más tarde"));
        
        
        
        return null;
        
    }
    
    public String editar() throws ParseException {  // Pasar parámetros del login
        
        
                
        
         // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar a un niño, inténtelo más tarde", "No ha sido posible editar a un niño, inténtelo más tarde"));
        
        
        
        return null;
        
    }
    
    public String eliminar() throws ParseException {  // Pasar parámetros del login
        
        
                
        
         // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar a un niño, inténtelo más tarde", "No ha sido posible eliminar a un niño, inténtelo más tarde"));
        
        
        
        return null;
        
    }
        
}