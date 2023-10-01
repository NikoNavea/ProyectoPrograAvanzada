package views;
import controllers.ColeccionActividades;
import models.Actividad;
import models.Alumnos;
import models.Encargado;

import javax.swing.*;
import java.awt.*;
/**
 * Clase que crea las interfaces gráficas para mostrar información sobre las actividades y alumnos del sistema
 */
public class ColeccionActividadesVista{
    protected ColeccionActividades coleccionActividades;
    /**
     * Constructor de la clase ColeccionActividadesVista
     * @param coleccionActividades Colección de actividades del sistema
     */
    public ColeccionActividadesVista(ColeccionActividades coleccionActividades){
        this.coleccionActividades = coleccionActividades;
    }
    /**
     * Muestra detalles sobre todas las actividades del sistema
     */
    public void mostrarActividades(){

        JFrame frame = new JFrame("Lista de Actividades");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"Actividad", "Encargado", "Día", "Clave Horaria"};
        String[][] data = new String[coleccionActividades.cantidadActividades()][4];

        for (int i = 0; i < coleccionActividades.cantidadActividades() ; i++) {
            Actividad actividad = coleccionActividades.recorrerActividades(i);
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
    /**
     * Muestra todos los alumnos del sistema junto con su información
     */
    public void mostrarAlumnosListaMaestra() {
        JFrame frame = new JFrame("Lista de Alumnos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Apellido", "RUT"};
        String[][] data = new String[coleccionActividades.cantidadAlumnosTotal()][3];

        for (int i = 0; i < coleccionActividades.cantidadAlumnosTotal() ; i++) {
            Alumnos alumno = coleccionActividades.recorrerAlumnosTotal(i);
            data[i][0] = alumno.getNombre();
            data[i][1] = alumno.getApellido();
            data[i][2] = alumno.getRut();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);

        frame.setVisible(true);
    }
}