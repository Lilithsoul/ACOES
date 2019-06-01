/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;


import acoes.entidades.BECA;
import acoes.entidades.Role;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="becas")
@RequestScoped
public class Becas {
    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private BECA b;
    private Modo modo;
    
    public Becas() {
        b = new BECA();
        modo = Modo.NOACCION;
    }
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public BECA getBeca() {
        return b;
    }

    public void setBeca(BECA b) {
        this.b = b;
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
    public String modificarBeca(BECA be) {
        b = be;
        setModo(Modo.MODIFICAR);
        return "edicionBeca.xhtml";
    }
    public String eliminarBeca(BECA b) {
        try {
            negocio.eliminarBeca(b, sesion.getUsuario());
            // Refrescar el usuario
            sesion.refrescarUsuario();
        } catch (ACOESException e) {
            return "login.xhtml";
        }
        return null;
    }
    public String insertarBeca(){
        setModo(Modo.INSERTAR);
        return "edicionBeca.xhtml";
    }
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }
    
    public String ejecutarAccionBeca() {
        try {
            switch (modo) {
                case MODIFICAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.modificarBeca(b, sesion.getUsuario());
                    break;
                case INSERTAR:
                    if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR)
                    negocio.insertarBeca(b, sesion.getUsuario());
                    break;
            }
            sesion.refrescarUsuario();
            return "beca.xhtml";
        } catch (ACOESException e) {
            return "login.xhtml";
        }
    }
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario().getRole() == Role.ADMINISTRADOR;
    }
    
    
    
}
