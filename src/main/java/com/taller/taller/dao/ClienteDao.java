package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClienteDao implements IDao<Cliente> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile ClienteDao _instance = null;

    public static ClienteDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new ClienteDao();
                }
            }
        }
        return _instance;
    }

    public void save(Cliente cliente){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if(cliente.getId() != 0) {
                session.update(cliente);
            } else {
                session.save(cliente);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void delete(Cliente entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Cliente> getAll(){
        List<Cliente> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Cliente", Cliente.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public Cliente getById(int id){
        Cliente object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Cliente td where td.id = :id", Cliente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return object;
    }
}
