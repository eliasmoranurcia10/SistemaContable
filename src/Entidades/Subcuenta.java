package Entidades;

import java.util.List;

public class Subcuenta {
    
    private int CodigoSubcuenta;
    private String NombreSubcuenta;
    private Cuenta oCuenta;
    private List<DetalleTransaccion> lDetalleTransaccion;

    public Subcuenta() {
    }

    public Subcuenta(int CodigoSubcuenta) {
        this.CodigoSubcuenta = CodigoSubcuenta;
    }

    public Subcuenta(int CodigoSubcuenta, String NombreSubcuenta, Cuenta oCuenta, List<DetalleTransaccion> lDetalleTransaccion) {
        this.CodigoSubcuenta = CodigoSubcuenta;
        this.NombreSubcuenta = NombreSubcuenta;
        this.oCuenta = oCuenta;
        this.lDetalleTransaccion = lDetalleTransaccion;
    }

    public int getCodigoSubcuenta() {
        return CodigoSubcuenta;
    }

    public void setCodigoSubcuenta(int CodigoSubcuenta) {
        this.CodigoSubcuenta = CodigoSubcuenta;
    }

    public String getNombreSubcuenta() {
        return NombreSubcuenta;
    }

    public void setNombreSubcuenta(String NombreSubcuenta) {
        this.NombreSubcuenta = NombreSubcuenta;
    }

    public Cuenta getoCuenta() {
        return oCuenta;
    }

    public void setoCuenta(Cuenta oCuenta) {
        this.oCuenta = oCuenta;
    }

    public List<DetalleTransaccion> getlDetalleTransaccion() {
        return lDetalleTransaccion;
    }

    public void setlDetalleTransaccion(List<DetalleTransaccion> lDetalleTransaccion) {
        this.lDetalleTransaccion = lDetalleTransaccion;
    }
    
    

}
