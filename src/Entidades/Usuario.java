package Entidades;

public class Usuario {
    
    private int Id;
    private String Nombre;
    private String Apellidos;
    private String Tipousuario;
    private String User;
    private String Password;

    public Usuario() {
    }

    public Usuario(int Id) {
        this.Id = Id;
    }

    public Usuario(int Id, String Nombre, String Apellidos, String Tipousuario, String User, String Password) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Tipousuario = Tipousuario;
        this.User = User;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTipousuario() {
        return Tipousuario;
    }

    public void setTipousuario(String Tipousuario) {
        this.Tipousuario = Tipousuario;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "" +this.Nombre+ " " +this.Apellidos + " "; 
    }
    
}
