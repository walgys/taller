package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Especialidad;
import com.taller.taller.models.Mecanico;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MecanicoDao implements IDao<Mecanico> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile MecanicoDao _instance = null;

    public static MecanicoDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new MecanicoDao();
                }
            }
        }
        return _instance;
    }

    public List<Mecanico> getAll(){
        List<Mecanico> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Mecanico", Mecanico.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    public Mecanico getById(int id) {
        Mecanico object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Mecanico td where td.id = :id", Mecanico.class)
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

    @Override
    public void save(Mecanico entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if(entity.getId() != 0) {
                session.update(entity);
            } else {
                session.save(entity);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Mecanico entity) {
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
