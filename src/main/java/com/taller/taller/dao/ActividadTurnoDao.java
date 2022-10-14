package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.ActividadesTurno;
import com.taller.taller.personas.empleados.EmpleadoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadTurnoDao {
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
