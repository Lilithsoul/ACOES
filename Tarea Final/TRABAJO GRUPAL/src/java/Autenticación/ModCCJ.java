/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.CCJ;
import java.text.ParseException;
import java.util.ArrayList;
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
@Named(value = "modCCJ")
@RequestScoped
public class ModCCJ {

    private CCJ ccj;
    
    private List<CCJ> ccjs;

    public CCJ getCcj() {
        return ccj;
    }

    public void setCcj(CCJ ccj) {
        this.ccj = ccj;
    }

    public List<CCJ> getCcjs() {
        return ccjs;
    }

    public void setCcjs(List<CCJ> ccjs) {
        this.ccjs = ccjs;
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
    public ModCCJ() {
        
        CCJ c1 = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        CCJ c2 = new CCJ("Santa Lupita2", "Ecuador", "Elipa2", "C/ Rosa2", "242314", "ccj@uma.es", "Colegio nuevo2");
        
        ccjs = new ArrayList<CCJ>();
        
        ccjs.add(c1);
        ccjs.add(c2);
         
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