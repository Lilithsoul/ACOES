/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.CASA_POPULORUM;
import acoes.CCJ;
import acoes.JOVEN_NIÑO;
import java.text.ParseException;
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
@Named(value = "modPopulorum")
@RequestScoped
public class ModPopulorum {
    
    private CASA_POPULORUM cp;

    private List<CASA_POPULORUM> populorums;

    public CASA_POPULORUM getCp() {
        return cp;
    }

    public void setCp(CASA_POPULORUM cp) {
        this.cp = cp;
    }
    

    public List<CASA_POPULORUM> getPopulorums() {
        return populorums;
    }

    public void setPopulorums(List<CASA_POPULORUM> populorumss) {
        this.populorums = populorumss;
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
    public ModPopulorum() {
        
        Date fecha = new Date(110, 5,3);
        Date fecha2 = new Date(112, 5,3);
        CCJ c = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        
        CASA_POPULORUM p1 = new CASA_POPULORUM("Casa la Juan", "Ecuador", 6);
        CASA_POPULORUM p2 = new CASA_POPULORUM("Casa Manolete", "Ecuador", 32);
        
        JOVEN_NIÑO n3 = new JOVEN_NIÑO("Paco", "Suárez", "Gutiérrez", "Bolivia", "Sin hogar", fecha, c);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2, c);
        
        n2.setCp(p1);
        n3.setCp(p2);
        
        populorums = new ArrayList<CASA_POPULORUM>();
        
        populorums.add(p1);
        populorums.add(p2);
         
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