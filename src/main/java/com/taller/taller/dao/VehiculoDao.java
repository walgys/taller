package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Vehiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehiculoDao {

    private Transaction transaction;

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

}
