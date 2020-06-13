package LogicaNegocio;

import Datos.Conexion;
import Entidades.Cuenta;
import Entidades.DetalleTransaccion;
import Entidades.Naturaleza;
import Entidades.Subcuenta;
import Entidades.Transaccion;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleTransaccionLN {
    
    public List<DetalleTransaccion> ConsultarDetallesTransaccion(int patron) throws Exception{
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<DetalleTransaccion> detalles = conn.ListarDetalletransaccion(patron);
            return detalles;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public DetalleTransaccion ConsultarDetalleTransaccionporId(int patron) throws Exception {
        Conexion conn = new Conexion();
        DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
        
        try {
            List<DetalleTransaccion> detalles = conn.ListarDetalletransaccionporId(patron);
            
            for (int i = 0; i < detalles.size(); i++) {
                if(detalles.get(i).getIdDetalle() == patron) {
                    detalleTransaccion.setIdDetalle(detalles.get(i).getIdDetalle());

                    Transaccion transaccion = new Transaccion();
                    transaccion.setIdTransaccion(detalles.get(i).getoTransaccion().getIdTransaccion());
                    detalleTransaccion.setoTransaccion(transaccion);

                    Naturaleza naturaleza = new Naturaleza();
                    naturaleza.setIdNaturaleza(detalles.get(i).getoNaturaleza().getIdNaturaleza());
                    detalleTransaccion.setoNaturaleza(naturaleza);

                    Cuenta cuenta = new Cuenta();
                    cuenta.setCodigoCuenta(detalles.get(i).getoCuenta().getCodigoCuenta());
                    detalleTransaccion.setoCuenta(cuenta);

                    Subcuenta subcuenta = new Subcuenta();
                    subcuenta.setCodigoSubcuenta(detalles.get(i).getoSubcuenta().getCodigoSubcuenta());
                    detalleTransaccion.setoSubcuenta(subcuenta);

                    detalleTransaccion.setMonto(detalles.get(i).getMonto());
                    break;
                    
                }
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," No se encontró el detalle de la transacción ","Mensaje del Sistema",JOptionPane.WARNING_MESSAGE);
        }
        return detalleTransaccion;
    }
    
    public boolean RegistrarDetalleTransaccion(DetalleTransaccion detalleTransaccion) throws Exception {
        boolean registrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.IngresarDetalleTransaccion(detalleTransaccion)){
                registrado = true;
                JOptionPane.showMessageDialog(null, "Detalle Registrado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle No Registrado ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registrado;
    }
    
    public boolean ModificarDetalleTransaccion(DetalleTransaccion detalleTransaccion) throws Exception {
        boolean modificado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.ActualizarDetalleTransaccion(detalleTransaccion)){
                modificado = true;
                JOptionPane.showMessageDialog(null, "Detalle Actualizado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle No Actualizado ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return modificado;
    }
    
    public boolean BorrarDetalleTransaccion(int patron) throws Exception {
        boolean borrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.EliminarDetalleTransaccion(patron)){
                borrado = true;
                JOptionPane.showMessageDialog(null, "Detalle Eliminado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Detalle No Eliminado ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
    }    
    
    public boolean BorrarDetallesTransaccionporIdTransaccion(int patron) throws Exception {
        boolean borrado = false;
        
        try {
            Conexion conn = new Conexion();
            
            if(conn.EliminarDetalleTransaccionporIdTransaccion(patron)){
                borrado = true;
                JOptionPane.showMessageDialog(null, "Detalles de la Transacción Eliminados Correctamente");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
    }  
    
}
