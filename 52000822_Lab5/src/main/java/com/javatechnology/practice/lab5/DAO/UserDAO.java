package com.javatechnology.practice.lab5.DAO;

import com.javatechnology.practice.lab5.Model.User;
import com.javatechnology.practice.lab5.Repository.L5Repository;
import com.javatechnology.practice.lab5.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements L5Repository<User,Long> {
    @Override
    public Long add(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Long productID = (Long) session.save(user);
            session.getTransaction().commit();
            return productID;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeByID(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = session.find(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public User get(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = session.find(User.class,id);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User", User.class).list();
            session.getTransaction().commit();
            return users;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User findByUsername(String username) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            session.beginTransaction();
            Query<?> query= session.createQuery("from User where username=:username");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();
            session.getTransaction().commit();
            return user;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
