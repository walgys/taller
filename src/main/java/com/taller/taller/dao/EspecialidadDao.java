package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Cliente;
import com.taller.taller.models.Especialidad;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EspecialidadDao implements IDao<Especialidad> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile EspecialidadDao _instance = null;

    public static EspecialidadDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new EspecialidadDao();
                }
            }
        }
        return _instance;
    }

    public List<Especialidad> getAll(){
        List<Especialidad> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Especialidad", Especialidad.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }


    public Especialidad getById(int id) {
        Especialidad object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Especialidad td where td.id = :id", Especialidad.class)
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

    public void save(Especialidad entity) {
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

    public void delete(Especialidad entity) {
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

    public Especialidad getByDescripcion(String descripcion){
        Especialidad object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Especialidad td where td.descripcion = :descripcion", Especialidad.class)
                    .setParameter("descripcion", descripcion)
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
