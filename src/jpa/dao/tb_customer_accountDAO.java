package jpa.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.model.tb_customer_account;

public class tb_customer_accountDAO {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Desafio_valemobiPU");
        return factory.createEntityManager();
    } 
    
    public tb_customer_account insert (tb_customer_account costumer) {
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();    
            em.persist(costumer);// executa o insert no db
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
        }finally{
        em.close();
        }
        return costumer;
    }
    
    public List<tb_customer_account> busca() {
        EntityManager em = getEM();
        List<tb_customer_account> buscar; 
        try{
        Query q  = em.createNamedQuery("busca"); //Utiliza a Query nomeada no model
        buscar = q.getResultList();

        }catch(Exception e){
            buscar = new ArrayList();
        }finally{
            em.close();
        }
        return buscar;
    }
    
    
    
}
