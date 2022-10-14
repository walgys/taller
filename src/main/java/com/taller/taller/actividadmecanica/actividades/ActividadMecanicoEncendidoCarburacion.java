package com.taller.taller.actividadmecanica.actividades;

import com.taller.taller.actividadmecanica.AddonEspecialidadMecanica;
import com.taller.taller.actividadmecanica.Actividad;

public class ActividadMecanicoEncendidoCarburacion extends AddonEspecialidadMecanica {
    private Actividad actividad;
    private Float precio;
    public ActividadMecanicoEncendidoCarburacion(Actividad actividad) {
        this.actividad = actividad;
    }
    public Float getPrecio(){
        return this.actividad.getPrecio() + precio;
    };

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
