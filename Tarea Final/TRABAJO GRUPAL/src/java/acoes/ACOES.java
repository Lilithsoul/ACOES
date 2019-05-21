/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author usuario
 */
public class ACOES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Date fecha = new Date(110, 5,3);
        Date fecha2 = new Date(112, 5,3);
        
        CCJ c = new CCJ("Santa Lupita", "Ecuador", "Elipa", "C/ Rosa", "24234", "ccj@uma.es", "Colegio nuevo");
        
        JOVEN_NIÑO n3 = new JOVEN_NIÑO("Paco", "Suárez", "Gutiérrez", "Bolivia", "Sin hogar", fecha, c);
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2, c);
        
        SOCIO s = new SOCIO("Katia", "González", "Barrena", "katia@uma.es", "687777777", "123", "64893459N", "katia01", fecha, "892374 892734 298734", "c/ DOMINGO");
        
        SOCIO s2 = new SOCIO("Javier", "González", "Barrena", "javi@uma.es", "687777777", "123", "64893459N", "javieh01", fecha, "892374 892734 298734", "c/ DOMINGO H");
        
        HISTORIAL_APADRINAMIENTO hp1 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, s2);
        
        //HISTORIAL_APADRINAMIENTO hp2 = new HISTORIAL_APADRINAMIENTO(fecha, fecha2, true, n3, s);
        
        /*
        
        JOVEN_NIÑO n2 = new JOVEN_NIÑO("Sergio", "González", null, "Español", "Lo han abandonado cruelmente:(", fecha2);
        
        ADMINISTRADOR ad = new ADMINISTRADOR("Katia", "González", "Barrena", "katia@uma.es", "687777777", "123", "64893459N", "katia01", fecha, "123456789", fecha, 1000, 1200, "Información");
        
        BECA b = new BECA("San Miguel", 1000, fecha, fecha2);
        
        SOCIO s = new SOCIO("Katia", "González", "Barrena", "katia@uma.es", "687777777", "123", "64893459N", "katia01", fecha, "892374 892734 298734");
        
        */
        BECA b = new BECA("San Miguel", 1000, fecha, fecha2);
        
        ENVIOS e = new ENVIOS(null, "Entrgado", n3, s2);
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");       
        
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
       /* em.persist(n);
        em.persist(n2);
        em.persist(ad);
        em.persist(s);*/
        
        em.persist(b);
        em.persist(n3);
        em.persist(n2);
        em.persist(s2);
        em.persist(s);
        em.persist(e);
        em.persist(c);
        em.persist(hp1);
        //em.persist(hp2);
        
        tx.commit();
        
        em.close();
        emf.close();
        
    }
    
}
