package Entidades;

import java.util.Date;
import java.util.List;

public class Transaccion {
    private int IdTransaccion;
    private Date Fecha;
    private String Descripcion;
    private List<DetalleTransaccion> lDetalleTransaccion;

    public Transaccion() {
    }

    public Transaccion(int IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public Transaccion(int IdTransaccion, Date Fecha, String Descripcion, List<DetalleTransaccion> lDetalleTransaccion) {
        this.IdTransaccion = IdTransaccion;
        this.Fecha = Fecha;
        this.Descripcion = Descripcion;
        this.lDetalleTransaccion = lDetalleTransaccion;
    }

    public int getIdTransaccion() {
        return IdTransaccion;
    }

    public void setIdTransaccion(int IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public List<DetalleTransaccion> getlDetalleTransaccion() {
        return lDetalleTransaccion;
    }

    public void setlDetalleTransaccion(List<DetalleTransaccion> lDetalleTransaccion) {
        this.lDetalleTransaccion = lDetalleTransaccion;
    }
    
    

    
}
