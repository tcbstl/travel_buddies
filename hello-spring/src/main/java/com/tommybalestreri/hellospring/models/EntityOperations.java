package com.tommybalestreri.hellospring.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityOperations {

    private static final String PERSISTENCE_UNIT_NAME = "UserDestinationDTO";

    public static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("com.tommybalestreri.models.dto.UserDestinationDTO");
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void removeDestination(){
        EntityManager em = EntityOperations.getEntityManager();
        em.getTransaction()
                .begin();
        Destination destination = em.find(Destination.class, new Long(1L));
        em.remove(destination);
        em.getTransaction()
                .commit();
    }

}
