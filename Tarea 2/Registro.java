/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticacion;

import acoes.ADMINISTRADOR;
import acoes.USUARIO;
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
@Named(value = "registro")
@RequestScoped
public class Registro {
    
    private USUARIO usuario;

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
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
    public Registro() {
      
    }

    public String registrar(){
        // llamar a negocio para crear usuario
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario especificado no existe o la constraseña es incorrecta", "El usuario especificado no existe o la constraseña es incorrecta"));
         
        return null;
    }
}
