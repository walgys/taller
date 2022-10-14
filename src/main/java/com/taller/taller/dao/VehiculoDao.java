package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.TipoDocumento;
import com.taller.taller.models.Turno;
import com.taller.taller.models.Vehiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehiculoDao implements IDao<Vehiculo> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile VehiculoDao _instance = null;

    public static VehiculoDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new VehiculoDao();
                }
            }
        }
        return _instance;
    }

    @Override
    public List<Vehiculo> getAll() {
        List<Vehiculo> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Vehiculo", Vehiculo.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    public Vehiculo getById(int id) {
        Vehiculo object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Vehiculo td where td.id = :id", Vehiculo.class)
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

    public void save(Vehiculo vehiculo){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if(vehiculo.getId() != 0) {
                session.update(vehiculo);
            } else {
                session.save(vehiculo);
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
    public void delete(Vehiculo entity) {
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
