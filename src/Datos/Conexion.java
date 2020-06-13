package Datos;

import Entidades.Cuenta;
import Entidades.DetalleTransaccion;
import Entidades.Empresa;
import Entidades.Naturaleza;
import Entidades.Subcuenta;
import Entidades.TipoCuenta;
import Entidades.Transaccion;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexion {
    
    private Connection cnx = null;
    private Statement sta = null;
    private ResultSet rs = null;

    public Conexion() {
    }
    
    public void Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys_contables2","root","1234");
            sta = cnx.createStatement();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/sys_contables2","root","1234");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
    //Para el Usuario------------------------------------------------------------------------------------
    
    public List<Usuario> AccesoUsuario(Usuario usuario) throws Exception{
        Conexion();
        List<Usuario> usuarios = new ArrayList<>();
        rs = sta.executeQuery("select * from usuarios where usuario = '"+usuario.getUser()+"' and contra = '"+usuario.getPassword()+"' ;");
        
        while(rs.next()){
            
            Usuario usu = new Usuario();
            usu.setId((Integer) rs.getObject(1));
            usu.setNombre((String) rs.getObject(2));
            usu.setApellidos((String) rs.getObject(3));
            usu.setTipousuario((String) rs.getObject(4));
            usu.setUser((String) rs.getObject(5));
            usu.setPassword((String) rs.getObject(6));
            
            usuarios.add(usu);
        }
        return usuarios;
    }
    
    public List<Usuario> ListarUsuarios(String patron) throws Exception{
        List<Usuario> usuarios = new ArrayList<>();
        
        Conexion();
        rs = sta.executeQuery("select * from usuarios where nombres like '"+patron+"%' order by id_usuario;");
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            
            usuario.setId((Integer) rs.getObject(1));
            usuario.setNombre((String) rs.getObject(2));
            usuario.setApellidos((String) rs.getObject(3));
            usuario.setTipousuario((String) rs.getObject(4));
            usuario.setUser((String) rs.getObject(5));
            usuario.setPassword((String) rs.getObject(6));
            
            usuarios.add(usuario);
        }
        return usuarios;
    }
    
    public boolean IngresarUsuario(Usuario usuario) {
        boolean ingresado = false;
        
        try {
            Conexion();
            
            int i  = sta.executeUpdate("INSERT INTO usuarios "
                    + "(id_usuario, nombres, apellidos, tipo_usuario, usuario, contra) "
                    + "VALUES ("+usuario.getId()+",'"+usuario.getNombre()+"','"+usuario.getApellidos()+"',"
                    + "'"+usuario.getTipousuario()+"','"+usuario.getUser()+"','"+usuario.getPassword()+"');");
            
            if(i>0){
                ingresado = true;
                i=0;
            }else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return  ingresado;
    }
    
    public List<Usuario> ConsultarUsuario(int id) throws Exception{
        Conexion();
        List<Usuario> usuarios = new ArrayList<>();
        
        rs = sta.executeQuery("select * from usuarios where id_usuario = '"+id+"'; ");
        
        while(rs.next()){
            
            Usuario usu = new Usuario();
            usu.setId((Integer) rs.getObject(1));
            usu.setNombre((String) rs.getObject(2));
            usu.setApellidos((String) rs.getObject(3));
            usu.setTipousuario((String) rs.getObject(4));
            usu.setUser((String) rs.getObject(5));
            usu.setPassword((String) rs.getObject(6));
            
            usuarios.add(usu);
        }
        return usuarios;
    }
    
    public boolean ActualizarUsuario(Usuario usuario) {
        boolean actualizado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("UPDATE usuarios set "
                + "nombres='"+usuario.getNombre()+"',apellidos='"+usuario.getApellidos()+"',"
                + "tipo_usuario='"+usuario.getTipousuario()+"',usuario='"+usuario.getUser()+"',contra='"+usuario.getPassword()+"' "
                + "where id_usuario = "+usuario.getId()+";");
            
            if(i>0){
                actualizado = true;
                i=0;
            }else{
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return actualizado;
    }
    
    public boolean EliminarUsuario(Usuario usuario) {
        boolean eliminado = false;
        try {
            Conexion();
            int i = sta.executeUpdate("delete from usuarios where id_usuario = "+usuario.getId()+";");
            
            if(i > 0){
                eliminado = true;
                i=0;
            }else{
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }
    
    
    //Para la Empresa--------------------------------------------------------------------------------------------
    
    public List<Empresa> ConsultarEmpresa() throws Exception{
        Conexion();
        List<Empresa> empresas = new ArrayList<>();
        
        rs = sta.executeQuery("select * from empresa;");
        
        while (rs.next()) {
            Empresa empresa = new Empresa();
            
            empresa.setNombre((Integer) rs.getObject(1));
            empresa.setFechaInicio((Date)rs.getObject(2));
            empresa.setFechaFin((Date) rs.getObject(3));
            
            empresas.add(empresa);
        }
        return empresas;
        
        
    }
    
    public boolean ActualizarPeriodoEmpresa(int anioinicio,int mesinicio, int aniofin, int mesfin, int diafin ){
        
        boolean actualizado = false;
        try {
            Conexion();
            int i = sta.executeUpdate("UPDATE empresa SET NOMBRE='1',"
                + "InicioPeriodo='"+anioinicio+"-"+mesinicio+"-01',"
                + "finPeriodo='"+aniofin+"-"+mesfin+"-"+diafin+"' WHERE NOMBRE = 1");
            
            if(i>0){
                actualizado = true;
                i = 0;
            }else {
                JOptionPane.showMessageDialog(null, "No actualizado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        return actualizado;
    }
    
    
    //Para las Cuentas -------------------------------------------------------------------------------------------
    
    public List<Cuenta> ListarCuentas(String patron, String patron2) throws Exception{
        List<Cuenta> cuentas = new ArrayList<>();
        
        Conexion();
        rs = sta.executeQuery("select cod_cta,nombre_cta from cuenta where cod_cta like '"+patron+"%' and nombre_cta like '"+patron2+"%' order by cod_cta;");
        
        while(rs.next()){
            Cuenta cuenta = new Cuenta();
            
            cuenta.setCodigoCuenta((Integer) rs.getObject(1));
            cuenta.setNombreCuenta((String) rs.getObject(2));
            
            cuentas.add(cuenta);
        }
        return cuentas;
    }
    
    public List<Cuenta> ConsultarCuenta(int id) throws Exception{
        Conexion();
        List<Cuenta> cuentas = new ArrayList<>();
        
        rs = sta.executeQuery("select * from cuenta where cod_cta = "+id+";");
        
        while (rs.next()) {  
            Cuenta cuenta = new Cuenta();
            TipoCuenta tipoCuenta = new TipoCuenta();
            cuenta.setCodigoCuenta((Integer) rs.getObject(1));
            cuenta.setNombreCuenta((String) rs.getObject(2));
            tipoCuenta.setIdTipocuenta((Integer) rs.getObject(3));
            cuenta.setoTipoCuenta(tipoCuenta);
//            cuenta.setSaldoInicial((Integer) rs.getObject(4));
//            cuenta.setSaldoInicialDebe((Integer) rs.getObject(5));
//            cuenta.setSaldoInicialHaber((Integer) rs.getObject(6));
//            cuenta.setSaldoFinalDebe((Integer) rs.getObject(7));
//            cuenta.setSaldoFinalHaber((Integer) rs.getObject(8));
            
            cuentas.add(cuenta);
        }
        return cuentas;
    }
    
    public List<Cuenta> ConsultarCuentaNombre(String nombre) throws Exception {
        Conexion();
        List<Cuenta> cuentas = new ArrayList<>();
        
        rs = sta.executeQuery("select * from cuenta where nombre_cta like '"+nombre+"';");
        
        while(rs.next()) {
            Cuenta cuenta = new Cuenta();
            TipoCuenta tipoCuenta = new TipoCuenta();
            cuenta.setCodigoCuenta((Integer) rs.getObject(1));
            cuenta.setNombreCuenta((String) rs.getObject(2));
            tipoCuenta.setIdTipocuenta((Integer) rs.getObject(3));
            cuenta.setoTipoCuenta(tipoCuenta);
            
            cuentas.add(cuenta);
        }
        
        return cuentas;
    }
    
    public List<Cuenta> VerSaldosInicialesdeCuentas() throws Exception {
        List<Cuenta> cuentas = new ArrayList<>();
        Conexion();
        
        rs = sta.executeQuery("select cod_cta, nombre_cta, SaldoInicDEBE, SaldoInicHABER from cuenta where SaldoInicDEBE != 0 or SaldoInicHABER != 0;");
        
        while (rs.next()) {   
            Cuenta cuenta = new Cuenta();
            
            cuenta.setCodigoCuenta((Integer) rs.getObject(1));
            cuenta.setNombreCuenta((String) rs.getObject(2));
            cuenta.setSaldoInicialDebe((Integer) rs.getObject(3));
            cuenta.setSaldoInicialHaber((Integer) rs.getObject(4));
            
            cuentas.add(cuenta);
            
        }
        
        return cuentas;
    }
            
    public boolean IngresarCuenta(Cuenta cuenta){
        
        boolean ingresado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("INSERT INTO cuenta(cod_cta,nombre_cta,tipo_cuenta_id_tipocta,SaldoI,SaldoInicDEBE,SaldoInicHABER) "
                + "VALUES ("+cuenta.getCodigoCuenta()+",'"+cuenta.getNombreCuenta()+"'"
                + ","+cuenta.getoTipoCuenta().getIdTipocuenta()+",0,0,0);");
            
            if(i>0){
                ingresado = true;
                i = 0;
            }else{
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return ingresado;
    }
    
    public boolean EliminarCuenta(Cuenta cuenta){
        boolean eliminado = false;
        
        try {
            Conexion();
            int i = sta.executeUpdate("delete from cuenta where cod_cta = "+cuenta.getCodigoCuenta()+";");
            
            if(i>0){
                eliminado = true;
                i = 0;
            }else {
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }
        
    public boolean ActualizarCuenta(Cuenta cuenta) {
        boolean actualizado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("UPDATE cuenta SET nombre_cta='"+cuenta.getNombreCuenta()+"',"
                + "tipo_cuenta_id_tipocta= "+cuenta.getoTipoCuenta().getIdTipocuenta()+" "
                + "WHERE cod_cta = "+cuenta.getCodigoCuenta()+";");
            
            if(i>0){
                actualizado = true;
                i=0;
            }else{
                JOptionPane.showMessageDialog(null, "Cuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return actualizado;
    }
    
    public String VerSumaSaldosInicialesDebe () {
        String totalSaldoDebe = "";
        
        try {
            Conexion();
            rs = sta.executeQuery("select sum(SaldoInicDEBE) from cuenta;");
            
            while(rs.next()) {
                totalSaldoDebe = rs.getObject(1).toString();
                break;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return totalSaldoDebe ;
    }
    
    public String VerSumaSaldosInicialesHaber () {
        String totalSaldoHaber = "";
        
        try {
            Conexion();
            rs = sta.executeQuery("select sum(SaldoInicDEBE) from cuenta;");
            
            while(rs.next()) {
                totalSaldoHaber = rs.getObject(1).toString();
                break;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return totalSaldoHaber ;
    }
    
    //Para el Tipo de Cuenta -------------------------------------------------------------------------------------
    
    public List<TipoCuenta> ListarTipoCuentas() throws Exception{
        List<TipoCuenta> tipocuentas = new ArrayList<>();
        
        Conexion();
        
        rs = sta.executeQuery("select * from tipo_cuenta order by id_tipocta;");
        
        while (rs.next()) {            
            TipoCuenta tipocta = new TipoCuenta();
            
            tipocta.setIdTipocuenta((Integer) rs.getObject(1));
            tipocta.setNombreTipocuenta((String) rs.getObject(2));
            
            tipocuentas.add(tipocta);
        }
        
        return tipocuentas;
    }
    
    
    //Para las Subcuentas -----------------------------------------------------------------------------------------
    
    public List<Subcuenta> ListarSubcuentas(String patron) throws Exception{
        List<Subcuenta> subcuentas = new ArrayList<>();
        
        Conexion();
        rs = sta.executeQuery("select * from subcuenta where cuenta_cod_cta like '"+patron+"%';");
        
        while(rs.next()){
            Subcuenta subcuenta = new Subcuenta();
            Cuenta cuenta = new Cuenta();
            
            subcuenta.setCodigoSubcuenta((Integer) rs.getObject(1));
            subcuenta.setNombreSubcuenta((String) rs.getObject(2));
            cuenta.setCodigoCuenta((Integer) rs.getObject(3));
            subcuenta.setoCuenta(cuenta);
            
            subcuentas.add(subcuenta);
        }
        return subcuentas;
    }
    
    public List<Subcuenta> ConsultarSubcuenta(int id) throws Exception{
        Conexion();
        List<Subcuenta> subcuentas = new ArrayList<>();
        
        rs = sta.executeQuery("select * from subcuenta where cod_subcta = "+id+";");
        
        while (rs.next()) {
            Subcuenta subcuenta = new Subcuenta();
            Cuenta cuenta = new Cuenta();
            subcuenta.setCodigoSubcuenta((Integer) rs.getObject(1));
            subcuenta.setNombreSubcuenta((String) rs.getObject(2));
            cuenta.setCodigoCuenta((Integer) rs.getObject(3));
            subcuenta.setoCuenta(cuenta);
            
            subcuentas.add(subcuenta);
            
        }
        return subcuentas;
    }
    
    public List<Subcuenta> ConsultarSubcuentaporNombre(String patron) throws Exception{
        Conexion();
        List<Subcuenta> subcuentas = new ArrayList<>();
        
        rs = sta.executeQuery("select * from subcuenta where nombre_subcta like '"+patron+"';");
        
        while (rs.next()) {
            Subcuenta subcuenta = new Subcuenta();
            Cuenta cuenta = new Cuenta();
            subcuenta.setCodigoSubcuenta((Integer) rs.getObject(1));
            subcuenta.setNombreSubcuenta((String) rs.getObject(2));
            cuenta.setCodigoCuenta((Integer) rs.getObject(3));
            subcuenta.setoCuenta(cuenta);
            
            subcuentas.add(subcuenta);
            
        }
        return subcuentas;
    }    
    
    public boolean IngresarSubcuenta(Subcuenta subcuenta){
        
        boolean ingresado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("insert into subcuenta(cod_subcta,nombre_subcta,cuenta_cod_cta )"
                + " values ("+subcuenta.getCodigoSubcuenta()+",'"+subcuenta.getNombreSubcuenta()+"',"
                + ""+subcuenta.getoCuenta().getCodigoCuenta()+");");
            
            if(i > 0){
                ingresado = true;
                i = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return ingresado;
    }
    
    public boolean ActualizarSubcuenta(Subcuenta subcuenta){
        boolean actualizado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("update subcuenta set nombre_subcta= '"+subcuenta.getNombreSubcuenta()+"',"
                + " cuenta_cod_cta = "+subcuenta.getoCuenta().getCodigoCuenta()+" "
                + "where cod_subcta = "+subcuenta.getCodigoSubcuenta()+";");
            
            if(i>0){
                actualizado = true;
                i = 0;
            }else{
                JOptionPane.showMessageDialog(null, "Subcuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return actualizado;
    }
    
    public boolean EliminarSubcuenta(Subcuenta subcuenta){
        boolean eliminado = false;
        
        try {
            Conexion();
            int i = sta.executeUpdate("delete from subcuenta "
                + "where cod_subcta = "+subcuenta.getCodigoSubcuenta()+";");
            
            if(i > 0){
                eliminado = true;
                i = 0; 
            } else{
                JOptionPane.showMessageDialog(null, "Subcuenta No Encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }
    
    
    //Para las Transacciones -----------------------------------------------------------------------------------------
    
    public List<Transaccion> ListarTransacciones(String patron) throws Exception {
        List<Transaccion> transacciones = new ArrayList<>();
        
        Conexion();
        rs = sta.executeQuery("select * from transaccion "
            + "where (fecha between (select InicioPeriodo from empresa ) and (select finPeriodo from empresa)) "
            + "and descripcion like '%"+patron+"%' order by fecha;");
        
        while (rs.next()) {  
            
            Transaccion transaccion = new Transaccion();
            
            transaccion.setIdTransaccion((Integer) rs.getObject(1));
            transaccion.setFecha((Date) rs.getObject(2));
            transaccion.setDescripcion((String) rs.getObject(3));
            
            transacciones.add(transaccion);
            
        }
        return transacciones;
    }
    
    public List<Transaccion> ConsultarTransaccion(String idtransaccion) throws Exception{
        Conexion();
        List<Transaccion> transacciones = new ArrayList<>();
        
        rs = sta.executeQuery("select * from transaccion where id_transaccion like '"+idtransaccion+"';");
        
        while(rs.next()) {
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion((Integer) rs.getObject(1));
            transaccion.setFecha((Date) rs.getObject(2));
            transaccion.setDescripcion((String) rs.getObject(3));
            
            transacciones.add(transaccion);
        }
        return transacciones;
    }
    
    public int SiguienteIdTransaccion() throws Exception {
        Conexion();
        int idtransaccionsgte = 0;
        rs = sta.executeQuery("select max(id_transaccion) from transaccion;");
        
        while(rs.next()) {
            idtransaccionsgte = rs.getInt(1) + 1;
        }
        return idtransaccionsgte;
    }
    
    public boolean IngresarTransaccion(Transaccion transaccion) {
        boolean ingresado = false;
        
        try {
            Conexion();
            Date date = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-d");
            
            int i = sta.executeUpdate("insert into transaccion (id_transaccion,fecha,descripcion) "
                + "values ("+transaccion.getIdTransaccion()+",'"+formato.format(transaccion.getFecha())+"',"
                + "'"+transaccion.getDescripcion()+"');");
            
            if(i>0) {
                ingresado = true;
                i = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return ingresado;
    }
    
    public boolean ActualizarTransaccion(Transaccion transaccion) {
        boolean actualizado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("update transaccion set descripcion = '"+transaccion.getDescripcion()+"' where id_transaccion = "+transaccion.getIdTransaccion()+";");
            
            if(i>0) {
                actualizado = true;
                i = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return actualizado;
    }
    
        public boolean EliminarTransaccion(int patron) {
        boolean eliminado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("delete from transaccion where id_transaccion = "+patron+";");
            
            if(i>0) {
                eliminado = true;
                i = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }

    
    //Para la Naturaleza de detalle de la transaccion --------------------------------------------------------------
    
    public List<Naturaleza> ListarNaturalezas() throws Exception {
        List<Naturaleza> naturalezas = new ArrayList<>();
        Conexion();
        
        rs = sta.executeQuery("select * from naturaleza;");
        
        while(rs.next()){
            Naturaleza naturaleza = new Naturaleza();
            
            naturaleza.setIdNaturaleza((String) rs.getObject(1));
            naturaleza.setNombreNaturaleza((String) rs.getObject(2));
            
            naturalezas.add(naturaleza);
        }
        return naturalezas;
    }
    
    //Para detalletransacción---------------------------------------------------------------------------------------
    
    public List<DetalleTransaccion> ListarDetalletransaccion(int patron) throws Exception{
        List<DetalleTransaccion> detalles = new ArrayList<>();
        Conexion();
        
        rs = sta.executeQuery("select * from detalle_transaccion where id_transaccion_pk like '"+patron+"';");
        
        while(rs.next()) {
            DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
            
            
            detalleTransaccion.setIdDetalle(rs.getInt(1));
            
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(rs.getInt(2));
            detalleTransaccion.setoTransaccion(transaccion);
            
            Naturaleza naturaleza = new Naturaleza();
            naturaleza.setIdNaturaleza(rs.getString(3));
            detalleTransaccion.setoNaturaleza(naturaleza);
            
            Cuenta cuenta = new Cuenta();
            cuenta.setCodigoCuenta(rs.getInt(4));
            detalleTransaccion.setoCuenta(cuenta);
            
            Subcuenta subcuenta = new Subcuenta();
            subcuenta.setCodigoSubcuenta(rs.getInt(5));
            detalleTransaccion.setoSubcuenta(subcuenta);
            
            detalleTransaccion.setMonto(rs.getInt(6));
            
            
            detalles.add(detalleTransaccion);
        }
        return detalles;
    }
    
    public List<DetalleTransaccion> ListarDetalletransaccionporId(int patron) throws Exception{
        List<DetalleTransaccion> detalles = new ArrayList<>();
        Conexion();
        
        rs = sta.executeQuery("select * from detalle_transaccion where id_detalle like '"+patron+"';");
        
        while(rs.next()) {
            DetalleTransaccion detalleTransaccion = new DetalleTransaccion();
            
            
            detalleTransaccion.setIdDetalle(rs.getInt(1));
            
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(rs.getInt(2));
            detalleTransaccion.setoTransaccion(transaccion);
            
            Naturaleza naturaleza = new Naturaleza();
            naturaleza.setIdNaturaleza(rs.getString(3));
            detalleTransaccion.setoNaturaleza(naturaleza);
            
            Cuenta cuenta = new Cuenta();
            cuenta.setCodigoCuenta(rs.getInt(4));
            detalleTransaccion.setoCuenta(cuenta);
            
            Subcuenta subcuenta = new Subcuenta();
            subcuenta.setCodigoSubcuenta(rs.getInt(5));
            detalleTransaccion.setoSubcuenta(subcuenta);
            
            detalleTransaccion.setMonto(rs.getInt(6));
            
            
            detalles.add(detalleTransaccion);
        }
        return detalles;
    }
    
    public String TotalDebeTransaccion(int patron) throws Exception {
        String numerodebe = "";
        Conexion();
        
        rs = sta.executeQuery("select sum(monto) from detalle_transaccion "
            + "where (naturaleza_cod_naturaleza like 'D')  and (id_transaccion_pk like '"+patron+"');");
        
        while (rs.next()) {            
            numerodebe = rs.getString(1);
            break;            
        }
        return numerodebe;
    }
    
    public String TotalHaberTransaccion(int patron) throws Exception {
        String numerohaber = "";
        Conexion();
        
        rs = sta.executeQuery("select sum(monto) from detalle_transaccion "
            + "where (naturaleza_cod_naturaleza like 'H')  and (id_transaccion_pk like '"+patron+"');");
        
        while (rs.next()) {
            numerohaber = rs.getString(1);
            break;
        }
        return numerohaber;
    }
    
    public boolean IngresarDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        boolean ingresado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("insert into detalle_transaccion "
                + "(id_transaccion_pk, naturaleza_cod_naturaleza, cuenta_cod_cuenta,subcuenta_cod_subcta, monto) "
                + "values ("+detalleTransaccion.getoTransaccion().getIdTransaccion()+",'"+detalleTransaccion.getoNaturaleza().getIdNaturaleza()+"',"
                + " "+detalleTransaccion.getoCuenta().getCodigoCuenta()+", "+detalleTransaccion.getoSubcuenta().getCodigoSubcuenta()+", "
                + "  "+detalleTransaccion.getMonto()+");");
            
            if(i > 0) {
                ingresado = true;
                i = 0;
                
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return ingresado;
    }
    
    public boolean ActualizarDetalleTransaccion(DetalleTransaccion detalleTransaccion) {
        boolean actualizado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("update detalle_transaccion set"
                + " cuenta_cod_cuenta = "+detalleTransaccion.getoCuenta().getCodigoCuenta()+" ,"
                + " subcuenta_cod_subcta = "+detalleTransaccion.getoSubcuenta().getCodigoSubcuenta()+" ,"
                + " naturaleza_cod_naturaleza = '"+detalleTransaccion.getoNaturaleza().getIdNaturaleza()+"' ,"
                + " monto = "+detalleTransaccion.getMonto()+" "
                + "where id_detalle = "+detalleTransaccion.getIdDetalle()+";");
            
            if(i > 0) {
                actualizado = true;
                i = 0;
                
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return actualizado;
    }
    
    public boolean EliminarDetalleTransaccion(int patron) {
        boolean eliminado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("delete from detalle_transaccion where id_detalle = "+patron+";");
            
            if(i > 0) {
                eliminado = true;
                i = 0;
                
            } else {
                JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }
    
    public boolean EliminarDetalleTransaccionporIdTransaccion(int patron) {
        boolean eliminado = false;
        
        try {
            Conexion();
            
            int i = sta.executeUpdate("delete from detalle_transaccion where id_transaccion_pk = 57");
            
            if(i > 0) {
                eliminado = true;
                i = 0;
                
            } else {
                JOptionPane.showMessageDialog(null, "No existen detalles en la Transacción ");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return eliminado;
    }
    
    // Para BalanzaComprobación ------------------------------------------------------------------------------------
    
    public List<Integer> ConsultarTotalesDebeHaber() throws Exception {
        Conexion();
        List<Integer> debehaber = new ArrayList<>();
        
        rs = sta.executeQuery("SELECT " +
                              " sum( if((SaldoInicDEBE + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'D' ) >= (SaldoInicHABER + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'H'))),abs((SaldoInicDEBE + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'D' )) - (SaldoInicHABER + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'H'))),0) ) as Debe, " +
                              " sum( if((SaldoInicDEBE + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'D' )) > (SaldoInicHABER + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'H')),0,abs((SaldoInicDEBE + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'D' )) - (SaldoInicHABER + (select fn_Nulo(sum(monto)) from detalle_transaccion where cuenta_cod_cuenta = cod_cta and naturaleza_cod_naturaleza = 'H')))) ) as Haber " +
                              " from cuenta;");
        
        while (rs.next()) {            
            int SumaDebe = rs.getInt(1);
            int SumaHaber = rs.getInt(2);
            debehaber.add(SumaDebe);
            debehaber.add(SumaHaber);
            break;
        }
        return debehaber;
    }
}
