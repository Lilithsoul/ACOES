/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes.vista;


import acoes.entidades.BECA;
import acoes.entidades.CCJ;
import acoes.entidades.ENVIOS;
import acoes.entidades.HISTORIAL_APADRINAMIENTO;
import acoes.entidades.JOVEN_NIÑO;
import acoes.entidades.Role;
import acoes.negocio.ACOESException;
import acoes.negocio.Negocio;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="ninios")
@RequestScoped
public class Ninios {
    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };
    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;
    private JOVEN_NIÑO ninio;
    private Modo modo;
    private Long ccj;
    private Long populorum;
    private Long beca;
    
    public Ninios() {
        ninio = new JOVEN_NIÑO();
        modo = Modo.NOACCION;
    }
    public InfoSesion getSesion() {
        return sesion;
    }

    public void setSesion(InfoSesion sesion) {
        this.sesion = sesion;
    }

    public Long getCcj() {
        return ccj;
    }

    public void setCcj(Long ccj) {
        this.ccj = ccj;
    }

    public Long getPopulorum() {
        return populorum;
    }

    public void setPopulorum(Long populorum) {
        this.populorum = populorum;
    }

    public Long getBeca() {
        return beca;
    }

    public void setBeca(Long beca) {
        this.beca = beca;
    }

 

    
    
    public JOVEN_NIÑO getNinio() {
        return ninio;
    }

    public void setNinio(JOVEN_NIÑO ninio) {
        this.ninio = ninio;
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
    public String modificarNinio(JOVEN_NIÑO ni) {
        ninio = ni;
        setModo(Modo.MODIFICAR);
        return "edicionNinio.xhtml";
    }
    
    public String eliminarNinio(JOVEN_NIÑO ni) throws ACOESException {
        if(ni.isApadrinado()){
            return "errorEliminacionNinio.xhtml";
        }

        negocio.eliminarNinio(ni, sesion.getUsuario());
        sesion.refrescarUsuario();
        return null;
    }
    
    public String insertarNinio() {
        setModo(Modo.INSERTAR);
        return "edicionNinio.xhtml";
    }
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }
    
    public String detalles(HISTORIAL_APADRINAMIENTO a){
        ninio = a.getNiño_apadrinado();
        return "niniosDetalle.xhtml";
    }
    
    public String ejecutarAccionNinio() throws ACOESException {
        switch (modo) {
            case MODIFICAR:
                if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR){
                    if(ccj != null && populorum == null){
                        ninio.setCcj(negocio.getCCJID(ccj));
                    }else if (ccj==null && populorum != null){
                        ninio.setCp(negocio.getCPID(populorum));
                        
                    }
                    if(ninio.getBecas() == null && beca != null){
                        List<BECA> becas = new ArrayList<>();
                        becas.add(negocio.getBecasID(beca));
                        ninio.setBecas(becas);
                    }else if (ninio.getBecas() != null && beca != null){
                        ninio.getBecas().add(negocio.getBecasID(beca));
                    }
                    
                    negocio.modificarNinio(ninio, sesion.getUsuario());
                }
                break;
            case INSERTAR:
                if(sesion.getUsuario().getRole()== Role.ADMINISTRADOR){    
                    if(ccj != null && populorum == null){
                        ninio.setCcj(negocio.getCCJID(ccj));
                    }else if (ccj==null && populorum != null){
                        ninio.setCp(negocio.getCPID(populorum));
                        
                    }
                    if(beca != null){
                    List<BECA> becas = new ArrayList<>();
                    becas.add(negocio.getBecasID(beca));                  
                    ninio.setBecas(becas);
                    }
                    negocio.insertarNinio(ninio, sesion.getUsuario());
                }
                break;
        }
        sesion.refrescarUsuario();
        return "ninios.xhtml";
    }
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario().getRole() == Role.ADMINISTRADOR;
    }
    
    
}
