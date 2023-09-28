import java.util.*;

public class ColeccionActividades {
    private HashMap <String, Actividad> mapaActividades;
    private ArrayList <Actividad> listaActividad;

    public ColeccionActividades(){
        mapaActividades = new HashMap<>();
        listaActividad = new ArrayList<>();
    }

    public void inicializarActs(){
        Encargado encargado1 = new Encargado("Juan", "Perez", "12345678-9", "Director", "12345678", "juan@pucv.cl");
        Encargado encargado2 = new Encargado("Maria", "Gonzalez", "12345678-0", "Profesor", "12345678", "Maria@pucv.cl");
        Actividad actividad1 = new Actividad("Conferencia de Arte", "Lunes", "1-2", encargado1);
        Actividad actividad2 = new Actividad("Taller de Pintura", "Martes", "3-4", encargado2);
        mapaActividades.put(actividad1.getNombreAct(), actividad1);
        mapaActividades.put(actividad2.getNombreAct(), actividad2);
        listaActividad.add(actividad1);
        listaActividad.add(actividad2);
        Alumnos alumno1 = new Alumnos("Carlos", "Perez", "12345678-9", "Ingeniería", "2020");
        Alumnos alumno2 = new Alumnos("Vincenzo", "Verdessi", "12345678-0", "Animacion", "2022");
        Alumnos alumno3 = new Alumnos("Maria", "Gonzalez", "12345678-1", "Ingeniería", "2012");
        Alumnos alumno4 = new Alumnos("Jose", "Gonzalez", "12345678-2", "Ingeniería", "2023");
        Alumnos alumno5 = new Alumnos("Juan", "Gonzalez", "12345678-3", "Ingeniería", "2018");
        Alumnos alumno6 = new Alumnos("Benjamin", "Carrasco", "12345678-4", "Ingeniería", "2019");
        Alumnos alumno7 = new Alumnos("Yoryina", "Quiñones", "12345678-5", "Ingeniería", "2020");
        Alumnos alumno8 = new Alumnos("Diego", "Álvarez", "12345678-6", "Ingeniería", "2021");
        Alumnos alumno9 = new Alumnos("Ricardo", "Perez", "12345678-7", "Ingeniería", "2022");
        Alumnos alumno10 = new Alumnos("Pedro", "Gonzalez", "12345678-8", "Ingeniería", "2023");
        
        agregarAlumnoListaMaestra(alumno1);
        agregarAlumnoListaMaestra(alumno2);
        agregarAlumnoListaMaestra(alumno3);
        agregarAlumnoListaMaestra(alumno4);
        agregarAlumnoListaMaestra(alumno5);
        agregarAlumnoListaMaestra(alumno6);
        agregarAlumnoListaMaestra(alumno7);
        agregarAlumnoListaMaestra(alumno8);
        agregarAlumnoListaMaestra(alumno9);
        agregarAlumnoListaMaestra(alumno10);

        actividad1.agregarAlumno(alumno1, actividad1);
        actividad1.agregarAlumno(alumno2, actividad1);
        actividad1.agregarAlumno(alumno3, actividad1);
        actividad1.agregarAlumno(alumno4, actividad1);
        actividad1.agregarAlumno(alumno5, actividad1);
        actividad2.agregarAlumno(alumno6, actividad2);
        actividad2.agregarAlumno(alumno7, actividad2);
        actividad2.agregarAlumno(alumno8, actividad2);
        actividad2.agregarAlumno(alumno9, actividad2);
        actividad2.agregarAlumno(alumno10, actividad2);
    }

    public void agregarActividad(Actividad actividad){
        if(mapaActividades.get(actividad.getNombreAct()) == null){
            Actividad nuevaAct = new Actividad(actividad.getNombreAct(), actividad.getEncargado());
            mapaActividades.put(actividad.getNombreAct(), nuevaAct);
            listaActividad.add(nuevaAct);
        }else{
            System.out.println("La actividad ya existe");
        }
    }

    public void eliminarActividad(String actividadEliminar){
        
        Actividad actividadAEliminar = mapaActividades.get(actividadEliminar);
        if(mapaActividades.get(actividadEliminar) != null){
            mapaActividades.remove(actividadEliminar);
            listaActividad.remove(actividadAEliminar);
        }else{
            System.out.println("La actividad no existe");
        }
    }

    public void mostrarActividades(String nombreActividad){
        System.out.println("");
        if(mapaActividades.get(nombreActividad) == null){
            System.out.println("La actividad no existe");
            return;
        }
        Actividad actividad = mapaActividades.get(nombreActividad);

        System.out.println("Actividad: " + actividad.getNombreAct());
        System.out.println("Encargado: " + actividad.getEncargado());
        System.out.println("Lista de Alumnos de la actividad " + actividad.getNombreAct());
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s %-20s %-15s", "Nombre", "Apellido", "RUT");
        System.out.println("");
        System.out.println("--------------------------------------------------");
        for(int i = 0 ; i < actividad.getListaAlumnos().size() ; i++){
            System.out.printf("%-20s %-20s %-15s%n", actividad.getListaAlumnos().get(i).getNombre(), actividad.getListaAlumnos().get(i).getApellido(), actividad.getListaAlumnos().get(i).getRut());
        }
    }

    public void mostrarActividades(){
        System.out.println("Lista de Actividades ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-30s %-30s", "Actividad", "Encargado");
        System.out.println("");
        System.out.println("--------------------------------------------------");
        for(int i = 0 ; i < listaActividad.size() ; i++){
            //System.out.println("Actividad: " + listaActividad.get(i).getNombreAct() + " Encargado: " + listaActividad.get(i).getEncargado());
            System.out.printf("%-30s %-30s%n", listaActividad.get(i).getNombreAct(), listaActividad.get(i).getEncargado());
        }
        
    }

    public boolean verifActividad(String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            System.out.println("La actividad no existe");
            return false;
        }
        return true;
    }

    public HashMap<String, Actividad> getMapaActividades() {
        return mapaActividades;
    }

    public void mostrarAlumnosAct(String nombreAct) {
        if(mapaActividades.get(nombreAct) == null){
            System.out.println("La actividad no existe");
            return;
        }

        Actividad actividad = mapaActividades.get(nombreAct);
        System.out.println("");
        System.out.println("Lista de Alumnos de la actividad " + actividad.getNombreAct());
        System.out.println("--------------------------------------------------");
        System.out.println("Nombre               Apellido             RUT");
        System.out.println("--------------------------------------------------");
        for(int i = 0 ; i < actividad.getListaAlumnos().size() ; i++){
            //System.out.println("Nombre: " + actividad.getListaAlumnos().get(i).getNombre() + " Apellido: " + actividad.getListaAlumnos().get(i).getApellido() + " Rut: " + actividad.getListaAlumnos().get(i).getRut());
            System.out.printf("%-20s %-20s %-15s", actividad.getListaAlumnos().get(i).getNombre(),  actividad.getListaAlumnos().get(i).getApellido(), actividad.getListaAlumnos().get(i).getRut());
            System.out.println("");
        }
        System.out.println("--------------------------------------------------");
    }

    public void cambiarEncargado(String nuevoEncargado, String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            System.out.println("La actividad no existe");
            return;
        }
        Actividad actividad = mapaActividades.get(nombreActividad);
        actividad.setEncargado(nuevoEncargado);
        System.out.println("Encargado cambiado con éxito");
    }
}
