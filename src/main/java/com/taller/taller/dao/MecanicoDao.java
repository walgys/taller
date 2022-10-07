package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Mecanico;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MecanicoDao {
    private Transaction transaction;

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

}
