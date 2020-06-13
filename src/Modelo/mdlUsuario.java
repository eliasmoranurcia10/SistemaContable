package Modelo;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mdlUsuario extends AbstractTableModel{

    //Establece las columnas
    private String[] columnas = {"Id","Nombres","Apellidos","Tipo de Usuario","Usuario","Contraseña"};
    
    //Establece las filas
    private List<Usuario> listausuario = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return listausuario.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado;
        
        if(columnIndex == 0){
            resultado = listausuario.get(rowIndex).getId();    
        }
        else if(columnIndex == 1){
            resultado = listausuario.get(rowIndex).getNombre();
        }
        else if(columnIndex == 2){
            resultado = listausuario.get(rowIndex).getApellidos();
        }
        else if(columnIndex == 3){
            resultado = listausuario.get(rowIndex).getTipousuario();
        }
        else if(columnIndex == 4){
            resultado = listausuario.get(rowIndex).getUser();
        }
        else{
            resultado = listausuario.get(rowIndex).getPassword();
        }
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    
    
    
    public void EstablecerUsuarios(List<Usuario> usuarios){
        listausuario = usuarios;
    }
    
    
    
    
    public void AgregarUsuario(Usuario usuario){
        listausuario.add(usuario);
        fireTableDataChanged();
    }
    
    public void EliminarUsuario(Usuario usuario){
        listausuario.remove(usuario);
        fireTableDataChanged();
    }
    
    public List<Usuario> ObtenerUsuarios(){
        return this.listausuario;
    }
}
