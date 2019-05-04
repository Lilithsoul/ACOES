/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.SOCIO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "formularioSocio")
@RequestScoped
public class SerSocio {
    
    private SOCIO socio;

    public SOCIO getSocio() {
        return socio;
    }

    public void setSocio(SOCIO socio) {
        this.socio = socio;
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
     * Creates a new instance of Login
     */
    public SerSocio() {
      
    }

    public String serSocio(){
        
        // Crear nuevo socio a partir del Usuario registrado

        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario especificado no existe o la constraseña es incorrecta", "El usuario especificado no existe o la constraseña es incorrecta"));
         
        return null;
    }
}
