import java.util.*;

public class Actividad {
    private String encargado;
    private String nombreAct;
    private ArrayList <Alumnos> listaAlumnos;
    
    public Actividad(String nombreAct, String encargado){
        this.encargado = encargado;
        this.nombreAct = nombreAct;
        this.listaAlumnos = new ArrayList<>();
    }

    public String getNombreAct(){ 
        return nombreAct;
    }

    public String setNombreAct(String nombreAct){
        this.nombreAct = nombreAct;
        return nombreAct;
    }
    
    public String getEncargado(){
        return encargado;
    }
    
    public String setEncargado(String encargado){
        this.encargado = encargado;
        return encargado;
    }

    public boolean verifAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                System.out.println("El alumno ya esta inscrito en la actividad");
                return false;
            }
        }
        return true;
    }


    public void agregarAlumno(String nombre, String apellido, String rut, String nombreAct){
        ColeccionActividades coleccion = new ColeccionActividades();

        HashMap<String, Actividad> mapaActividades = coleccion.getMapaActividades();
        Actividad actividad = mapaActividades.get(nombreAct);

        if(actividad.verifAlumno(actividad, rut) == false){
            System.out.println("El alumno ya esta inscrito en l--a actividad");
            return;
        }

        Alumnos nuevoAlumno = new Alumnos();
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellido(apellido);
        nuevoAlumno.setRut(rut);
        listaAlumnos.add(nuevoAlumno);
    }
}
