package com.taller.taller.bean.empleados;

import com.taller.taller.personas.empleados.IEmpleado;
import com.taller.taller.personas.empleados.TIPOEMPLEADO;

public class Empleado implements com.taller.taller.personas.IPersona, IEmpleado {
    private String nombre;
    private Integer dni;
    private String email;
    private String direccion;
    private Integer telefono;
    private TIPOEMPLEADO tipoEmpleado;
    private Double salario;

    public Empleado(String nombre, Integer dni, String email, String direccion, Integer telefono, TIPOEMPLEADO tipoEmpleado, Double salario) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer getDni() {
        return dni;
    }

    @Override
    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Integer getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public TIPOEMPLEADO getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TIPOEMPLEADO tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public Double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
