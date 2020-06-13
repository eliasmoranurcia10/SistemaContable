package LogicaNegocio;

import Datos.Conexion;
import Entidades.Cuenta;
import Entidades.Subcuenta;
import java.util.List;
import javax.swing.JOptionPane;

public class SubcuentaLN {
    
    
    public List<Subcuenta> ConsultarSubcuentas(String patron) throws Exception{
        Conexion conn;
        
        try {
            
            conn = new Conexion();
            List<Subcuenta> subcuentas = conn.ListarSubcuentas(patron);
            return subcuentas;
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Subcuenta ConsultarSubcuentaporCodigo(int id) throws Exception{
        
        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();
        
        try {
            Conexion conn = new Conexion();
            List<Subcuenta> acceso = conn.ConsultarSubcuenta(id);
            
            for(Subcuenta subcta : acceso){
                if(subcta.getCodigoSubcuenta() == id){
                    
                    subcuenta.setCodigoSubcuenta(subcta.getCodigoSubcuenta());
                    subcuenta.setNombreSubcuenta(subcta.getNombreSubcuenta());
                    cuenta.setCodigoCuenta(subcta.getoCuenta().getCodigoCuenta());
                    subcuenta.setoCuenta(cuenta);
                    break;
                    
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return subcuenta;
        
    }
    
    public Subcuenta ConsultarSubcuentaporNombre(String patron) throws Exception{
        
        Subcuenta subcuenta = new Subcuenta();
        Cuenta cuenta = new Cuenta();
        
        try {
            Conexion conn = new Conexion();
            List<Subcuenta> acceso = conn.ConsultarSubcuentaporNombre(patron);
            
            for(Subcuenta subcta : acceso){
                if(subcta.getNombreSubcuenta().equals(patron)){
                    
                    subcuenta.setCodigoSubcuenta(subcta.getCodigoSubcuenta());
                    subcuenta.setNombreSubcuenta(subcta.getNombreSubcuenta());
                    cuenta.setCodigoCuenta(subcta.getoCuenta().getCodigoCuenta());
                    subcuenta.setoCuenta(cuenta);
                    break;
                    
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return subcuenta;
        
    }
    
    public boolean RegistrarSubcuenta(Subcuenta subcuenta) throws Exception{
        boolean registrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.IngresarSubcuenta(subcuenta)){
                registrado = true;
                JOptionPane.showMessageDialog(null, "Subcuenta Registrada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Subcuenta No registrada ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registrado;
    }
    
    public boolean ModificarSubcuenta(Subcuenta subcuenta) throws Exception {
        boolean modificado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.ActualizarSubcuenta(subcuenta)){
                modificado = true;
                JOptionPane.showMessageDialog(null, "Subcuenta Modificada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Subcuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return modificado;
    }
    
    public boolean BorrarSubcuenta (Subcuenta subcuenta) throws Exception {
        boolean borrado = false;
        try {
            Conexion conn = new Conexion();
            if(conn.EliminarSubcuenta(subcuenta)){
                borrado = true;
                JOptionPane.showMessageDialog(null, "Subcuenta Eliminada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Subcuenta No Eliminada", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Subcuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
    }
    
}
