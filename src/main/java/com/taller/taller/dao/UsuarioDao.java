package com.taller.taller.dao;

import com.taller.taller.hibernate.HibernateUtil;
import com.taller.taller.models.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDao implements IDao<Usuario> {

    private Transaction transaction;

    private static final Object LOCK_OBJECT = new Object();
    private static volatile UsuarioDao _instance = null;

    public static UsuarioDao instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new UsuarioDao();
                }
            }
        }
        return _instance;
    }

    public boolean isValidUser(String username, String password){
        boolean isValidUser = false;
        Usuario usuario = getUserByUsername(username);
        if (usuario != null) {
            return usuario.getPassword().equals(password);
        }
        return isValidUser;
    }

    public void addUser(String username, String password){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Usuario usuario = new Usuario(username,password);
            session.save(usuario);

            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Usuario> getUsers(){
        List<Usuario> usuarios = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            usuarios = session.createQuery("from Usuario", Usuario.class).list();
            //users.forEach(s -> System.out.println(s.getUsername()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getUserByUsername(String username){
        Usuario usuario = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            usuario = session.createQuery("from Usuario u where u.username = :username", Usuario.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            usuarios = session.createQuery("from Usuario", Usuario.class).list();
            //users.forEach(s -> System.out.println(s.getUsername()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario getById(int id) {
        return null;
    }

    @Override
    public void save(Usuario entity) {

    }

    @Override
    public void delete(Usuario entity) {

    }
}
