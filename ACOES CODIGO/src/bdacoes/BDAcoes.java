/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdacoes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author katiucha
 */
public class BDAcoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        user a = new user();
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("Acoes");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        a.setNombre("katia");
        em.persist(a);
        tx.commit();
        
        em.close();
        emf.close();
        
        
    }
    
}
