package LogicaNegocio;

import Datos.Conexion;
import Entidades.Naturaleza;
import java.util.List;

public class NaturalezaLN {
    
    public List<Naturaleza> ConsultarNaturaleza() throws Exception{
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<Naturaleza> naturalezas = conn.ListarNaturalezas();
            return naturalezas;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
