package Modelo;

import Entidades.Subcuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mdlSubcuenta extends AbstractTableModel{

    private String[] columnas = {"Código Subcuenta", "Nombre SubCuenta"};
    
    private List<Subcuenta> listasubcuenta = new ArrayList<>();
            
            
    @Override
    public int getRowCount() {
        return listasubcuenta.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;
        
        if(columnIndex == 0){
            resultado = listasubcuenta.get(rowIndex).getCodigoSubcuenta();
        } 
        else if(columnIndex == 1) {
            resultado = listasubcuenta.get(rowIndex).getNombreSubcuenta();
        }
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
    
    
    public void EstablecerSubcuentas(List<Subcuenta> subcuentas) {
        listasubcuenta = subcuentas;
    }
    
    public void AgregarSubcuenta(Subcuenta subcuenta) {
        listasubcuenta.add(subcuenta);
        fireTableDataChanged();
    }
    
    public void EliminarSubcuenta(Subcuenta subcuenta){
        listasubcuenta.remove(subcuenta);
        fireTableDataChanged();
    }
    
    public List<Subcuenta> ObtenerSubcuenta(){
        return this.listasubcuenta;
    }
    
    
    
}
