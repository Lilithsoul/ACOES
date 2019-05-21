/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Autenticación;

import acoes.BECA;
import acoes.CCJ;
import acoes.ENVIOS;
import acoes.JOVEN_NIÑO;
import acoes.SOCIO;
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
        
        BECA b1 = new BECA("Beca San Miguel", 5000, new Date (2019,5,4), new Date(2020,5,5));
        BECA b2 = new BECA("Beca Talento", 10000, new Date (2019,5,4), new Date(2021,5,5));
        
        List<BECA> becas1 = new ArrayList<>();
        List<BECA> becas2 = new ArrayList<>();
        
        becas1.add(b1);
        becas2.add(b1);
        becas2.add(b2);
        
        JOVEN_NIÑO n1 = new JOVEN_NIÑO("Juanito", "Perez", "Rivera", "Colombiano", 
                "Hola soy Juanito y me gusta el flamenquito", new Date(1999, 10, 19), c1);
        n1.setBecas(becas1);
        
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Marlon", "Gomez", "Lopez", "Peruano", 
                "Hola soy Marlon kek", new Date(2005, 4, 5), c2);
        n2.setBecas(becas2);
        

        SOCIO sergio = new SOCIO("Sergio", "Gon", "Si", "ser@uma.es", "9823423", "admin", "8937435", "SG9", new Date(1999, 10, 19), "8397428932", "C/ Mi calle");
        SOCIO pepe = new SOCIO("Pepe", "Torres", "Garrido", "pepe@uma.es", "6454844", "admin", "8937432", "pp", new Date(1998, 5, 19), "8397445932", "C/ Mi calle 1");
        ninios = new ArrayList<>();
        
        ninios.add(n1);
        ninios.add(n2);
        
        ENVIOS e1 = new ENVIOS("Esto es una prueba de envios", "Enviado", n1, sergio);
        ENVIOS e2 = new ENVIOS("Paquete de cigarritos", "Recibido", n1, pepe);
        ENVIOS e3 = new ENVIOS("Envio numero 2", "Pendiente", n2, pepe);
        
        List<ENVIOS> envios1 = new ArrayList<>();
        List<ENVIOS> envios2 = new ArrayList<>();
        envios1.add(e1);
        envios1.add(e2);
        envios2.add(e3);
        
        n1.setEnvios_a_recibir(envios1);
        n2.setEnvios_a_recibir(envios2);
        
        /*
        
        List<HISTORIAL_APADRINAMIENTO> historiales = new ArrayList<HISTORIAL_APADRINAMIENTO>();
        
        HISTORIAL_APADRINAMIENTO hp1 = new HISTORIAL_APADRINAMIENTO(new Date(2010,5,5), new Date(2020,5,5), true, n1, sergio);
        //hp1.add(fecha, fecha2, true, n2, socio);
        HISTORIAL_APADRINAMIENTO hp2 = new HISTORIAL_APADRINAMIENTO(new Date(2010,5,5), new Date(2020,5,5), true, n2, pepe);
        
        historiales.add(hp1);
        historiales.add(hp2);
         
        */
         
    }

    public String lista_ninios(){  //
        
         return ctrl.ninios();
        
        
        
    }
        
}