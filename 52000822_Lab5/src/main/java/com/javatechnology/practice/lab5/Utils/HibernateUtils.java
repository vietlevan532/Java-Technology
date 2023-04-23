package com.javatechnology.practice.lab5.Utils;

import com.javatechnology.practice.lab5.Model.Product;
import com.javatechnology.practice.lab5.Model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private HibernateUtils(){
        super();
    }
    static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.configure().buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
