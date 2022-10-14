package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Actividad;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadDao implements IDao<Actividad> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile ActividadDao _instance = null;

    public static ActividadDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new ActividadDao();
                }
            }
        }
        return _instance;
    }

    public List<Actividad> getAll(){
        List<Actividad> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Actividad", Actividad.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public Actividad getById(int id) {
        Actividad object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Actividad td where td.id = :id", Actividad.class)
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

    public void save(Actividad entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Actividad entity) {
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
}
