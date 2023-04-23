package com.javatechnology.practice.lab5.DAO;

import com.javatechnology.practice.lab5.Model.Product;
import com.javatechnology.practice.lab5.Repository.L5Repository;
import com.javatechnology.practice.lab5.Utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO implements L5Repository<Product,Long>{

    @Override
    public Long add(Product product) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Long productID = (Long) session.save(product);
            session.getTransaction().commit();
            return productID;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(Product product) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(product);
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
            Product product = session.find(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Product get(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Product product = session.find(Product.class,id);
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("FROM Product", Product.class).list();
            session.getTransaction().commit();
            return products;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
