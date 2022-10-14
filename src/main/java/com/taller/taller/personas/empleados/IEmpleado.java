package com.taller.taller.personas.empleados;

public interface IEmpleado {
    TIPOEMPLEADO getTipoEmpleado();

    void setTipoEmpleado(TIPOEMPLEADO tipoEmpleado);

    Double getSalario();

    void setSalario(Double salario);
}
