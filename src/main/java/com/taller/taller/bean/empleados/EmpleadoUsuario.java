package com.taller.taller.bean.empleados;

import com.taller.taller.personas.IPersona;
import com.taller.taller.personas.empleados.IEmpleado;
import com.taller.taller.personas.empleados.IUsuario;
import com.taller.taller.personas.empleados.TIPOEMPLEADO;

public class EmpleadoUsuario extends Empleado implements IUsuario, IEmpleado {
    private String usuario;
    private String password;

    public EmpleadoUsuario(String nombre, Integer dni, String email, String direccion, Integer telefono, TIPOEMPLEADO tipoEmpleado, Double salario, String usuario, String password) {
        super(nombre, dni, email, direccion, telefono, tipoEmpleado, salario);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public String getUsuario() {
        return null;
    }

    @Override
    public void setUsuario(String usuario) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }
}
