package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.ActividadesTurno;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadTurnoDao implements IDao<ActividadesTurno> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile ActividadTurnoDao _instance = null;

    public static ActividadTurnoDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new ActividadTurnoDao();
                }
            }
        }
        return _instance;
    }

    @Override
    public List<ActividadesTurno> getAll() {
        List<ActividadesTurno> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from ActividadesTurno", ActividadesTurno.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    public ActividadesTurno getById(int id) {
        ActividadesTurno object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from ActividadesTurno td where td.id = :id", ActividadesTurno.class)
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

    public void save(ActividadesTurno actividadesTurno){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(actividadesTurno);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<ActividadesTurno> getByIdTurno(int idTurno){
        List<ActividadesTurno> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from ActividadesTurno where turno.id = :idTurno", ActividadesTurno.class)
                    .setParameter("idTurno", idTurno)
                    .list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public void delete(ActividadesTurno actividadesTurno){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(actividadesTurno);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
