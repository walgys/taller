package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.ActividadesTurno;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadTurnoDao {
    private Transaction transaction;

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
