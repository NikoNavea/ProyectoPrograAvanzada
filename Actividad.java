import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Actividad {
    private Encargado encargado;
    private String nombreAct;
    private ArrayList <Alumnos> listaAlumnos;
    private String claveHoraria;
    private String dia;
    
    public Actividad(String nombreAct, String dia, String claveHoraria, Encargado encargado){
        this.encargado = encargado;
        this.nombreAct = nombreAct;
        this.dia = dia;
        this.claveHoraria = claveHoraria;
        this.listaAlumnos = new ArrayList<>();
    }

    public String getNombreAct(){ 
        return nombreAct;
    }

    public String setNombreAct(String nombreAct){
        this.nombreAct = nombreAct;
        return nombreAct;
    }
    
    public String getDia(){
        return dia;
    }

    public String setDia(String dia){
        this.dia = dia;
        return dia;
    }

    public String getClaveHoraria(){
        return claveHoraria;
    }

    public String setClaveHoraria(String claveHoraria){
        this.claveHoraria = claveHoraria;
        return claveHoraria;
    }

    public Encargado getEncargado(){
        return encargado;
    }

    public void setEncargado(Encargado encargado){
        this.encargado = encargado;
    }

    public boolean verifAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                JOptionPane.showMessageDialog(null, "El alumno ya está inscrito en la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }


    public boolean agregarAlumno(Alumnos alumno, Actividad actividad){ 
        if(actividad.verifAlumno(actividad, alumno.getRut()) == false){
            return false;
        }

        actividad.listaAlumnos.add(alumno);
        return true;
    }

    public Alumnos buscarAlumno(Actividad actividad, String rut){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getRut().equals(rut)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }

    public Alumnos buscarAlumno(Actividad actividad, String nombre, String apellido){
        for(int i = 0 ; i < actividad.listaAlumnos.size() ; i++){
            if(actividad.listaAlumnos.get(i).getNombre().equals(nombre) && actividad.listaAlumnos.get(i).getApellido().equals(apellido)){
                return actividad.listaAlumnos.get(i);
            }
        }
        return null;
    }


    public boolean eliminarAlumno(Actividad actividad, String rut){
        if(buscarAlumno(actividad, rut) == null){
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito en esta la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        actividad.listaAlumnos.remove(buscarAlumno(actividad, rut));
        JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la actividad con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        return true;
        
    }

    public boolean eliminarAlumno(Actividad actividad, String nombre, String apellido){
        if(buscarAlumno(actividad, nombre, apellido) == null){
            JOptionPane.showMessageDialog(null, "El alumno no está inscrito en esta la actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            actividad.listaAlumnos.remove(buscarAlumno(actividad, nombre, apellido));
            JOptionPane.showMessageDialog(null, "El alumno ha sido eliminado de la actividad con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }

    public void mostrarDetallesActividad() {
        JFrame frame = new JFrame("Detalles de la Actividad");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JLabel lblNombre = new JLabel("Actividad: " + nombreAct);
        JLabel lblEncargado = new JLabel("Encargado: " + encargado.getNombre() + " " + encargado.getApellido());
        JLabel lblDia = new JLabel("Día: " + dia);
        JLabel lblClave= new JLabel("Clave horaria: " + claveHoraria);

        JPanel panelSuperior = new JPanel(new GridLayout(4, 1));
        panelSuperior.add(lblNombre);
        panelSuperior.add(lblEncargado);
        panelSuperior.add(lblDia);
        panelSuperior.add(lblClave);

        String[] columnNames = {"Nombre", "Apellido", "RUT"};
        String[][] data = new String[listaAlumnos.size()][3];

        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumnos alumno = listaAlumnos.get(i);
            data[i][0] = alumno.getNombre();
            data[i][1] = alumno.getApellido();
            data[i][2] = alumno.getRut();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        frame.add(panelPrincipal);

        frame.setVisible(true);
    }

    
    public boolean eliminarAlumnoListaMaestraAct(String rut){
        for(int i = 0 ; i < listaAlumnos.size() ; i++){
            if(listaAlumnos.get(i).getRut().equals(rut)){
                listaAlumnos.remove(i);
                return true;
            }
        }
        return false;
    }
}