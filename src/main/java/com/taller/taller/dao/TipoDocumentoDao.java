package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.TipoDocumento;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TipoDocumentoDao {
    private Transaction transaction;

    public List<TipoDocumento> getAll(){
        List<TipoDocumento> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from TipoDocumento", TipoDocumento.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public TipoDocumento getByDescripcion(String descripcion){
        TipoDocumento tipoDocumento = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tipoDocumento = session.createQuery("from TipoDocumento td where td.descripcion = :descripcion", TipoDocumento.class)
                    .setParameter("descripcion", descripcion)
                    .getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tipoDocumento;
    }

}
