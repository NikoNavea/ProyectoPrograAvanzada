import java.util.*;

public class Actividad {
    private String encargado;
    private String nombreAct;
    private ArrayList <Alumnos> listaAlumnos;
    
    public Actividad(String nombreAct, String encargado){
        this.encargado = encargado;
        this.nombreAct = nombreAct;
        this.listaAlumnos = new ArrayList<>();
    }

    public String getNombreAct(){ 
        return nombreAct;
    }

    public String setNombreAct(String nombreAct){
        this.nombreAct = nombreAct;
        return nombreAct;
    }
    
    public String getEncargado(){
        return encargado;
    }
    
    public String setEncargado(String encargado){
        this.encargado = encargado;
        return encargado;
    }
}
