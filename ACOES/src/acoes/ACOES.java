/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

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
        // TODO code application logic here
        
        JOVEN_NIÑO n = new JOVEN_NIÑO();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACOESPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        n.setNombre("Manolo");
        em.persist(n);
        tx.commit();
        
        em.close();
        emf.close();
        
    }
    
}
