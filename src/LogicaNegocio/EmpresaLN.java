package LogicaNegocio;

import Datos.Conexion;
import Entidades.Empresa;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpresaLN {
    
    public Empresa VerEmpresa() throws Exception{
        Empresa empresa = new Empresa();
        Conexion conn = new Conexion();
        List<Empresa> empresas = conn.ConsultarEmpresa();
        
        for (int i = 0; i < empresas.size(); i++) {
            if(empresas.get(i).getNombre() == 1) {
                empresa.setNombre(empresas.get(i).getNombre());
                empresa.setFechaInicio(empresas.get(i).getFechaInicio());
                empresa.setFechaFin(empresas.get(i).getFechaFin());
                break;
            }
        }
        return empresa;
    }
    
    public void ActualizarPeriodoEmpresa(int anioinicio,int mesinicio, int aniofin, int mesfin ){
        
        int diafin = 0;

        if(mesfin == 2){
            if((aniofin%4 == 0) && (aniofin%100 != 0) || (aniofin%400 == 0)) {
                diafin = 29;
            }else {
                diafin = 28;
            }
        }
        else if(mesfin == 4 || mesfin == 6 || mesfin == 9 || mesfin == 11){
            diafin = 30;
        }
        else {
            diafin = 31;
        }

        Conexion conn = new Conexion();

        conn.ActualizarPeriodoEmpresa(anioinicio, mesinicio, aniofin, mesfin, diafin);  

    }
    
}
