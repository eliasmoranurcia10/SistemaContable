package Modelo;

import Entidades.Transaccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mdlTransaccion extends AbstractTableModel{
    
    private String[] columnas = {" Id Transacción "," Fecha "," Descripción "};
    
    private List<Transaccion> listatransaccion = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listatransaccion.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;
        
        if(columnIndex == 0) {
            resultado = listatransaccion.get(rowIndex).getIdTransaccion();
        }
        else if (columnIndex == 1) {
            resultado = listatransaccion.get(rowIndex).getFecha();
        }
        else if (columnIndex == 2) {
            resultado = listatransaccion.get(rowIndex).getDescripcion();
        }
        
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    public void EstablecerTransacciones(List<Transaccion> transacciones) {
        listatransaccion = transacciones;
    }
    
    public void AgregarTransaccion(Transaccion transaccion) {
        listatransaccion.add(transaccion);
        fireTableDataChanged();
    }
    
    public void EliminarTransaccion(Transaccion transaccion) {
        listatransaccion.remove(transaccion);
        fireTableDataChanged();
    }
    
    public List<Transaccion> ObtenerTransacciones() {
        return this.listatransaccion;
    }
    

    
    
    
    
    
    
}
