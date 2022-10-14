package com.taller.taller.personas.empleados;

import com.taller.taller.bean.empleados.Empleado;
import com.taller.taller.bean.empleados.EmpleadoUsuario;

public class EmpleadoFactory {

    private static final Object LOCK_OBJECT = new Object();
    private static volatile EmpleadoFactory _instance = null;

    public static EmpleadoFactory instance(){
        if (_instance == null) {
            synchronized (LOCK_OBJECT) {
                if (_instance == null) {
                    _instance = new EmpleadoFactory();
                }
            }
        }
        return _instance;
    }

    public Empleado crearEmpleado(final TIPOEMPLEADO tipoUsuario){
        switch (tipoUsuario){
            case EncargadoRecepcion:
                return new EmpleadoUsuario("",null,"","",null,TIPOEMPLEADO.EncargadoTaller,null,"","");
            case MecanicoChapaPintura:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoChapaPintura,null);
            case MecanicoFreno:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoFreno,null);
            case MecanicoGeneral:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoGeneral,null);
            case EncargadoTaller:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.EncargadoTaller,null);
            case MecanicoElecticidad:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoElecticidad,null);
            case MecanicoEncendidoCarburacion:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoEncendidoCarburacion,null);
            case MecanicoTrenAmortiguacion:
                return new Empleado("",null,"","",null,TIPOEMPLEADO.MecanicoTrenAmortiguacion,null);
            default:
                return null;
        }
    }

}
