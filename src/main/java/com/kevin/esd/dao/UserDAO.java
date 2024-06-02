package com.kevin.esd.dao;

import com.kevin.esd.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.kevin.esd.configuration.UtilClass;

public class UserDAO {
	
    public User findByUsername(String username) {
        try (Session session = UtilClass.getSF().openSession()) {
            String hql = "FROM User WHERE username = :username";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }
}
