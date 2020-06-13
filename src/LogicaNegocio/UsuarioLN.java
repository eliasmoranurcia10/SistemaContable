
package LogicaNegocio;

import Datos.Conexion;
import Entidades.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioLN {
    
    public Usuario validarUsuario(String user,String password) throws Exception{
        
        Conexion conn = new Conexion();
        Usuario usuario = new Usuario();
        
            if( !user.equals("")){
                
                if(!password.equals("")){
                    
                    usuario.setUser(user);
                    usuario.setPassword(password);
                    
                    
                    List<Usuario> acceso = conn.AccesoUsuario(usuario);
                    
                    for(Usuario usu: acceso){
                        
                        if(usu.getUser().equals(user)){
                            if(usu.getPassword().equals(password)){
                                usuario.setId(usu.getId());
                                usuario.setNombre(usu.getNombre());
                                usuario.setApellidos(usu.getApellidos());
                                usuario.setTipousuario(usu.getTipousuario());
                                break;
                            }
                        }
                    }
                }else  {
                    JOptionPane.showMessageDialog(null, "Introduzca Contraseña ", "Error", JOptionPane.WARNING_MESSAGE);
               }
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca Usuario", "Error", JOptionPane.WARNING_MESSAGE);
            }
        return usuario;
    }

    public List<Usuario> ConsultarUsuarios(String patron) throws Exception {
        Conexion conn;
        
        try {
            conn = new Conexion();
            List<Usuario> usuarios = conn.ListarUsuarios(patron);
            return usuarios;
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean RegistrarUsuario(Usuario usuario) throws Exception{
        boolean registrado = false;
        
        try {
            Conexion conn = new Conexion();
            if(conn.IngresarUsuario(usuario)){
                registrado = true;
                JOptionPane.showMessageDialog(null, "Usuario Ingresado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No registrado ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return registrado;
    }
    
    public Usuario ConsultarUsuarioporId(int id) throws Exception{
        
        Usuario usuario = new Usuario();
        try {
            Conexion conn = new Conexion();
            
            
            List<Usuario> acceso = conn.ConsultarUsuario(id);
            
            for(Usuario usu: acceso){
                        
                if(usu.getId() == id){

                    usuario.setId(usu.getId());
                    usuario.setNombre(usu.getNombre());
                    usuario.setApellidos(usu.getApellidos());
                    usuario.setTipousuario(usu.getTipousuario());
                    usuario.setUser(usu.getUser());
                    usuario.setPassword(usu.getPassword());
                    break;
                }
            }
  
        } catch (Exception e) {
            throw e;
        }
        
        return usuario;
    }
    
    public boolean ModificarUsuario(Usuario usuario) throws Exception {
        boolean modificado = false;
        
        try {
            Conexion conn = new Conexion();
            if(conn.ActualizarUsuario(usuario)){
                modificado = true;
                JOptionPane.showMessageDialog(null, "Usuario Modificado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexion : "+e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return modificado;
    }
    
    public boolean BorrarUsuario(Usuario usuario) throws Exception{
        boolean borrado = false;
        
        try {
            Conexion conn = new Conexion();
            if(conn.EliminarUsuario(usuario)){
                borrado = true;
                JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return borrado;
    }
}
