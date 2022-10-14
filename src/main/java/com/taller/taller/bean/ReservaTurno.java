package com.taller.taller.bean;

import java.time.LocalDate;

public class ReservaTurno {

    private String especialidad;
    private String mecanico;
    private String horario;
    private String cliente;
    private String vehiculo;

    private int idHora;
    private int idMecanico;
    private int idEspecialidad;
    private LocalDate fechaReserva;
    private int idTurno;

    public ReservaTurno(String mecanico, String horario, int idMecanico, int idHora, int idEspecialidad, LocalDate fechaReserva) {
        this.mecanico = mecanico;
        this.horario = horario;
        this.idMecanico = idMecanico;
        this.idHora = idHora;
        this.idEspecialidad = idEspecialidad;
        this.fechaReserva = fechaReserva;
    }

    public ReservaTurno(String especialidad, String mecanico, String horario, String cliente, String vehiculo) {
        this.especialidad = especialidad;
        this.mecanico = mecanico;
        this.horario = horario;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public ReservaTurno() {}

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }
}
