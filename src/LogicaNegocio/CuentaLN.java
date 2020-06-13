package LogicaNegocio;

import Datos.Conexion;
import Entidades.Cuenta;
import Entidades.TipoCuenta;
import java.util.List;
import javax.swing.JOptionPane;

public class CuentaLN {
    
    public List<Cuenta> ConsultarCuentas(String patron, String patron2) throws Exception{
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<Cuenta> cuentas = conn.ListarCuentas(patron, patron2);
            return cuentas;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cuenta ConsultarCuentaporCodigo(int id) throws Exception{
        
        Cuenta cuenta = new Cuenta();
        TipoCuenta tipoCuenta = new TipoCuenta();
        try {
            Conexion conn = new Conexion();
            List<Cuenta> acceso = conn.ConsultarCuenta(id);
            
            for(Cuenta cta: acceso){
                
                if(cta.getCodigoCuenta() == id){
                    
                    cuenta.setCodigoCuenta(cta.getCodigoCuenta());
                    cuenta.setNombreCuenta(cta.getNombreCuenta());
                    tipoCuenta.setIdTipocuenta(cta.getoTipoCuenta().getIdTipocuenta());
                    cuenta.setoTipoCuenta(tipoCuenta);
//                    cuenta.setSaldoInicial(cta.getSaldoInicial());
//                    cuenta.setSaldoInicialDebe(cta.getSaldoInicialDebe());
//                    cuenta.setSaldoInicialHaber(cta.getSaldoInicialHaber());
//                    cuenta.setSaldoFinalDebe(cta.getSaldoFinalDebe());
//                    cuenta.setSaldoFinalHaber(cta.getSaldoFinalHaber());
                    break;    
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se encontró la cuenta","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
        return cuenta;
        
    }
    
    public Cuenta ConsultarCuentaporNombre(String nombre) throws Exception {
        
        Cuenta cuenta = new Cuenta();
        TipoCuenta tipoCuenta = new TipoCuenta();
        try {
            Conexion conn = new Conexion();
            List<Cuenta> acceso = conn.ConsultarCuentaNombre(nombre);
            
            for(Cuenta cta: acceso){
                
                if(cta.getNombreCuenta().equals(nombre)){
                    
                    cuenta.setCodigoCuenta(cta.getCodigoCuenta());
                    cuenta.setNombreCuenta(cta.getNombreCuenta());
                    tipoCuenta.setIdTipocuenta(cta.getoTipoCuenta().getIdTipocuenta());
                    cuenta.setoTipoCuenta(tipoCuenta);
//                    cuenta.setSaldoInicial(cta.getSaldoInicial());
//                    cuenta.setSaldoInicialDebe(cta.getSaldoInicialDebe());
//                    cuenta.setSaldoInicialHaber(cta.getSaldoInicialHaber());
//                    cuenta.setSaldoFinalDebe(cta.getSaldoFinalDebe());
//                    cuenta.setSaldoFinalHaber(cta.getSaldoFinalHaber());
                    break;    
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se encontró la cuenta","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        
        return cuenta;
        
    }
    
    public List<Cuenta> ConsultarSaldosIniciales() throws Exception{
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<Cuenta> cuentas = conn.VerSaldosInicialesdeCuentas();
            return cuentas;
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean RegistrarCuenta(Cuenta cuenta) throws Exception{
        boolean registrado = false;
        
        try {
            Conexion conn = new Conexion();
            if (conn.IngresarCuenta(cuenta)) {
                registrado = true;
                JOptionPane.showMessageDialog(null, "Cuenta Registrada Correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "Cuenta No registrada ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registrado;
    }
    
    public boolean ModificarCuenta(Cuenta cuenta) throws Exception{
        boolean modificado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.ActualizarCuenta(cuenta)){
                modificado = true;
                JOptionPane.showMessageDialog(null, "Cuenta Modificada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return modificado;
    }
    
    public boolean BorrarCuenta(Cuenta cuenta) throws Exception{
        boolean borrado = false;
        try {
            Conexion conn = new Conexion();
            if(conn.EliminarCuenta(cuenta)){
                borrado = true;
                JOptionPane.showMessageDialog(null, "Cuenta Eliminada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta No Eliminada", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
    }
}
