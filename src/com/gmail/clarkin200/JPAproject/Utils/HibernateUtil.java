package com.gmail.clarkin200.JPAproject.Utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory newSessionFactory = null;
        try {
            newSessionFactory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Config ERROR!!!");
        }

        return newSessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        sessionFactory.close();
    }

}
