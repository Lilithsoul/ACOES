/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;


import acoes.entidades.CCJ;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="ccjs")
@RequestScoped
public class CCJs {
    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private CCJ ccj;
    private Modo modo;
    
    public CCJs() {
        ccj = new CCJ();
        modo = Modo.NOACCION;
    }
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public CCJ getCcj() {
        return ccj;
    }

    public void setCcj(CCJ ccj) {
        this.ccj = ccj;
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
    public String modificarCCJ(CCJ c) {
        ccj = c;
        setModo(Modo.MODIFICAR);
        return "edicionCCJ.xhtml";
    }
    public String eliminarCCJ(CCJ c) throws ACOESException {
        if(!c.getJovenes().isEmpty()){
            return "errorEliminacionCCJ.xhtml";
        }
        negocio.eliminarCCJ(c, sesion.getUsuario());
        sesion.refrescarUsuario();
        return null;
    }
    public String insertarCCJ(){
        setModo(Modo.INSERTAR);
        return "edicionCCJ.xhtml";
    }
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }
    
    public String ejecutarAccionCCJ() {
        try {
            switch (modo) {
                case MODIFICAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.modificarCCJ(ccj, sesion.getUsuario());
                    break;
                case INSERTAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.insertarCCJ(ccj, sesion.getUsuario());
                    break;
            }
            sesion.refrescarUsuario();
            return "CCJ.xhtml";
        } catch (ACOESException e) {
            return "login.xhtml";
        }
    }
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario().getRole() == Role.ADMINISTRADOR;
    }
    
    public CCJ getCCJID(Long id){
        return negocio.getCCJID(id);
        
    }
    
    public List<CCJ> getCCJNinios(USUARIO u){
        return negocio.CcjNinio(u);
    }
}
