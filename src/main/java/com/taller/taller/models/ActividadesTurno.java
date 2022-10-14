package com.taller.taller.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "actividad_turno")
public class ActividadesTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Turno turno;

    @ManyToOne
    private Actividad actividad;

    @Column(name="tiempo_empleado")
    private int tiempoEmpleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getTiempoEmpleado() {
        return tiempoEmpleado;
    }

    public void setTiempoEmpleado(int tiempoEmpleado) {
        this.tiempoEmpleado = tiempoEmpleado;
    }
}
