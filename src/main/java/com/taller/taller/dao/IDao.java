package com.taller.taller.dao;

import com.taller.taller.models.Actividad;

import java.util.List;

public interface IDao {

    public List<Object> getAll();

    public Object buscarPorID(int id);

    public void grabar(Object entity);

    public void eliminar(Object entity);

}
