package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Actividad;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadDao {
    private Transaction transaction;

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

}
