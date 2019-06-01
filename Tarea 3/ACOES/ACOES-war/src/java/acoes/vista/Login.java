/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;

import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.ContraseniaInvalidaException;
import acoes.negocio.CuentaInactivaException;
import acoes.negocio.CuentaInexistenteException;
import acoes.negocio.Negocio;
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
@Named(value = "login")
@RequestScoped
public class Login {

    @Inject
    private Negocio negocio;

    @Inject
    private InfoSesion sesion;

    private USUARIO usuario;

    /**
     * Creates a new instance of login
     */
    public Login() {
        usuario = new USUARIO();
    }

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
        try {
            negocio.compruebaLogin(usuario);
            sesion.setUsuario(negocio.refrescarUsuario(usuario));
            
            return "Home.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (CuentaInactivaException e) {
            FacesMessage fm = new FacesMessage("La cuenta existe pero no está activa");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ACOESException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

}
