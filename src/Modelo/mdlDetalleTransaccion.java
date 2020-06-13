package Modelo;

import Entidades.DetalleTransaccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class mdlDetalleTransaccion extends AbstractTableModel{

    private String[] columnas = {"Id Detalle","Código Cuenta", "Codigo Subcuenta","Debe","Haber"};
    
    private List<DetalleTransaccion> listadetalles = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return listadetalles.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;
        
        if(columnIndex == 0) {
            resultado = listadetalles.get(rowIndex).getIdDetalle();
        }
        else if(columnIndex == 1) {
            resultado = listadetalles.get(rowIndex).getoCuenta().getCodigoCuenta();
        }
        else if(columnIndex == 2) {
            resultado = listadetalles.get(rowIndex).getoSubcuenta().getCodigoSubcuenta();
        }
        else if(columnIndex == 3) {
            if(listadetalles.get(rowIndex).getoNaturaleza().getIdNaturaleza().equals("D")) {
                resultado = listadetalles.get(rowIndex).getMonto();
            } else {
                resultado = "";
            }    
        }
        else if(columnIndex == 4) {
            if(listadetalles.get(rowIndex).getoNaturaleza().getIdNaturaleza().equals("H")) {
                resultado = listadetalles.get(rowIndex).getMonto();
            } else {
                resultado = "";
            }
        }
        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    public void EstablecerDetallesTransaccion(List<DetalleTransaccion> detallesTransaccion) {
        listadetalles = detallesTransaccion;
    }
    
    public void AgregarDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        listadetalles.add(detalleTransaccion);
        fireTableDataChanged();
    }
    
    public void EliminarDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        listadetalles.remove(detalleTransaccion);
        fireTableDataChanged();
    }
    
    public List<DetalleTransaccion> ObtenerDetallesTransaccion() {
        return this.listadetalles;
    }
    
    
    
    
    
}
