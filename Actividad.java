import java.util.*;

import javax.swing.JOptionPane;

public class Actividad {
    private Encargado encargado;
    private String nombreAct;
    private ArrayList <Alumnos> listaAlumnos;
    private String claveHoraria;
    private String dia;
    
    public Actividad(String nombreAct, String dia, String claveHoraria, Encargado encargado){
        this.encargado = encargado;
        this.nombreAct = nombreAct;
        this.dia = dia;
        this.claveHoraria = claveHoraria;
        this.listaAlumnos = new ArrayList<>();
    }

    public String getNombreAct(){ 
        return nombreAct;
    }

    public String setNombreAct(String nombreAct){
        this.nombreAct = nombreAct;
        return nombreAct;
    }
    
    public String getDia(){
        return dia;
    }

    public String setDia(String dia){
        this.dia = dia;
        return dia;
    }

    public String getClaveHoraria(){
        return claveHoraria;
    }

    public String setClaveHoraria(String claveHoraria){
        this.claveHoraria = claveHoraria;
        return claveHoraria;
    }

    public Encargado getEncargado(){
        return encargado;
    }

    public void setEncargado(Encargado encargado){
        this.encargado = encargado;
    }

    public boolean verifAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                JOptionPane.showMessageDialog(null, "El alumno ya está inscrito en la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }


    public boolean agregarAlumno(Alumnos alumno, Actividad actividad){ 
        if(actividad.verifAlumno(actividad, alumno.getRut()) == false){
            return false;
        }

        actividad.listaAlumnos.add(alumno);
        return true;
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


    public boolean eliminarAlumno(Actividad actividad, String rut){
        if(buscarAlumno(actividad, rut) == null){
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito en esta la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        actividad.listaAlumnos.remove(buscarAlumno(actividad, rut));
        JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la actividad con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
        
    }

    public boolean eliminarAlumno(Actividad actividad, String nombre, String apellido){
        if(buscarAlumno(actividad, nombre, apellido) == null){
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito en esta la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            actividad.listaAlumnos.remove(buscarAlumno(actividad, nombre, apellido));
            JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la actividad con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
}