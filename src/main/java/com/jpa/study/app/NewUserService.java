package com.jpa.study.app;

import com.jpa.study.domain.User;
import com.jpa.study.jpa.EMF;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NewUserService {

    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
