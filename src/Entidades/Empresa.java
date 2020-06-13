package Entidades;

import java.util.Date;

public class Empresa {
    
    private int Nombre;
    private Date FechaInicio;
    private Date FechaFin;

    public Empresa() {
    }

    
    public Empresa(int Nombre) {
        this.Nombre = Nombre;
    }

    public Empresa(Date FechaInicio, Date FechaFin) {
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public Empresa(int Nombre, Date FechaInicio, Date FechaFin) {
        this.Nombre = Nombre;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    
    
}
