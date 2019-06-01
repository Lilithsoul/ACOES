/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;

import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.CuentaRepetidaException;
import acoes.negocio.Negocio;
import acoes.negocio.ValidacionIncorrectaException;
import javax.ejb.EJB;
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

    //@Inject
    @EJB
    private Negocio negocio;

    private USUARIO usuario;
    private String repass;
    
    private HISTORIAL_APADRINAMIENTO historial;
    private InfoSesion sesion;
    
    //private String codigoValidacion;

    //private String mensajeValidacion;
    //private boolean validacionOK;

    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    /* public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }*/

    public Registro() {
        usuario = new USUARIO();
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

    public String registrarUsuario() {
        try {
            if (!usuario.getPassword().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                return null;
            }
            negocio.registrarUsuario(usuario);
            registroOK = true;
            return "exitoRegistro.xhtml";
            
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            
        } catch (ACOESException e) {
        }
        return null;
    }
    
    public String registerr(){
        
        return "registroUsuario.xhtml";
    }
    
    public String registrarSocio(USUARIO u) throws ACOESException{
            u.setDireccion(usuario.getDireccion());
            u.setNum_cuenta_bancaria(usuario.getNum_cuenta_bancaria());
            u.setRole(Role.SOCIO);
            negocio.usuarioSocio(u);
            
            return "Home.xhtml";
    }

}
