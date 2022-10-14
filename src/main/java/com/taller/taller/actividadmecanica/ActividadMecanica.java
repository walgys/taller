package com.taller.taller.actividadmecanica;

import com.taller.taller.models.Repuesto;

import java.util.Date;
import java.util.List;

public class ActividadMecanica extends Actividad{
    private int idActividad;
    private String nombre;
    private int idMecanico;
    private Date fecha;
    private String hora;

    public ActividadMecanica(String nombre, int idMecanico, Date fecha, String hora) {
        this.nombre = nombre;
        this.idMecanico = idMecanico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(List<Repuesto> repuestos) {
        this.repuestos = repuestos;
    }

    private List<Repuesto> repuestos;


}
