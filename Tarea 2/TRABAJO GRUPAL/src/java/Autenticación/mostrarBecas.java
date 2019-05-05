/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.BECA;
import acoes.CCJ;
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
@Named(value = "mostrarBecas")
@RequestScoped
public class mostrarBecas {

    private List<BECA> becas;

    public List<BECA> getBecas() {
        return becas;
    }

    public void setBecas(List<BECA> becas) {
        this.becas = becas;
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
    public mostrarBecas() {
        
        BECA b1 = new BECA("Beca San Miguel", 5000, new Date (2019,5,4), new Date(2020,5,5));
        BECA b2 = new BECA("Beca Talento", 10000, new Date (2019,5,4), new Date(2021,5,5));
        
        becas = new ArrayList<>();
        
        becas.add(b1);
        becas.add(b2);
        
       
    }

    public String lista_becas(){  //
        
         return ctrl.becas();
        
        
        
    }    
}