package LogicaNegocio;

import Datos.Conexion;
import Entidades.TipoCuenta;
import java.util.List;

public class TipoCuentaLN {
    
    public List<TipoCuenta> ConsultarTipoCuenta() throws Exception{
        
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<TipoCuenta> tipocuentas = conn.ListarTipoCuentas();
            return tipocuentas;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
