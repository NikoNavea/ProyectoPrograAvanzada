public class Alumnos {
    private String nombre;
    private String apellido;
    private String rut; 

    public Alumnos(){
        nombre = null;
        apellido = null;
        rut = null;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getRut(){
        return rut;
    }
}
