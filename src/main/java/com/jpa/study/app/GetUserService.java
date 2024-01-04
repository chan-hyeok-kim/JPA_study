package com.jpa.study.app;

import com.jpa.study.domain.User;
import com.jpa.study.jpa.EMF;

import jakarta.persistence.EntityManager;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.createEntityManager();
        try {
            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            return user;
        } finally {
            em.close();
        }
    }
}