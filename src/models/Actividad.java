package models;

import java.util.*;
import javax.swing.*;
/**
 * Clase que crea las actividades del sistema
 * @see Encargado
 * @see Alumnos
 */
public class Actividad {
    private Encargado encargado;
    private String nombreAct;
    private ArrayList <Alumnos> listaAlumnos;
    private String claveHoraria;
    private String dia;
    /**
     * Constructor de la clase Actividad
     * @param nombreAct Nombre de la actividad
     * @param dia Día en que se realiza la actividad
     * @param claveHoraria Clave horaria de la actividad
     * @param encargado Encargado de la actividad
     */
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

    /**
     * Verifica si un alumno ya está inscrito en una actividad
     * @param actividad Actividad en donde se busca el alumno
     * @param rut Rut del alumno a buscar
     * @return True si no está inscrito, False si ya está inscrito
     */ 
    public boolean verifAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                JOptionPane.showMessageDialog(null, "El alumno ya está inscrito en la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }


    /**
     * Agrega un alumno a la lista de alumnos de una actividad
     * @param alumno Alumno a agregar
     * @param actividad Actividad en donde se agrega el alumno
     * @return True si se agrega el alumno, False si ya está inscrito en la actividad o si ya está inscrito en otra actividad
     */
    public boolean agregarAlumno(Alumnos alumno, Actividad actividad){ 
        if(!actividad.verifAlumno(actividad, alumno.getRut())){
            return false;
        }

        if(alumno.getActividad() != null){
            JOptionPane.showMessageDialog(null, "El alumno ya está inscrito en otra actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        alumno.setActividad(actividad.getNombreAct());
        actividad.listaAlumnos.add(alumno);
        return true;
    }


    /**
     * Busca un alumno en la lista de alumnos de una actividad
     * @param actividad Actividad en donde se busca el alumno
     * @param rut Rut del alumno a buscar
     * @return Objeto Tipo Alumno si se encuentra, null si no se encuentra
     */
    public Alumnos buscarAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }

    /**
     * Busca un alumno en la lista de alumnos de una actividad
     * @param actividad Actividad en donde se busca el alumno
     * @param nombre Nombre del alumno a buscar
     * @param apellido Apellido del alumno a buscar
     * @return Objeto Tipo Alumno si se encuentra, null si no se encuentra
     */
    public Alumnos buscarAlumno(Actividad actividad, String nombre, String apellido){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getNombre().equals(nombre) && actividad.listaAlumnos.get(i).getApellido().equals(apellido)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }

    /**
     * Retorna la cantidad de actividades que tiene un encargado
     * @param actividad Actividad en donde se recorre la lista de alumnos
     * @param i Posición de la lista de alumnos
     * @return Alumno en la posición i de la lista de alumnos
     */
    public Alumnos recorrerListaAlumnos(Actividad actividad, int i){
        if(actividad == null || actividad.listaAlumnos.isEmpty()){
            return null;
        }
        return actividad.listaAlumnos.get(i);
    }

    /**
     * Retorna la cantidad de alumnos inscritos en una actividad
     * @param actividad Actividad en donde se pide la cantidad de alumnos
     * @return Cantidad de alumnos inscritos en una actividad
     */
    public int cantidadAlumnos(Actividad actividad){
        if(actividad == null || actividad.listaAlumnos.isEmpty()){
            return 0;
        }
        return actividad.listaAlumnos.size();
    }

    /**
     * Elimina el alumno si se encuentra dentro de la actividad
     * @param actividad Actividad en donde se busca el alumno
     * @param rut Rut del alumno a eliminar
     * @return True si se elimina el alumno, False si no se encuentra en la actividad
     */
    public boolean eliminarAlumno(Actividad actividad, String rut){
        if(buscarAlumno(actividad, rut) == null){
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito en esta la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        actividad.listaAlumnos.remove(buscarAlumno(actividad, rut));
        JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la actividad con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
        
    }

    /**
     * Elimina el alumno si se encuentra dentro de la actividad
     * @param actividad Actividad en donde se busca el alumno
     * @param nombre Nombre del alumno a eliminar
     * @param apellido Apellido del alumno a eliminar
     * @return True si se elimina el alumno, False si no se encuentra en la actividad
     */
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

    /**
     * Retorna una lista con los alumnos que pertenecen a una carrera
     * @param carrera Carrera de los alumnos a filtrar
     * @return Lista con los alumnos que pertenecen a una carrera
     */
    public ArrayList<Alumnos> filtrarAlumnosCarrera(String carrera) {
        ArrayList<Alumnos> lista = new ArrayList<>();
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (listaAlumnos.get(i).getCarrera().equals(carrera)) {
                lista.add(listaAlumnos.get(i));
            }
        }
        return lista;
    }
    /**
     * Elimina un alumno de la lista maestra de alumnos
     * @param rut Rut del alumno a eliminar
     * @return True si se elimina el alumno, False si no se encuentra en la lista maestra
     */
    public boolean eliminarAlumnoListaMaestraAct(String rut){
        for(int i = 0 ; i < listaAlumnos.size() ; i++){
            if(listaAlumnos.get(i).getRut().equals(rut)){
                listaAlumnos.remove(i);
                return true;
            }
        }
        return false;
    }
}
