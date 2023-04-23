package DAO;

import POJO.Phone;
import Utils.HibernateUtils;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class PhoneDAO implements iDAO<Phone, Integer> {

    Session session;
    Transaction transaction;

    @Override
    public Integer add(Phone phone) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String sql = "INSERT INTO Phone( name, price, color, country, quantity)"
                    + "VALUES(?, ?, ?)";
            Query query = session.createQuery(sql);
            query.setParameter("name", phone.getName());
            query.setParameter("price", phone.getPrice());
            query.setParameter("color", phone.getColor());
            query.setParameter("country", phone.getCountry());
            query.setParameter("quantity", phone.getQuantity());
            int result = query.executeUpdate();
            System.out.println("Added:" + result);
            transaction.commit();
            session.close();
            return 1;
        } catch (HibernateError e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public Phone get(Integer integer) {
        session = HibernateUtils.getSessionFactory().openSession();
        Phone getOne = null;
        try {
            String rq = "SELECT * FROM Phone WHERE id=?";
            Query query = session.createQuery(rq);
            query.setParameter("id", integer);
            getOne = (Phone) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return getOne;
    }

    @Override
    public List<Phone> getAll() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<Phone> phoneList = null;
        try {
            String rq = "SELECT * FROM Phone";
            Query query = session.createQuery(rq);
            phoneList = (List<Phone>) query.list();
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return phoneList;
    }

    @Override
    public boolean removeById(Integer integer) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String rq = "DELETE FROM Phone WHERE id=?";
            Query query = session.createQuery(rq);
            query.setParameter("id", integer);
            int res = query.executeUpdate();
            System.out.println("Deleted: " + res);
            return true;
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            transaction.commit();
            session.close();
        }
        return false;
    }

    @Override
    public boolean remove(Phone phone) {
        return removeById(phone.getId());
    }

    @Override
    public boolean update(Phone phone) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String rq = "UPDATE Phone SET name=?, price=?, color=?, country=?, quantity=? WHERE id=?";
            Query query = session.createQuery(rq);
            query.setParameter("name", phone.getName());
            query.setParameter("price", phone.getPrice());
            query.setParameter("color", phone.getColor());
            query.setParameter("country", phone.getCountry());
            query.setParameter("quantity", phone.getQuantity());
            query.setParameter("id", phone.getId());
            int result = query.executeUpdate();
            System.out.println("Updated:" + result);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateError e) {
            System.out.println(e);
        }
        return false;
    }

    public Phone PhoneHighestSellingPrice() {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "SELECT * FROM Phone ORDER BY price DESC";
            Query query = session.createQuery(rq);
            return (Phone) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public List<Phone> SortedByCountryName() {
        session = HibernateUtils.getSessionFactory().openSession();
        String rq = "SELECT country FROM Phone";
        Query query = session.createQuery(rq);
        List<String> sortCountry = query.list();
        Collections.sort(sortCountry);
        String rq1 = "SELECT price FROM Phone";
        Query query1 = session.createQuery(rq1);
        List<String> sortPrice = query1.list();
        Collections.sort(sortPrice);
        session.close();
        return getAll();
    }

    public List<Phone> PhoneAbove50M() {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "SELECT Phone WHERE price > 50000000";
            Query query = session.createQuery(rq);
            return (List<Phone>) query.list();
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public Phone FirstPhonePinkAndOver15M() {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "FROM Phone WHERE color = 'Pink' and price > 15000000";
            Query query = session.createQuery(rq);
            return (Phone) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }
}
