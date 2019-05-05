/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.ADMINISTRADOR;
import acoes.CCJ;
import acoes.HISTORIAL_APADRINAMIENTO;
import acoes.JOVEN_NIÑO;
import acoes.SOCIO;
import acoes.USUARIO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Named(value = "apadrinar")
@RequestScoped
public class Apadrinar {

    private SOCIO socio;
    private List<JOVEN_NIÑO> ninios;
    private List<HISTORIAL_APADRINAMIENTO> historiales;

    public SOCIO getSocio() {
        return socio;
    }

    public void setSocio(SOCIO socio) {
        this.socio = socio;
    }

    public List<HISTORIAL_APADRINAMIENTO> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<HISTORIAL_APADRINAMIENTO> historiales) {
        this.historiales = historiales;
    }

    public List<JOVEN_NIÑO> getNinios() {
        return ninios;
    }

    public void setNinios(List<JOVEN_NIÑO> ninios) {
        this.ninios = ninios;
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
     * Creates a new instance of Apadrinar
     */
    public Apadrinar() {
        
        Date fecha = new Date(110, 5,3);
        Date fecha2 = new Date(112, 5,3);
        CCJ c = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        
        ninios = new ArrayList<JOVEN_NIÑO>();
        
        JOVEN_NIÑO n3 = new JOVEN_NIÑO("Paco", "Suárez", "Gutiérrez", "Bolivia", "Sin hogar", fecha, c);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2, c);
        
        ninios.add(n3);
        ninios.add(n2);
        
        historiales = new ArrayList<HISTORIAL_APADRINAMIENTO>();
        
        HISTORIAL_APADRINAMIENTO hp1 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, socio);
        //hp1.add(fecha, fecha2, true, n2, socio);
        HISTORIAL_APADRINAMIENTO hp2 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, socio);
        
        historiales.add(hp1);
        historiales.add(hp2);
         
    }

    public String apadrinamiento() throws ParseException {  // Pasar parámetros del login
        
        /*
        boolean cont = true;
        int i = 0;
        
        while(cont == true || i < ninios.size()){
            
            if(ninios.get(i).isApadrinado() == false){
                
                cont = false;
                ninios.get(i).setApadrinado(true);
                
                SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
                Date dt_1 = objSDF.parse("20-08-2019"); 
                Date dt_2 = objSDF.parse("12-10-2020");
                
                HISTORIAL_APADRINAMIENTO h = new HISTORIAL_APADRINAMIENTO(dt_1, dt_2, true, ninios.get(i), ctrl.getSocio());
                ctrl.getSocio().setApadrinados(ctrl.getSocio().getApadrinados()+1);
                //ninios.remove(i);

                return ctrl.home(); // Si volvemos al home se reinician los niños
            }
            
            i++;
        
        }

        */
                
        
         // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible apadrinar a un niño, inténtelo más tarde", "No ha sido posible apadrinar a un niño, inténtelo más tarde"));
        
        
        
        return null;
        
    }
        
}
