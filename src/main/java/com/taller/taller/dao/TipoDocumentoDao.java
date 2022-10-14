package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Mecanico;
import com.taller.taller.models.TipoDocumento;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TipoDocumentoDao implements IDao<TipoDocumento> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile TipoDocumentoDao _instance = null;

    public static TipoDocumentoDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new TipoDocumentoDao();
                }
            }
        }
        return _instance;
    }

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

    @Override
    public TipoDocumento getById(int id) {
        TipoDocumento object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from TipoDocumento td where td.id = :id", TipoDocumento.class)
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

    @Override
    public void save(TipoDocumento entity) {
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

    @Override
    public void delete(TipoDocumento entity) {
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
