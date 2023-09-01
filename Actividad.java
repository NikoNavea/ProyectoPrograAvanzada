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


    public void agregarAlumno(Alumnos alumno, Actividad actividad){ 
        if(actividad.verifAlumno(actividad, alumno.getRut()) == false){
            System.out.println("El alumno ya esta inscrito en la actividad");
            return;
        }

        actividad.listaAlumnos.add(alumno);
    }

    public Alumnos buscarAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }

    public Alumnos buscarAlumno(Actividad actividad, String nombre, String apellido){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getNombre().equals(nombre) && actividad.listaAlumnos.get(i).getApellido().equals(apellido)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }


    public void eliminarAlumno(Actividad actividad, String rut){
        if(buscarAlumno(actividad, rut) == null){
            System.out.println("El alumno no esta inscrito en la actividad");
            return;
        }else{
            actividad.listaAlumnos.remove(buscarAlumno(actividad, rut));
            System.out.println("El alumno ha sido eliminado de la actividad");
        }
    }

    public void eliminarAlumno(Actividad actividad, String nombre, String apellido){
        if(buscarAlumno(actividad, nombre, apellido) == null){
            System.out.println("El alumno no esta inscrito en la actividad");
            return;
        }else{
            actividad.listaAlumnos.remove(buscarAlumno(actividad, nombre, apellido));
            System.out.println("El alumno ha sido eliminado de la actividad");
        }
    }

    public ArrayList<Alumnos> getListaAlumnos(){
        return listaAlumnos;
    }
}
