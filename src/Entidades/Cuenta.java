package Entidades;

import java.util.List;

public class Cuenta {
    
    private int CodigoCuenta;
    private String NombreCuenta;
    private TipoCuenta oTipoCuenta;
    private int SaldoInicial;
    private int SaldoInicialDebe;
    private int SaldoInicialHaber;
    private int SaldoFinalDebe;
    private int SaldoFinalHaber;
    private List<DetalleTransaccion> lDetalleTransaccion;
    private List<Subcuenta> lSubcuenta;

    public Cuenta() {
    }

    public Cuenta(int CodigoCuenta) {
        this.CodigoCuenta = CodigoCuenta;
    }

    public Cuenta(int CodigoCuenta, String NombreCuenta, int SaldoInicialDebe, int SaldoInicialHaber) {
        this.CodigoCuenta = CodigoCuenta;
        this.NombreCuenta = NombreCuenta;
        this.SaldoInicialDebe = SaldoInicialDebe;
        this.SaldoInicialHaber = SaldoInicialHaber;
    }
    
    

    public Cuenta(int CodigoCuenta, String NombreCuenta, TipoCuenta oTipoCuenta, int SaldoInicial, int SaldoInicialDebe, int SaldoInicialHaber, int SaldoFinalDebe, int SaldoFinalHaber, List<DetalleTransaccion> lDetalleTransaccion, List<Subcuenta> lSubcuenta) {
        this.CodigoCuenta = CodigoCuenta;
        this.NombreCuenta = NombreCuenta;
        this.oTipoCuenta = oTipoCuenta;
        this.SaldoInicial = SaldoInicial;
        this.SaldoInicialDebe = SaldoInicialDebe;
        this.SaldoInicialHaber = SaldoInicialHaber;
        this.SaldoFinalDebe = SaldoFinalDebe;
        this.SaldoFinalHaber = SaldoFinalHaber;
        this.lDetalleTransaccion = lDetalleTransaccion;
        this.lSubcuenta = lSubcuenta;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int CodigoCuenta) {
        this.CodigoCuenta = CodigoCuenta;
    }

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

    public TipoCuenta getoTipoCuenta() {
        return oTipoCuenta;
    }

    public void setoTipoCuenta(TipoCuenta oTipoCuenta) {
        this.oTipoCuenta = oTipoCuenta;
    }

    public int getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(int SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public int getSaldoInicialDebe() {
        return SaldoInicialDebe;
    }

    public void setSaldoInicialDebe(int SaldoInicialDebe) {
        this.SaldoInicialDebe = SaldoInicialDebe;
    }

    public int getSaldoInicialHaber() {
        return SaldoInicialHaber;
    }

    public void setSaldoInicialHaber(int SaldoInicialHaber) {
        this.SaldoInicialHaber = SaldoInicialHaber;
    }

    public int getSaldoFinalDebe() {
        return SaldoFinalDebe;
    }

    public void setSaldoFinalDebe(int SaldoFinalDebe) {
        this.SaldoFinalDebe = SaldoFinalDebe;
    }

    public int getSaldoFinalHaber() {
        return SaldoFinalHaber;
    }

    public void setSaldoFinalHaber(int SaldoFinalHaber) {
        this.SaldoFinalHaber = SaldoFinalHaber;
    }

    public List<DetalleTransaccion> getlDetalleTransaccion() {
        return lDetalleTransaccion;
    }

    public void setlDetalleTransaccion(List<DetalleTransaccion> lDetalleTransaccion) {
        this.lDetalleTransaccion = lDetalleTransaccion;
    }

    public List<Subcuenta> getlSubcuenta() {
        return lSubcuenta;
    }

    public void setlSubcuenta(List<Subcuenta> lSubcuenta) {
        this.lSubcuenta = lSubcuenta;
    }
    
    
    
    
}
