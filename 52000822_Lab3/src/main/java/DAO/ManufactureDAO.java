package DAO;

import POJO.Manufacture;
import Utils.HibernateUtils;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;

public class ManufactureDAO implements iDAO<Manufacture, Integer> {
    Session session;
    Transaction transaction;

    @Override
    public Integer add(Manufacture manufacture) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String sql = "INSERT INTO Manufacture( name, location, employee)"
                    + "VALUES(?, ?, ?)";
            Query query = session.createQuery(sql);
            query.setParameter("name", manufacture.getName());
            query.setParameter("location", manufacture.getLocation());
            query.setParameter("employee", manufacture.getEmployee());
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
    public Manufacture get(Integer integer) {
        session = HibernateUtils.getSessionFactory().openSession();
        Manufacture getOne = null;
        try {
            String rq = "SELECT * FROM Manufacture WHERE id=?";
            Query query = session.createQuery(rq);
            query.setParameter("id", integer);
            getOne = (Manufacture) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return getOne;
    }

    @Override
    public List<Manufacture> getAll() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<Manufacture> manufactureList = null;
        try {
            String rq = "SELECT * FROM Manufacture";
            Query query = session.createQuery(rq);
            manufactureList = (List<Manufacture>) query.list();
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return manufactureList;
    }

    @Override
    public boolean removeById(Integer integer) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String rq = "DELETE FROM Manufacture WHERE id=?";
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
    public boolean remove(Manufacture manufacture) {
        return removeById(manufacture.getId());
    }

    @Override
    public boolean update(Manufacture manufacture) {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String rq = "UPDATE Manufacture SET name=?, location=?, employee=? WHERE id=?";
            Query query = session.createQuery(rq);
            query.setParameter("name", manufacture.getName());
            query.setParameter("location", manufacture.getLocation());
            query.setParameter("employee", manufacture.getEmployee());
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

    public List<Manufacture> AllManufactureMoreThan100Employee() {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "SELECT * FROM Manufacture WHERE employee > 100";
            Query query = session.createQuery(rq);
            return (List<Manufacture>) query.list();
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public int SumEmployeeOfAllManufactures() {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "SELECT SUM(employee) FROM Manufacture";
            Query query = session.createQuery(rq);
            return (int) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return 0;
    }

    public Manufacture LastManufactureBaseInTheUS() throws InvalidDnDOperationException {
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            String rq = "SELECT * FROM Manufacture WHERE location LIKE '%US%' ORDER BY id DESC";
            Query query = session.createQuery(rq);
            return (Manufacture) query.list().get(0);
        } catch (HibernateError e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

}
