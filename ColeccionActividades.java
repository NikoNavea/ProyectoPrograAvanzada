import java.util.*;

public class ColeccionActividades {
    private HashMap <String, Actividad> mapaActividades;
    private ArrayList <Actividad> listaActividad;

    public ColeccionActividades(){
        mapaActividades = new HashMap<>();
        listaActividad = new ArrayList<>();
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

    public void mostrarActividades(){
        System.out.println("Lista de Actividades ");
        for(int i = 0 ; i < listaActividad.size() ; i++){
            System.out.println("Actividad: " + listaActividad.get(i).getNombreAct() + " Encargado: " + listaActividad.get(i).getEncargado());
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
}
