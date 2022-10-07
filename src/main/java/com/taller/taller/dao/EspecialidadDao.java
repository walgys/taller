package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Especialidad;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EspecialidadDao {
    private Transaction transaction;

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
