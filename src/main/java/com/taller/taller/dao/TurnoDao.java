package com.taller.taller.dao;

import com.taller.taller.bean.HorarioMecanico;
import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Turno;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TurnoDao {

    private Transaction transaction;

    public List<HorarioMecanico> searchByEspecialidadFecha(int especialidadID, LocalDate fecha){
        List<HorarioMecanico> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery(
                            "select NEW com.taller.taller.bean.HorarioMecanico(H.id, H.descripcion, M.id , M.nombre) from Horario H " +
                                    "left join Turno T on T.hora.id = H.id and T.especialidad.id = :especialidadID and T.fechaTurno = :fecha " +
                                    "left join Mecanico M on M.especialidad.id = :especialidadID " +
                                    "where T.hora is null " +
                                    "order by M.id, H.id", HorarioMecanico.class)
                    .setParameter("especialidadID", especialidadID)
                    .setParameter("fecha", fecha)
                    .list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public List<Turno> getAllOfNow(){
        List<Turno> objects = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            objects = session.createQuery("from Turno where fechaTurno = CURRENT_DATE", Turno.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return objects;
    }

    public void save(Turno turno) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if(turno.getId() != 0) {
                session.update(turno);
            } else {
                session.save(turno);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Turno getById(int id){
        Turno object = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            object = session.createQuery("from Turno td where td.id = :id", Turno.class)
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
}
