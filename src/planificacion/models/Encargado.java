package planificacion.models;
/**
 * Clase que crea los encargados del sistema
 * @see Persona
 */
public class Encargado extends Persona{
    private String cargo;
    private String telefono;
    private String correo;
    /**
     * Constructor de la clase Encargado
     * @param nombre Nombre del encargado
     * @param apellido Apellido del encargado
     * @param rut Rut del encargado
     * @param cargo Cargo del encargado
     * @param telefono Teléfono del encargado
     * @param correo Correo del encargado
     */
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
