package com.taller.taller.dao;

import com.taller.taller.models.Actividad;

import java.util.List;

public interface IDao {

    public <T> List<T> getAll();

    public <T> T buscarPorID(int id);

    public void save(Object entity);

    public void delete(Object entity);

}
