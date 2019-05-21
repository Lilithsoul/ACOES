/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.ENVIOS;
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
@Named(value = "envioNuevo")
@RequestScoped
public class envioNuevo {
    
    private ENVIOS envio;

    public ENVIOS getEnvio() {
        return envio;
    }

    public void setEnvio(ENVIOS envio) {
        this.envio = envio;
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
    public envioNuevo() {
      //Implementar
    }
    
    public String enviar(){
        
        // Crear nuevo socio a partir del Usuario registrado

        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Envio incorrecto", "El usuario especificado no existe o la constraseña es incorrecta"));
         
        return null;
    }
}
