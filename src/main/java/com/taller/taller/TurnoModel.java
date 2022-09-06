package com.taller.taller;

import java.util.Date;

public class TurnoModel {

    private String especialidad;
    private String mecanico;
    private Date hora;
    private String cliente;
    private String vehiculo;

    public TurnoModel(){}

    public TurnoModel(String especialidad, String mecanico, Date hora, String cliente, String vehiculo){
        this.cliente = cliente;
        this.hora = hora;
        this.especialidad = especialidad;
        this.mecanico = mecanico;
        this.vehiculo = vehiculo;
    }

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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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
}
