/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.CCJ;
import java.util.ArrayList;
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
@Named(value = "mostrarCCJ")
@RequestScoped
public class MostrarCCJ {

    private List<CCJ> ccjs;

    public List<CCJ> getCcjs() {
        return ccjs;
    }

    public void setCcjs(List<CCJ> ccjs) {
        this.ccjs = ccjs;
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
    public MostrarCCJ() {
        
        CCJ c1 = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        CCJ c2 = new CCJ("Santa Lupita2", "Ecuador", "Elipa2", "C/ Rosa2", "242314", "ccj@uma.es", "Colegio nuevo2");
        
        ccjs = new ArrayList<CCJ>();
        
        ccjs.add(c1);
        ccjs.add(c2);
         
    }

    public String lista_ccj(){  //
        
         return ctrl.ccj();
        
        
        
    }
        
}