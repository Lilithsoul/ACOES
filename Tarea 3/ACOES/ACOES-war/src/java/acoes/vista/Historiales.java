/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;

import acoes.entidades.ENVIOS;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.ApadrinamientoException;
import acoes.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andres
 */
@Named(value="historiales")
@RequestScoped
public class Historiales {
    
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private HISTORIAL_APADRINAMIENTO historial;

    public Historiales() {
        historial = new HISTORIAL_APADRINAMIENTO();
    }
    
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public HISTORIAL_APADRINAMIENTO getHistorial() {
        return historial;
    }

    public void setHistorial(HISTORIAL_APADRINAMIENTO historial) {
        this.historial = historial;
    }
    
    public String getPadrino(JOVEN_NIÑO n){
        String padrino = negocio.getPadrinoNegocio(n);
        return padrino;
    }

    
    public String apadrinar() throws ACOESException {
        try{
        if(sesion.getUsuario().getRole()== Role.SOCIO){
            historial.setSocio_apadrina(sesion.getUsuario());
            int numNinios = negocio.obtenerNiniosSinPadrino().size();
            if(numNinios<=0){
                return "errorApadrinamiento.xhtml";
            }
            negocio.insertarHistorial(historial, sesion.getUsuario());
            
        }
        sesion.refrescarUsuario();
        return "ninios.xhtml";
        }catch (ApadrinamientoException e){
            
            FacesMessage fm = new FacesMessage("No quedan niños para apadrinar");
            FacesContext.getCurrentInstance().addMessage("historiales:user", fm);
        }
        return null;
    }
}

