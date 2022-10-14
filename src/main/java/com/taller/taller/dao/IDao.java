package com.taller.taller.dao;

import com.taller.taller.models.Actividad;
import com.taller.taller.models.ActividadesTurno;

import java.util.List;

public interface IDao<T>  {

    List<T> getAll();

    T getById(int id);

    void save(T entity);

    void delete(T entity);
}
