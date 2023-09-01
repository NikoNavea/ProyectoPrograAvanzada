public class Menu {
    public void mostrarMenu(){
        System.out.println("");
        System.out.println("Menú Principal");
        System.out.println("----------------------------------");
        System.out.println("1. Gestión de Actividades");
        System.out.println("2. Gestión de Alumnos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public void mostrarMenuActividades(){
        System.out.println("Menú de Gestión de Actividades");
        System.out.println("----------------------------------");
        System.out.println("1. Agregar actividad");
        System.out.println("2. Eliminar actividad");
        System.out.println("3. Mostrar actividades");
        System.out.println("4. Cambiar el encargado de una actividad");
        System.out.println("5. Información sobre una actividad");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        System.out.println("");
    }   
    
    public void mostrarMenuAlumnos(){
        System.out.println("Menú de Gestión de Alumnos");
        System.out.println("----------------------------------");
        System.out.println("1. Agregar alumno");
        System.out.println("2. Eliminar alumno de una actividad");
        System.out.println("3. Mostrar alumnos");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        System.out.println("");
    }
}
