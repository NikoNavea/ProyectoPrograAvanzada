
public class Encargado extends Persona{
    private String cargo;
    private String telefono;
    private String correo;
    
    public Encargado(String nombre, String apellido, String rut, String cargo, String telefono, String correo) {
        super(nombre, apellido, rut);
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo; 
    }

    public String getCargo(){
        return cargo;
    }

    public String setCargo(String cargo){
        this.cargo = cargo;
        return cargo;
    }

    public String getTelefono(){
        return telefono;
    }

    public String setTelefono(String telefono){
        this.telefono = telefono;
        return telefono;
    }

    public String getCorreo(){
        return correo;
    }

    public String setCorreo(String correo){
        this.correo = correo;
        return correo;
    }


}

