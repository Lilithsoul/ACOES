/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.CASA_POPULORUM;
import acoes.CCJ;
import acoes.JOVEN_NIÑO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author francis
 */
@Named(value = "mostrarPopulorum")
@RequestScoped
public class MostrarPopulorum {

    private List<CASA_POPULORUM> populorums;

    public List<CASA_POPULORUM> getPopulorums() {
        return populorums;
    }

    public void setPopulorums(List<CASA_POPULORUM> populorumss) {
        this.populorums = populorumss;
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
    public MostrarPopulorum() {
        
        Date fecha = new Date(110, 5,3);
        Date fecha2 = new Date(112, 5,3);
        CCJ c = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        
        CASA_POPULORUM p1 = new CASA_POPULORUM("Casa la Juan", "Ecuador", 6);
        CASA_POPULORUM p2 = new CASA_POPULORUM("Casa Manolete", "Ecuador", 32);
        
        JOVEN_NIÑO n3 = new JOVEN_NIÑO("Paco", "Suárez", "Gutiérrez", "Bolivia", "Sin hogar", fecha, c);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2, c);
        
        n2.setCp(p1);
        n3.setCp(p2);
        
        populorums = new ArrayList<CASA_POPULORUM>();
        
        populorums.add(p1);
        populorums.add(p2);
         
    }

    public String lista_populorum(){  //
        
         return ctrl.populorum();
        
        
        
    }
        
}