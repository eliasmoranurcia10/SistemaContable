package Modelo;

import Entidades.Cuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mdlCuenta extends AbstractTableModel{

    private String[] columnas = {"Codigo Cuenta","Nombre Cuenta"};
    
    private List<Cuenta> listacuenta = new ArrayList<>();
    
    
    @Override
    public int getRowCount() {
        return listacuenta.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;
        
        if(columnIndex == 0){
            resultado = listacuenta.get(rowIndex).getCodigoCuenta();
        }
        else if(columnIndex == 1){
            resultado = listacuenta.get(rowIndex).getNombreCuenta();
        }
        
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
    
    
    
    public void EstablecerCuentas(List<Cuenta> cuentas){
        listacuenta = cuentas;
    }
    
    public void AgregarCuenta(Cuenta cuenta){
        listacuenta.add(cuenta);
        fireTableDataChanged();
    }
    
    public void EliminarCuenta(Cuenta cuenta) {
        listacuenta.remove(cuenta);
        fireTableDataChanged();
    }
    
    public List<Cuenta> ObtenerCuentas(){
        return this.listacuenta;
    }
    
}
