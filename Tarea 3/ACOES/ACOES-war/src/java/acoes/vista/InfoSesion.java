/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acoes.vista;

import acoes.entidades.BECA;
import acoes.entidades.CASA_POPULORUM;
import acoes.entidades.CCJ;
import acoes.entidades.ENVIOS;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author francis
 */
@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    @Inject
    private Negocio negocio;
    private USUARIO usuario;
    private JOVEN_NIÑO ninio;
    private CCJ ccj;
    private BECA b;
    private CASA_POPULORUM cp;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

    public synchronized USUARIO getUsuario() {
        return usuario;
    }
    
    public synchronized List<HISTORIAL_APADRINAMIENTO> getHistorialesFull(){
        return negocio.getHistorialesTotales();
    }
    
    public synchronized List<ENVIOS> getEnvios()
    {
        if (usuario != null)
        {
            return negocio.obtenerEnviosTotales();
        }
        return null;
    }
    public synchronized List<JOVEN_NIÑO> getNinios()
    {
        if (usuario != null)
        {
            if(usuario.getRole() == Role.ADMINISTRADOR){
                return negocio.obtenerNinios();
            }     
        }
        return null;
    }
    public synchronized List<ENVIOS> getEnviosSocio()
    {
        if (usuario != null)
        {
            if(usuario.getRole() == Role.SOCIO){
                return negocio.obtenerEnviosSocio(usuario);
                
            }     
        }
        return null;
    }
    
    
    public synchronized List<HISTORIAL_APADRINAMIENTO> getHistoriales(){
        if(usuario != null){
            if(usuario.getRole() == Role.SOCIO){
                return negocio.obtenerNiniosSocio(usuario);
            }
        }
        return null;
    }
    
    public synchronized List<CCJ> getCCJ() throws ACOESException
    {
        if (usuario != null)
        {
            return negocio.obtenerCCJs(usuario);
        }
        return null;
    }
    
    public synchronized List<CASA_POPULORUM> getPopulorum() throws ACOESException
    {
        if (usuario != null)
        {
            return negocio.obtenerPopulorums();
        }
        return null;
    }
    
    public synchronized List<BECA> getBeca() throws ACOESException
    {
        if (usuario != null)
        {
            return negocio.obtenerBecas();
        }
        return null;
    }
    
    
    public synchronized String invalidarSesion()
    {
        if (usuario != null){
            
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }

    
    public synchronized void refrescarUsuario()
    {
        try {
        if (usuario != null)
        {
            usuario = negocio.refrescarUsuario(usuario);
            //System.out.println(usuario.getContactos().size());
        } 
        }
        catch (ACOESException e) {
            // TODO
        }
    }
    
        public synchronized void refrescarApadrinamientos() throws ACOESException
    {
       
            negocio.refrescarApadrinamientos(usuario);
         
        
    }
    
}
