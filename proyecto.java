import java.io.*;
import java.util.*;

//Planificación de las actividades del área de Extensión de una Universidad

public class proyecto{
    public static void main(String[] args) throws IOException{
        
        System.out.println("Bienvenidx al sistema de planificacixn de actividades de Extensión de la Universidad Católica de Valparaiso ");
        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );

        ColeccionActividades coleccion = new ColeccionActividades();
        coleccion.inicializarActs();

        Menu menu = new Menu();
        boolean salir = true;
        
        while(salir){
            
            menu.mostrarMenu();
            int opcion = Integer.parseInt(lector.readLine());
            
            switch(opcion){
                case 1:

                    System.out.println("");
                    menu.mostrarMenuActividades();
                    int opcionAct = Integer.parseInt(lector.readLine());
                    
                    switch(opcionAct){
                        case 1:

                            System.out.println("Ingrese el nombre de la actividad que desea realizar: ");
                            String nuevaActividad = lector.readLine();
                            System.out.println("Ingrese el nombre del encargado: ");
                            String encargado = lector.readLine();
                            
                            coleccion.agregarActividad(new Actividad(nuevaActividad, encargado));
                            break;
                        case 2:

                            System.out.println("Ingrese el nombre de la actividad que desea eliminar: ");
                            String actividadEliminar = lector.readLine();
                            coleccion.eliminarActividad(actividadEliminar);
                            break;
                        case 3:

                            coleccion.mostrarActividades();
                            break;
                        case 4:

                            System.out.println("Ingrese el nombre de la actividad a la que desea cambiar el encargado: ");
                            String actividadEncargado = lector.readLine();
                            System.out.println("Ingrese el nuevo encargado: ");
                            String nuevoEncargado = lector.readLine();
                            coleccion.cambiarEncargado(actividadEncargado, nuevoEncargado);

                            break;
                        case 5:

                            System.out.println("Ingrese el nombre de la actividad que desea ver: ");
                            String nombreActividad = lector.readLine();
                            coleccion.mostrarActividades(nombreActividad);
                            break;
                        case 0:

                            System.out.println("");
                            break;
                        default:

                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 2:

                    System.out.println("");
                    menu.mostrarMenuAlumnos();
                    int opcionAlumnos = Integer.parseInt(lector.readLine());
                    
                    switch(opcionAlumnos){
                        case 1:

                            System.out.println("Ingrese el nombre de la actividad a la que desea inscribir al alumno: ");
                            String nombreAct = lector.readLine();

                            if(coleccion.verifActividad(nombreAct) == false){
                                System.out.println("La actividad no existe");
                                break; 
                            }

                            System.out.println("Ingrese el nombre del alumno: ");
                            String nombre = lector.readLine();
                            System.out.println("Ingrese el apellido del alumno: ");
                            String apellido = lector.readLine();
                            System.out.println("Ingrese el rut del alumno: ");
                            String rut = lector.readLine();
                
                            Actividad actividad = coleccion.getMapaActividades().get(nombreAct);
                            
                            actividad.agregarAlumno(new Alumnos(nombre, apellido, rut), actividad);
                            System.out.println("El alumno ha sido inscrito en la actividad");
                            break;
                        case 2:
                            String opcionString;
                            String nombreAct2;
                            
                            System.out.println("Ingrese si quiere buscar por rut o por nombre y apellido: ");
                            opcionString = lector.readLine();
                            System.out.println("Ingrese el nombre de la actividad de la que desea eliminar al alumno: ");
                            nombreAct2 = lector.readLine();

                            if(coleccion.verifActividad(nombreAct2) == false){
                                System.out.println("La actividad no existe");
                                break; 
                            }

                            Actividad actividadEliminacion = coleccion.getMapaActividades().get(nombreAct2);
                            

                            if(opcionString.equals("rut"))
                            {
                                System.out.println("Ingrese el rut del alumno que desea eliminar: ");
                                String rutEliminar = lector.readLine();
                                actividadEliminacion.eliminarAlumno(actividadEliminacion, rutEliminar);
                            }
                            else{
                                System.out.println("Ingrese el nombre del alumno que desea eliminar: ");
                                String nombreEliminar = lector.readLine();
                                
                                System.out.println("Ingrese el apellido del alumno que desea eliminar: ");
                                String apellidoEliminar = lector.readLine();

                                actividadEliminacion.eliminarAlumno(actividadEliminacion, nombreEliminar, apellidoEliminar);
                            }

                            break;

                        case 3:
                            
                            System.out.println("Ingrese el nombre de la actividad que desea ver: ");
                            String nombreActMostrar = lector.readLine();
                            coleccion.mostrarAlumnosAct(nombreActMostrar);
                            break;
        
                        case 0:

                            System.out.println("");
                            break;
                            
                        default:

                            System.out.println("Opción no válida");
                            break;  
                    }

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
