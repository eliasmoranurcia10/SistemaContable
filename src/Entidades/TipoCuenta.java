package Entidades;

import java.util.List;

public class TipoCuenta {
    
    private int IdTipocuenta;
    private String NombreTipocuenta;
    private List<Cuenta> lCuenta;

    public TipoCuenta() {
    }

    public TipoCuenta(int IdTipocuenta) {
        this.IdTipocuenta = IdTipocuenta;
    }

    public TipoCuenta(int IdTipocuenta, String NombreTipocuenta) {
        this.IdTipocuenta = IdTipocuenta;
        this.NombreTipocuenta = NombreTipocuenta;
    }
    
    

    public TipoCuenta(int IdTipocuenta, String NombreTipocuenta, List<Cuenta> lCuenta) {
        this.IdTipocuenta = IdTipocuenta;
        this.NombreTipocuenta = NombreTipocuenta;
        this.lCuenta = lCuenta;
    }

    public int getIdTipocuenta() {
        return IdTipocuenta;
    }

    public void setIdTipocuenta(int IdTipocuenta) {
        this.IdTipocuenta = IdTipocuenta;
    }

    public String getNombreTipocuenta() {
        return NombreTipocuenta;
    }

    public void setNombreTipocuenta(String NombreTipocuenta) {
        this.NombreTipocuenta = NombreTipocuenta;
    }

    public List<Cuenta> getlCuenta() {
        return lCuenta;
    }

    public void setlCuenta(List<Cuenta> lCuenta) {
        this.lCuenta = lCuenta;
    }
    
    
    
}
