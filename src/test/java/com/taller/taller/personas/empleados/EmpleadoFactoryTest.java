package com.taller.taller.personas.empleados;

import com.taller.taller.bean.empleados.Empleado;
import com.taller.taller.bean.empleados.EmpleadoUsuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoFactoryTest {

    EmpleadoFactory factory = EmpleadoFactory.instance();

    @Test
    void instance() {
        assertNotNull(factory);
    }

    @Test
    void crearEmpleadoTipoEmpleado() {
        Empleado mecanicoChapaPintura = factory.crearEmpleado(TIPOEMPLEADO.MecanicoChapaPintura);
        assertEquals(mecanicoChapaPintura.getClass(), Empleado.class);
        assertNotEquals(mecanicoChapaPintura.getClass(), EmpleadoUsuario.class);
    }

    @Test
    void crearEmpleadoTipoEmpleadoUsuario() {
        Empleado encargadoRecepcion = factory.crearEmpleado(TIPOEMPLEADO.EncargadoRecepcion);
        assertEquals(encargadoRecepcion.getClass(), EmpleadoUsuario.class);
        assertNotEquals(encargadoRecepcion.getClass(), Empleado.class);
    }
}