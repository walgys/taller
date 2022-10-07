package com.taller.taller.bean;

import com.taller.taller.models.Horario;
import com.taller.taller.models.Mecanico;

public class HorarioMecanico {

   int horarioId;
   String horarioDesc;

   int mecanicoId;
   String mecanicoNombre;

    public HorarioMecanico(int horarioId, String horarioDesc, int mecanicoId, String mecanicoNombre) {
        this.horarioId = horarioId;
        this.horarioDesc = horarioDesc;
        this.mecanicoId = mecanicoId;
        this.mecanicoNombre = mecanicoNombre;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public String getHorarioDesc() {
        return horarioDesc;
    }

    public void setHorarioDesc(String horarioDesc) {
        this.horarioDesc = horarioDesc;
    }

    public int getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(int mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    public String getMecanicoNombre() {
        return mecanicoNombre;
    }

    public void setMecanicoNombre(String mecanicoNombre) {
        this.mecanicoNombre = mecanicoNombre;
    }
}
