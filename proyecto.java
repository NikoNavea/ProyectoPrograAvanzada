import java.io.*;
import java.util.*;

//Planificación de las actividades del área de Extensión de una Universidad

public class proyecto{
    public static void main(String[] args) throws IOException{
        
        System.out.println("Bienvenidx al sistema de planificacixn de actividades de Extensión de la Universidad Católica de Valparaiso ");
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );

        ColeccionActividades coleccion = new ColeccionActividades();
        Menu menu = new Menu();
        boolean salir = true;
        while(salir){
            menu.mostrarMenu();
            int opcion = Integer.parseInt(lector.readLine());
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre de la actividad que desea realizar y el encargado: ");
                    String nuevaActividad = lector.readLine();
                    String encargado = lector.readLine();
                    coleccion.agregarActividad(nuevaActividad, encargado);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la actividad que desea eliminar: ");
                    String actividadEliminar = lector.readLine();
                    coleccion.eliminarActividad(actividadEliminar);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la actividad a la que desea inscribir al alumno: ");
                    String nombreAct = lector.readLine();

                    if(coleccion.verifActividad(nombreAct) == false){
                        System.out.println("La actividad no existe");
                        break; 
                    }

                    System.out.println("Ingrese el nombre, apellido y rut del alumno: ");
                    String nombre = lector.readLine();
                    String apellido = lector.readLine();
                    String rut = lector.readLine();
                
                    Actividad actividad = coleccion.getMapaActividades().get(nombreAct);
                    actividad.agregarAlumno(nombre, apellido, rut, nombreAct);
                    System.out.println("El alumno ha sido inscrito en la actividad");
                    break;
                 
                case 6:
                    coleccion.mostrarActividades();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema de planificación de actividades de Extensión de la Universidad Católica de Valparaiso");
                    salir = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
                    
            }    
        }
    }
}

/*Mostrar planificación
 * Agregar actividad a la planificacion
 * Eliminar ""
 * Mostrar actividades
 * Mostrar alumnos actividad
 * Encargados actividad
 * 
 */