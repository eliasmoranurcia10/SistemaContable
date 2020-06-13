package Entidades;

public class DetalleTransaccion {
    
    private int IdDetalle;
    private Transaccion oTransaccion;
    private Cuenta oCuenta;
    private Subcuenta oSubcuenta;
    private Naturaleza oNaturaleza;
    private int Monto;

    public DetalleTransaccion() {
    }

    public DetalleTransaccion(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public DetalleTransaccion(int IdDetalle, Transaccion oTransaccion, Cuenta oCuenta, Subcuenta oSubcuenta, Naturaleza oNaturaleza, int Monto) {
        this.IdDetalle = IdDetalle;
        this.oTransaccion = oTransaccion;
        this.oCuenta = oCuenta;
        this.oSubcuenta = oSubcuenta;
        this.oNaturaleza = oNaturaleza;
        this.Monto = Monto;
    }

    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public Transaccion getoTransaccion() {
        return oTransaccion;
    }

    public void setoTransaccion(Transaccion oTransaccion) {
        this.oTransaccion = oTransaccion;
    }

    public Cuenta getoCuenta() {
        return oCuenta;
    }

    public void setoCuenta(Cuenta oCuenta) {
        this.oCuenta = oCuenta;
    }

    public Subcuenta getoSubcuenta() {
        return oSubcuenta;
    }

    public void setoSubcuenta(Subcuenta oSubcuenta) {
        this.oSubcuenta = oSubcuenta;
    }

    public Naturaleza getoNaturaleza() {
        return oNaturaleza;
    }

    public void setoNaturaleza(Naturaleza oNaturaleza) {
        this.oNaturaleza = oNaturaleza;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }
    
    
    
    
}
