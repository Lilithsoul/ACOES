/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;


import acoes.entidades.CASA_POPULORUM;
import acoes.entidades.Role;
import acoes.entidades.USUARIO;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="populorums")
@RequestScoped
public class Populorums {
    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private CASA_POPULORUM cp;
    private Modo modo;
    
    public Populorums() {
        cp = new CASA_POPULORUM();
        modo = Modo.NOACCION;
    }
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public CASA_POPULORUM getPopulorum() {
        return cp;
    }

    public void setPopulorum(CASA_POPULORUM cp) {
        this.cp = cp;
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
    public String modificarPopulorum(CASA_POPULORUM c) {
        cp = c;
        setModo(Modo.MODIFICAR);
        return "edicionPopulorum.xhtml";
    }
    public String eliminarPopulorum(CASA_POPULORUM cp) throws ACOESException {
        if(!cp.getJovenes().isEmpty()){
            return "errorEliminacionPopulorum.xhtml";
        }
        negocio.eliminarPopulorum(cp, sesion.getUsuario());
        sesion.refrescarUsuario();
        return null;
    }
    public String insertarPopulorum(){
        setModo(Modo.INSERTAR);
        return "edicionPopulorum.xhtml";
    }
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }
    
    public String ejecutarAccionPopulorum() {
        try {
            switch (modo) {
                case MODIFICAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.modificarPopulorum(cp, sesion.getUsuario());
                    break;
                case INSERTAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.insertarPopulorum(cp, sesion.getUsuario());
                    break;
            }
            sesion.refrescarUsuario();
            return "populorum.xhtml";
        } catch (ACOESException e) {
            return "login.xhtml";
        }
    }
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario().getRole() == Role.ADMINISTRADOR;
    }
    
    public List<CASA_POPULORUM> getPopulorumNinios(USUARIO u){
        return negocio.PopulorumNinio(u);
    }
    
}
