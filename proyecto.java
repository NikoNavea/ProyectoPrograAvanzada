import java.io.*;

//Planificación de las actividades del área de Extensión de una Universidad

public class proyecto{
    
    public class ListaActividades{
        private int contActividades;
        private Actividad[] listaActividades;
          
        public ListaActividades(){
            contActividades = 0;
            listaActividades = new Actividad[20];
        }

        public void agregarActividad(String nombreAct) throws IOException{
            BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
            
            if(buscarActividad(nombreAct) == -1){
                System.out.println("Ingrese el nombre del encargado de la actividad: ");
                String encargado = lector.readLine();

                Actividad nuevaAct = new Actividad(nombreAct, encargado);
                
                if (contActividades < listaActividades.length) {
                    listaActividades[contActividades] = nuevaAct;
                    contActividades++;
                    System.out.println("Actividad agregada correctamente.");
                }
                else{
                    System.out.println("La actividad ya se encuentra registrada.");
                }
            }
        }
        
        public void eliminarActividad(){
            
        }

        public int buscarActividad(String nombreAct){
            
            return 1;
        }
    }

    public class Actividad{
        private String encargado;
        private String nombreAct;
        private Alumnos[] listaAlumnos;
    
        public Actividad(String nombreAct, String encargado){
            this.encargado = encargado;
            this.nombreAct = nombreAct;
            listaAlumnos = new Alumnos[20];
        }
        

        
    }

    public class Alumnos{
        private String nombre;
        private String apellido;
        private String rut; 

        public Alumnos(){
            nombre = null;
            apellido = null;
            rut = null;
        }
    }


    
    public static void main(String[] args) throws IOException{
        
        System.out.println("Bienvenidx al sistema de planificacixn de actividades de Extensión de la Universidad Católica de Valparaiso ");

        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );
        ListaActividades listaAct = new ListaActividades();
        boolean salir = true;
       
        while(salir){
            System.out.println("Ingrese la opción que desea realizar: ");
            int opcion = Integer.parseInt(lector.readLine());
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre de la actividad que desea realizar: ");
                    String nuevaActividad = lector.readLine();
                    listaAct.agregarActividad(nuevaActividad);

                    break;
                case 2:


                    break;
                case 3:


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