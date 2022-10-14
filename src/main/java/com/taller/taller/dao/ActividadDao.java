package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Actividad;
import com.taller.taller.personas.empleados.EmpleadoFactory;
import com.taller.taller.personas.empleados.TIPOEMPLEADO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActividadDao implements IDao{

    private Transaction transaction;

    public List<Actividad> getAll(){
        EmpleadoFactory.instance().crearEmpleado(TIPOEMPLEADO.EncargadoRecepcion);
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


    @Override
    public <T> T buscarPorID(int id) {
        return null;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }
}
