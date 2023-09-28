
public class Alumnos extends Persona{
    private String carrera;
    private String anioIngreso;
    
    public Alumnos(String nombre, String apellido, String rut, String carrera, String anioIngreso){
        super(nombre, apellido, rut);
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
    }

    public String getCarrera(){
        return carrera;
    }

    public String setCarrera(String carrera){
        this.carrera = carrera;
        return carrera;
    }

    public String getAnioIngreso(){
        return anioIngreso;
    }

    public String setAnioIngreso(String anioIngreso){
        this.anioIngreso = anioIngreso;
        return anioIngreso;
    }
    
}
