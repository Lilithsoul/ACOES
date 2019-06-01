/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;


import acoes.entidades.ENVIOS;
import acoes.entidades.Estado;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.Role;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="envios")
@RequestScoped
public class Envios {
    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private ENVIOS envio;
    //private HISTORIAL_APADRINAMIENTO hp;
    private JOVEN_NIÑO j;
    private Long ninio;
    private String socio;
    private Modo modo;

    
    public Envios() {
        envio = new ENVIOS();
        modo = Modo.NOACCION;
    }
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public Long getNinio() {
        return ninio;
    }

    public void setNinio(Long ninio) {
        this.ninio = ninio;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }
    
    

    public ENVIOS getEnvio() {
        return envio;
    }

    public void setEnvio(ENVIOS envio) {
        this.envio = envio;
    }

    public JOVEN_NIÑO getJ() {
        return j;
    }

    public void setJ(JOVEN_NIÑO j) {
        this.j = j;
    }
    
    

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }
    public String getAccion() {
        switch (modo) {
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Insertar";

        }
        return null;
    }
    public String modificar(ENVIOS en) {
        envio = en;
        setModo(Modo.MODIFICAR);
        return "edicionEnvios.xhtml";
    }
    public String eliminarEnvio(ENVIOS en) {
        try {
            negocio.eliminarEnvio(en, sesion.getUsuario());
            // Refrescar el usuario
            sesion.refrescarUsuario();
        } catch (ACOESException e) {
            return "login.xhtml";
        }
        return null;
    }
    public String insertarEnvio(JOVEN_NIÑO k) {
        setJ(k);
        setModo(Modo.INSERTAR);
        return "edicionEnvios.xhtml";
    }
    
    public String insertarEnvioSocioID() throws ACOESException{
        
        envio.setNiño_envio(negocio.getNinioID(ninio));
        
        if (sesion.getUsuario().getRole() == Role.SOCIO){
            
            envio.setSocio_envio(sesion.getUsuario());
        } else if (sesion.getUsuario().getRole() == Role.ADMINISTRADOR){
        
            envio.setSocio_envio(negocio.getSocioID(socio));
        
        }
        
        if(envio.getNiño_envio() != null && envio.getSocio_envio() != null){
        
            negocio.insertarEnvio(envio, sesion.getUsuario());
        }
        
        if (sesion.getUsuario().getRole() == Role.SOCIO){
            
            return "ninios.xhtml";
            
        } else if (sesion.getUsuario().getRole() == Role.ADMINISTRADOR){
        
            return "envios.xhtml";
        
        }
        
        return "errorAutorizacion.xhtml";

    }
    
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }
    
    /*
    
    public void crearNuevoEnvio(HISTORIAL_APADRINAMIENTO h) throws ACOESException{    
        
        negocio.insertarEnvioSocio(h, envio, sesion.getUsuario());
        sesion.refrescarUsuario();

    }
    
    */
    
    public String crearNuevoEnvioAdmin(HISTORIAL_APADRINAMIENTO h) throws ACOESException{    
        
        negocio.insertarEnvioSocio(h, envio, sesion.getUsuario());
        sesion.refrescarUsuario();
        return "envios.xhtml";
    }

    
    public String aceptarEnvio(ENVIOS e) throws ACOESException{
        if(e.getEstado()==Estado.PENDIENTE){
        e.setEstado(Estado.ENVIADO);
        negocio.modificarEnvio(e, sesion.getUsuario());
        return "envios.xhtml";
        }       
        return null;
    }
    
    public String envioRecibido(ENVIOS e) throws ACOESException{
        if(e.getEstado()==Estado.ENVIADO){
        e.setEstado(Estado.RECIBIDO);
        negocio.modificarEnvio(e, sesion.getUsuario());
        return "envios.xhtml";
        }
        return null;
    }
    
    public String ejecutarAccionEnvio(JOVEN_NIÑO k) {
        try {
            switch (modo) {
                case MODIFICAR:
                    if(sesion.getUsuario().getRole()== Role.SOCIO)
                        envio.setSocio_envio(sesion.getUsuario());
                    negocio.modificarEnvio(envio, sesion.getUsuario());
                    break;
                case INSERTAR:
                    if(sesion.getUsuario().getRole()== Role.SOCIO){
                        envio.setSocio_envio(sesion.getUsuario());
                        //envio.setNiño_envio(k);
                        //System.out.print(k.getId());
                    }
                    negocio.insertarEnvio(envio, sesion.getUsuario());
                    break;
            }
            sesion.refrescarUsuario();
            return "ninios.xhtml";
        } catch (ACOESException e) {
            return "login.xhtml";
        }
    }
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario().getRole() == Role.SOCIO;
    }
    
    public String confirmarEnvio() throws ACOESException{
        
        return "ninios.xhtml";
    }
    
}
