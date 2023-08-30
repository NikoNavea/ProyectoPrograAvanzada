import java.io.*;
import java.util.*;

//Planificación de las actividades del área de Extensión de una Universidad

public class proyecto{
    public static void main(String[] args) throws IOException{
        
        System.out.println("Bienvenidx al sistema de planificacixn de actividades de Extensión de la Universidad Católica de Valparaiso ");
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );

        ColeccionActividades coleccion = new ColeccionActividades();

        boolean salir = true;
        while(salir){
            System.out.println("Ingrese la opción que desea realizar: ");
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