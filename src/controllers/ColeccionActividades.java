package controllers;
import models.*;
import views.*;


import java.util.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase que crea la colección de actividades del sistema
 * @see Actividad
 * @see Encargado
 * @see Alumnos
 */
public class ColeccionActividades {
    private HashMap <String, Actividad> mapaActividades;
    private ArrayList <Actividad> listaActividad;
    private ArrayList <Alumnos> listaMaestra;
    private ArrayList <Encargado> listaEncargados;
    
    /**
     * Constructor de la clase ColeccionActividades
     */
    public ColeccionActividades(){
        mapaActividades = new HashMap<>();
        listaActividad = new ArrayList<>();
        listaMaestra = new ArrayList<>();
        listaEncargados = new ArrayList<>();
    }
    /**
     * Agrega una actividad a la colección de actividades
     * @param actividad Actividad a agregar
     * @param encargado Encargado de la actividad
     */
    public void agregarActividad(Actividad actividad, Encargado encargado){
        if(mapaActividades.get(actividad.getNombreAct()) == null){
            mapaActividades.put(actividad.getNombreAct(), actividad);
            listaActividad.add(actividad);
            listaEncargados.add(encargado);
            JOptionPane.showMessageDialog(null, "La actividad se ha agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "La actividad ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Elimina un Alumno de la lista maestra de alumnos
     * @param actividad Actividad de la cual se eliminará el alumno
     */
    public void eliminarAlumnosActividadListaMaestra(Actividad actividad){
        for(int i = 0 ; i < listaMaestra.size() ; i++){
            if(actividad.eliminarAlumnoListaMaestraAct(listaMaestra.get(i).getRut())){
                listaMaestra.remove(i);
            }
        }
    }
    /**
     * Elimina una actividad de la colección de actividades
     * @param actividadEliminar Nombre de la actividad a eliminar
     */
    public void eliminarActividad(String actividadEliminar){
        
        Actividad actividadAEliminar = mapaActividades.get(actividadEliminar);
        Encargado encargadoAEliminar = actividadAEliminar.getEncargado();
        if(mapaActividades.get(actividadEliminar) != null){
            eliminarAlumnosActividadListaMaestra(actividadAEliminar);
            mapaActividades.remove(actividadEliminar);
            listaActividad.remove(actividadAEliminar);
            listaEncargados.remove(encargadoAEliminar);
            JOptionPane.showMessageDialog(null, "La actividad se ha eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Mostar los detalles de una actividad
     * @param nombreActividad Nombre de la actividad a mostrar
     */
    public void mostrarActividades(String nombreActividad) {
        // Crear una nueva ventana de diálogo
        if(!verifActividad(nombreActividad)){
            return;
        }
        
        Actividad actividad = mapaActividades.get(nombreActividad);
        ActividadVista vistaActividad = new ActividadVista(actividad);
        vistaActividad.mostrarDetallesActividad();
    }
    /**
     * Retorna la cantidad de actividades guardadas
     * @return Cantidad de actividades guardadas
     */
    public int cantidadActividades(){
        if (listaActividad == null || listaActividad.isEmpty()) {
            return 0;
        }
        return listaActividad.size();
    }
    /**
     * Retorna la actividad en la posición i de la lista de actividades
     * @param i Posición de la lista de actividades
     * @return Actividad en la posición i de la lista de actividades
     */
    public Actividad recorrerActividades(int i){
        if (listaActividad == null || listaActividad.isEmpty()) {
            return null;
        }
        return listaActividad.get(i);
    }
    /**
     * Muestra las actividades guardadas
     */
    public void mostrarActividades(){
        ColeccionActividadesVista vista = new ColeccionActividadesVista(this);
        vista.mostrarActividades();
    }
    /**
     * Verifica si una actividad existe
     * @param nombreActividad Nombre de la actividad a verificar
     * @return True si la actividad existe, False si no existe
     */
    public boolean verifActividad(String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Agrega un alumno a la lista maestra de alumnos
     * @param alumno Alumno a agregar a la lista maestra
     */
    public void agregarAlumnoListaMaestra(Alumnos alumno){
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getRut().equals(alumno.getRut())){
                JOptionPane.showMessageDialog(null, "El alumno ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        listaMaestra.add(alumno);
    }
    /**
     * Elimina un alumno de la lista maestra de alumnos
     * @param rutAlumno Rut del alumno a eliminar
     */
    public void eliminarAlumnoListaMaestra(String rutAlumno){
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getRut().equals(rutAlumno)){
                listaMaestra.remove(i);
                return;
            }
        }
    }
    /**
     * Elimina un alumno de la lista maestra de alumnos
     * @param nombreAlumno Nombre del alumno a eliminar
     * @param apellidoAlumno Apellido del alumno a eliminar
     */
    public void eliminarAlumnoListaMaestra(String nombreAlumno, String apellidoAlumno){
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getNombre().equals(nombreAlumno) && listaMaestra.get(i).getApellido().equals(apellidoAlumno)){
                listaMaestra.remove(i);
                JOptionPane.showMessageDialog(null, "El alumno se ha eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Retorna la cantidad de alumnos de una actividad
     * @return Cantidad de alumnos de una actividad
     */
    public int cantidadAlumnosTotal(){
        if (listaMaestra == null || listaMaestra.isEmpty()) {
            return 0;
        }
        return listaMaestra.size();
    }
    /**
     * Retorna el alumno en la posición i de la lista maestra de alumnos
     * @param i Posición de la lista maestra de alumnos
     * @return Alumno en la posición i de la lista maestra de alumnos
     */
    public Alumnos recorrerAlumnosTotal(int i){
        if (listaMaestra == null || listaMaestra.isEmpty()) {
            return null;
        }
        return listaMaestra.get(i);
    }
    /**
     * Muestra a todos los alumnos del sistema
     */
    public void mostrarAlumnosListaMaestra() {
        ColeccionActividadesVista vista = new ColeccionActividadesVista(this);
        vista.mostrarAlumnosListaMaestra();
    }
    /**
     * Cambia el encargado de una actividad
     * @param nuevoEncargado Nuevo encargado de la actividad
     * @param nombreActividad Nombre de la actividad a cambiar el encargado
     */
    public void cambiarEncargado(Encargado nuevoEncargado, String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Actividad actividad = mapaActividades.get(nombreActividad);
        actividad.setEncargado(nuevoEncargado);
        JOptionPane.showMessageDialog(null, "Encargado cambiado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }    
    /**
     * 
     * @return
     */
    public HashMap<String, Actividad> getMapaActividades() {
        return mapaActividades;
    }
    /**
     * Verifica si una clave horaria se superpone con otra
     * @param dia Día de la actividad
     * @param claveHoraria Clave horaria de la actividad
     * @return True si se superpone, False si no se superpone
     */
    public boolean verifClaveHoraria(String dia, String claveHoraria){
        for(int i = 0 ; i < listaActividad.size() ; i++){
            if(seSuperponeCon(dia,claveHoraria, listaActividad.get(i))){
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica si una clave horaria se superpone con otra
     * @param dia Día de la actividad
     * @param claveHoraria Clave horaria de la actividad
     * @param actividad Actividad a verificar
     * @return True si se superpone, False si no se superpone
     */
    public boolean seSuperponeCon(String dia, String claveHoraria, Actividad actividad) {
        if (!actividad.getDia().equals(dia)) {
            return false; 
        }

        if(actividad.getClaveHoraria().equals(claveHoraria)){
            return true;
        }

        return false;
    }
    /**
     * Muestra la información de un alumno
     * @param rut Rut del alumno a mostrar
     */
    public void mostrarInfoAlumno(String rut){
        if(rut == null){
            return;
        }
        for(int i = 0; i < listaMaestra.size(); i++){
            Alumnos alumno = listaMaestra.get(i);
            AlumnoVista vista = new AlumnoVista(alumno);
            if(alumno.getRut().equals(rut)){
                vista.mostrarInfo();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Muestra la información de un encargado
     * @param rut Rut del encargado a mostrar
     */
    public void mostrarInfoEncargado(String rut){
        if(rut == null){
            return;
        }
        for(int i = 0; i < listaActividad.size(); i++){
            if(listaActividad.get(i).getEncargado().getRut().equals(rut)){
                Encargado encargado = listaActividad.get(i).getEncargado();
                EncargadoVista vista = new EncargadoVista(encargado);
                vista.mostrarInfo();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El encargado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Busca un encargado por su rut
     * @param rut Rut del encargado a buscar
     * @return Encargado buscado
     */
    public Encargado buscarEncargadoPorRut(String rut){
        if(rut == null){
            return null;
        }

        for(int i = 0; i < listaEncargados.size(); i++){
            if(listaEncargados.get(i).getRut().equals(rut)){
                return listaEncargados.get(i);
            }
        }
        return null;
    }
    /**
     * Busca una actividad por su nombre
     * @param nombreAct Nombre de la actividad a buscar
     * @return Actividad buscada o null si no existe
     */
    public Actividad buscarActividad(String nombreAct){

        Actividad actividad = mapaActividades.get(nombreAct);

        if(actividad != null){
            return actividad;
        }

        JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    /**
     * Busca un alumno por su rut en la lista maestra de alumnos
     * @param rut Rut del alumno a buscar
     * @return Alumno buscado o null si no existe
     */
    public Alumnos buscarAlumnoListaMaestra(String rut){
        for(int i = 0 ; i < listaMaestra.size() ; i++){
            Alumnos alumno = listaMaestra.get(i);
            if(alumno.getRut().equals(rut)){
                return alumno;
            }
        }
        return null;
    }
    /**
     * Cambia la carrera de un alumno
     * @param rutCambiar Rut del alumno
     * @param carrera Carrera en cual se cambiará el alumno
     */
    public void cambiarCarreraAlumno(String rutCambiar, String carrera){
        Alumnos alumno = buscarAlumnoListaMaestra(rutCambiar);

        if(alumno == null){
            JOptionPane.showMessageDialog(null, "El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;     
        }
        
        for(int i = 0 ; i < listaMaestra.size() ; i++){
            if(alumno.getCarrera().equals(listaMaestra.get(i).getCarrera())){
                alumno.setCarrera(carrera);
                JOptionPane.showMessageDialog(null, "Carrera cambiada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }
    /**
     * Carga los datos de los archivos csv
     */
    public void cargarDatos() {
        String line;
        
        try (BufferedReader readerEncargados = new BufferedReader(new FileReader("encargados.csv"))) {
            while ((line = readerEncargados.readLine()) != null) {
                String[] data = line.split(",");
                
                Encargado encargado = new Encargado(data[0], data[1], data[2], data[3], data[4], data[5]);
                listaEncargados.add(encargado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader readerActividades = new BufferedReader(new FileReader("actividades.csv"))) {
            while ((line = readerActividades.readLine()) != null) {
                String[] data = line.split(",");
                
                Encargado encargado = buscarEncargadoPorRut(data[1]);
                
                Actividad actividad = new Actividad(data[0], data[2], data[3], encargado);
                listaActividad.add(actividad);
                mapaActividades.put(actividad.getNombreAct(), actividad);

                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader readerAlumnos = new BufferedReader(new FileReader("alumnos.csv"))) {
            while ((line = readerAlumnos.readLine()) != null) {
                String[] data = line.split(",");
                Alumnos alumno = new Alumnos(data[0], data[1], data[2], data[3], data[4]);
                Actividad aux = buscarActividad(data[5]);
                
                if(aux != null){
                    aux.agregarAlumno(alumno, aux);
                }
                
                listaMaestra.add(alumno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda los datos en los archivos csv
     */
    public void guardarDatos() {
        // Guardar actividades
        try (BufferedWriter writerActividades = new BufferedWriter(new FileWriter("actividades.csv"))) {
            for (Actividad actividad : listaActividad) {
                if (actividad != null && actividad.getNombreAct() != null && actividad.getEncargado() != null) {
                    writerActividades.write(actividad.getNombreAct() + "," +
                                            actividad.getEncargado().getRut() + "," +
                                            actividad.getDia() + "," +
                                            actividad.getClaveHoraria() + "\n");
                } else {
                    System.out.println("Actividad inválida o con datos incompletos. No se guardó: " + actividad);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Guardar alumnos
        try (BufferedWriter writerAlumnos = new BufferedWriter(new FileWriter("alumnos.csv"))) {
            for (Alumnos alumno : listaMaestra) {
                if (alumno != null && alumno.getNombre() != null && alumno.getApellido() != null && alumno.getRut() != null) {
                    writerAlumnos.write(alumno.getNombre() + "," +
                                        alumno.getApellido() + "," +
                                        alumno.getRut() + "," +
                                        alumno.getCarrera() + "," +
                                        alumno.getAnioIngreso() +  "," +
                                        alumno.getActividad() + "\n");
                } else {
                    System.out.println("Alumno inválido o con datos incompletos. No se guardó: " + alumno);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Guardar encargados
        try (BufferedWriter writerEncargados = new BufferedWriter(new FileWriter("encargados.csv"))) {
            for (Encargado encargado : listaEncargados) {
                if (encargado != null && encargado.getNombre() != null && encargado.getApellido() != null && encargado.getRut() != null) {
                    writerEncargados.write(encargado.getNombre() + "," +
                                        encargado.getApellido() + "," +
                                        encargado.getRut() + "," +
                                        encargado.getCargo() + "," +
                                        encargado.getTelefono() + "," +
                                        encargado.getCorreo() + "\n");
                } else {
                    System.out.println("Encargado inválido o con datos incompletos. No se guardó: " + encargado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Genera un reporte txt de todas las actividades, encargados y alumnos del sistema
     */
    public void generarReporte() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reporte.txt"))) {
            writer.write("=========================================\n");
            writer.write("                REPORTE\n");
            writer.write("=========================================\n\n");
            writer.write("ACTIVIDADES:\n");
    
            int actividadCount = 1;
            for (Actividad actividad : listaActividad) {
                writer.write("------------\n");
                writer.write("  - Actividad " + actividadCount + ": " + actividad.getNombreAct() + "\n");
                writer.write("  - Encargado: " + actividad.getEncargado().getNombre() + " " + actividad.getEncargado().getApellido() + "\n");
                writer.write("  - Clave Horaria: " + actividad.getClaveHoraria() + "\n");
                writer.write("  - Día: " + actividad.getDia() + "\n");
                writer.write("  - Lista de Alumnos " + "\n");
                actividadCount++;
            }
            
            writer.write("\nDETALLES DE ENCARGADOS:\n");
            int encargadoCount = 1;
            for (Encargado encargado : listaEncargados) {
                writer.write("-----------------------\n");
                writer.write("  - Encargado " + encargadoCount + ":\n");
                writer.write("    - Nombre: " + encargado.getNombre() + "\n");
                writer.write("    - Apellido: " + encargado.getApellido() + "\n");
                writer.write("    - RUT: " + encargado.getRut() + "\n");
                writer.write("    - Cargo: " + encargado.getCargo() + "\n");
                writer.write("    - Correo: " + encargado.getCorreo() + "\n");
                writer.write("    - Teléfono: " + encargado.getTelefono() + "\n\n");
                encargadoCount++;
            }
            
            writer.write("\nLISTA DE TODOS LOS ALUMNOS:\n");
            writer.write("---------------------------------------\n");
            int alumnoCount = 1;
            for (Alumnos alumno : listaMaestra) {
                writer.write("Alumno " + alumnoCount + ":\n");
                writer.write("  - Nombre: " + alumno.getNombre() + "\n");
                writer.write("  - Apellido: " + alumno.getApellido() + "\n");
                writer.write("  - RUT: " + alumno.getRut() + "\n");
                writer.write("  - Carrera: " + alumno.getCarrera() + "\n");
                writer.write("  - Actividad: " + alumno.getActividad() + "\n");
                writer.write("  - Año de Ingreso: " + alumno.getAnioIngreso() + "\n\n");
                alumnoCount++;
            }
    
            writer.write("=========================================\n");
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
