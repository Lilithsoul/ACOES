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
@Named(value = "becaNuea")
@RequestScoped
public class becaNueva {

    private BECA beca;

    public BECA getBeca() {
        return beca;
    }

    public void setBeca(BECA beca) {
        this.beca = beca;
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
    public becaNueva() {
        
        
        
       
    }

    public String lista_becas(){  //
        
         return ctrl.becas();
        
        
        
    }    
}