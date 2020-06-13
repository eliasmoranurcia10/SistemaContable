package LogicaNegocio;

import Datos.Conexion;
import Entidades.Transaccion;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TransaccionLN {
    
    public List<Transaccion> ConsultarTransacciones(String patron) throws Exception {
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<Transaccion> transacciones = conn.ListarTransacciones(patron);
            return transacciones;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Transaccion ConsultarporId(String idtransaccion) throws Exception{
        Transaccion transaccion = new Transaccion();
        
        try {
            Conexion conn = new Conexion();
            List<Transaccion> transacciones = conn.ConsultarTransaccion(idtransaccion);
            
            for (int i = 0; i < transacciones.size(); i++) {
                if(transacciones.get(i).getIdTransaccion() == Integer.parseInt(idtransaccion)) {
                    transaccion = transacciones.get(i);
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return transaccion;
    }
    
    public boolean RegistrarTransaccion(Transaccion transaccion) throws Exception {
        boolean registrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.IngresarTransaccion(transaccion)) {
                registrado = true;
                JOptionPane.showMessageDialog(null, "Transacción Registrada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, " No se registró la Transacción ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registrado;
        
    }
    
    public boolean ModificarTransaccion(Transaccion transaccion) throws Exception {
        boolean modificado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.ActualizarTransaccion(transaccion)) {
                modificado = true;
                JOptionPane.showMessageDialog(null, "Transacción Modificada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, " No se modificó la Transacción ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return modificado;
        
    }
    
    public boolean BorrarTransaccion(int patron) throws Exception {
        boolean borrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.EliminarTransaccion(patron)) {
                borrado = true;
                JOptionPane.showMessageDialog(null, "Transacción Eliminada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, " No se eliminó la Transacción ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
        
    }    

}
