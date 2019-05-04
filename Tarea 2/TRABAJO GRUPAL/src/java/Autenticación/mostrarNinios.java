/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.CCJ;
import acoes.JOVEN_NIÑO;
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
@Named(value = "mostrarNinios")
@RequestScoped
public class mostrarNinios {
   private List<JOVEN_NIÑO> ninios;

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
    public mostrarNinios() {
        
        CCJ c1 = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        CCJ c2 = new CCJ("Santa Lupita2", "Ecuador", "Elipa2", "C/ Rosa2", "242314", "ccj@uma.es", "Colegio nuevo2");
        
        JOVEN_NIÑO n1 = new JOVEN_NIÑO("Juanito", "Perez", "Rivera", "Colombiano", 
                "Hola soy Juanito y me gusta el flamenquito", new Date(1999, 10, 19), c1);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Marlon", "Gomez", "Lopez", "Peruano", 
                "Hola soy Marlon kek", new Date(2005, 4, 5), c2);
        
        ninios = new ArrayList<>();
        
        ninios.add(n1);
        ninios.add(n2);
         
    }

    public String lista_ninios(){  //
        
         return ctrl.ninios();
        
        
        
    }
        
}