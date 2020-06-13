package Entidades;

import java.util.List;

public class Naturaleza {
    
    private String IdNaturaleza;
    private String NombreNaturaleza;
    private List<DetalleTransaccion> lDetalleTransaccion;

    public Naturaleza() {
    }

    public Naturaleza(String IdNaturaleza) {
        this.IdNaturaleza = IdNaturaleza;
    }

    public Naturaleza(String IdNaturaleza, String NombreNaturaleza, List<DetalleTransaccion> lDetalleTransaccion) {
        this.IdNaturaleza = IdNaturaleza;
        this.NombreNaturaleza = NombreNaturaleza;
        this.lDetalleTransaccion = lDetalleTransaccion;
    }

    public String getIdNaturaleza() {
        return IdNaturaleza;
    }

    public void setIdNaturaleza(String IdNaturaleza) {
        this.IdNaturaleza = IdNaturaleza;
    }

    public String getNombreNaturaleza() {
        return NombreNaturaleza;
    }

    public void setNombreNaturaleza(String NombreNaturaleza) {
        this.NombreNaturaleza = NombreNaturaleza;
    }

    public List<DetalleTransaccion> getlDetalleTransaccion() {
        return lDetalleTransaccion;
    }

    public void setlDetalleTransaccion(List<DetalleTransaccion> lDetalleTransaccion) {
        this.lDetalleTransaccion = lDetalleTransaccion;
    }
    
    
    
}
