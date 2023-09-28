import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ColeccionActividades {
    private HashMap <String, Actividad> mapaActividades;
    private ArrayList <Actividad> listaActividad;
    private ArrayList <Alumnos> listaMaestra;
    private ArrayList <Encargado> listaEncargados;
    

    public ColeccionActividades(){
        mapaActividades = new HashMap<>();
        listaActividad = new ArrayList<>();
        listaMaestra = new ArrayList<>();
        listaEncargados = new ArrayList<>();
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
            mapaActividades.put(actividad.getNombreAct(), actividad);
            listaActividad.add(actividad);
            JOptionPane.showMessageDialog(null, "La actividad se ha agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "La actividad ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarAlumnosActividadListaMaestra(Actividad actividad){
        for(int i = 0 ; i < listaMaestra.size() ; i++){
            if(actividad.eliminarAlumnoListaMaestraAct(listaMaestra.get(i).getRut())){
                listaMaestra.remove(i);
            }
        }
    }

    public void eliminarActividad(String actividadEliminar){
        
        Actividad actividadAEliminar = mapaActividades.get(actividadEliminar);
        if(mapaActividades.get(actividadEliminar) != null){
            eliminarAlumnosActividadListaMaestra(actividadAEliminar);
            mapaActividades.remove(actividadEliminar);
            listaActividad.remove(actividadAEliminar);
            JOptionPane.showMessageDialog(null, "La actividad se ha eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }  

    public void mostrarActividades(String nombreActividad) {
        // Crear una nueva ventana de diálogo
        if(!verifActividad(nombreActividad)){
            return;
        }
        //System.out.println(mapaActividades.values());
        
        Actividad actividad = mapaActividades.get(nombreActividad);
        actividad.mostrarDetallesActividad();
    }

    public void mostrarActividades(){

        JFrame frame = new JFrame("Lista de Actividades");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"Actividad", "Encargado", "Día", "Clave Horaria"};
        String[][] data = new String[listaActividad.size()][4];

        for (int i = 0; i < listaActividad.size(); i++) {
            Actividad actividad = listaActividad.get(i);
            Encargado encargado = actividad.getEncargado();
            data[i][0] = actividad.getNombreAct();
            data[i][1] = encargado.getNombre() + " " + encargado.getApellido();
            data[i][2] = actividad.getDia();
            data[i][3] = actividad.getClaveHoraria();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);

        frame.setVisible(true);
    }

    public boolean verifActividad(String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            System.out.println("La actividad no existe");
            return false;
        }
        return true;
    }

    public void agregarAlumnoListaMaestra(Alumnos alumno){
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getRut().equals(alumno.getRut())){
                JOptionPane.showMessageDialog(null, "El alumno ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        listaMaestra.add(alumno);
    }

    public void eliminarAlumnoListaMaestra(String rutAlumno){
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getRut().equals(rutAlumno)){
                listaMaestra.remove(i);
                JOptionPane.showMessageDialog(null, "El alumno se ha eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }

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

    public HashMap<String, Actividad> getMapaActividades() {
        return mapaActividades;
    }

    public void mostrarAlumnosListaMaestra() {
        // Crear una nueva ventana
        JFrame frame = new JFrame("Lista de Elementos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear un panel para mostrar la lista de elementos
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear una tabla para mostrar la lista de elementos
        String[] columnNames = {"Nombre", "Apellido", "RUT"};
        String[][] data = new String[listaMaestra.size()][3];

        for (int i = 0; i < listaMaestra.size(); i++) {
            Alumnos alumno = listaMaestra.get(i);
            data[i][0] = alumno.getNombre();
            data[i][1] = alumno.getApellido();
            data[i][2] = alumno.getRut();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar la tabla al panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }



    public void cambiarEncargado(Encargado nuevoEncargado, String nombreActividad){
        if(mapaActividades.get(nombreActividad) == null){
            JOptionPane.showMessageDialog(null, "La actividad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Actividad actividad = mapaActividades.get(nombreActividad);
        actividad.setEncargado(nuevoEncargado);
        JOptionPane.showMessageDialog(null, "Encargado cambiado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } 

    public void mostrarInfoAlumno(String rut){
        if(rut == null){
            return;
        }
        for(int i = 0; i < listaMaestra.size(); i++){
            if(listaMaestra.get(i).getRut().equals(rut)){
                listaMaestra.get(i).mostrarInfo();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarInfoEncargado(String rut){
        if(rut == null){
            return;
        }
        for(int i = 0; i < listaActividad.size(); i++){
            if(listaActividad.get(i).getEncargado().getRut().equals(rut)){
                listaActividad.get(i).getEncargado().mostrarInfo();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El encargado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
