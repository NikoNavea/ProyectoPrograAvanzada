package views;
import models.Actividad;
import models.Alumnos;
import models.Encargado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class ActividadVista {
    protected Actividad actividad;
    DefaultTableModel tablaAlumnos = new DefaultTableModel();
    private boolean seFiltro;

    public ActividadVista(Actividad actividad){
        this.actividad = actividad;
        this.seFiltro = false;
    }

    public void mostrarDetallesActividad() {
        JFrame frame = new JFrame("Detalles de la Actividad");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        Encargado encargado = actividad.getEncargado();

        JLabel lblNombre = new JLabel("Actividad: " + actividad.getNombreAct());
        JLabel lblEncargado = new JLabel("Encargado: " + encargado.getNombre() + " " + encargado.getApellido());
        JLabel lblRutEncargado = new JLabel("RUT: " + encargado.getRut());
        JLabel lblDia = new JLabel("Día: " + actividad.getDia());
        JLabel lblClave= new JLabel("Clave horaria: " + actividad.getClaveHoraria());

        JPanel panelSuperior = new JPanel(new GridLayout(5, 1));
        panelSuperior.add(lblNombre);
        panelSuperior.add(lblDia);
        panelSuperior.add(lblClave);
        panelSuperior.add(lblEncargado);
        panelSuperior.add(lblRutEncargado);

        tablaAlumnos.addColumn("Nombre");
        tablaAlumnos.addColumn("Apellido");
        tablaAlumnos.addColumn("RUT");
        
        for (int i = 0; i < actividad.cantidadAlumnos(actividad); i++) {
            Alumnos alumno = actividad.recorrerListaAlumnos(actividad, i);
            tablaAlumnos.addRow(new Object[]{alumno.getNombre(), alumno.getApellido(), alumno.getRut()});
        }
        

        JTable table = new JTable(tablaAlumnos);
        
        JScrollPane scrollPane = new JScrollPane(table);

        JTextField txtFiltrarCarrera = new JTextField(); 
        JButton btnFiltrar = new JButton("Filtrar por Carrera");
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnosFiltrados(txtFiltrarCarrera.getText());
            }
        });

        JButton btnRestablecer = new JButton("Restablecer");
        btnRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restablecerListaAlumnos();
            }
        });

        JPanel panelFiltro = new JPanel(new BorderLayout());
        panelFiltro.add(txtFiltrarCarrera, BorderLayout.CENTER);
        panelFiltro.add(btnFiltrar, BorderLayout.EAST);
        panelFiltro.add(btnRestablecer, BorderLayout.WEST);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelFiltro, BorderLayout.SOUTH);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    public void mostrarAlumnosFiltrados(String carrera) {
       while (tablaAlumnos.getRowCount() > 0) {
            tablaAlumnos.removeRow(0);
        }

        List<Alumnos> alumnosFiltrados = actividad.filtrarAlumnosCarrera(carrera);
       
        for (Alumnos alumno : alumnosFiltrados) {
            tablaAlumnos.addRow(new Object[]{alumno.getNombre(), alumno.getApellido(), alumno.getRut()});
        }
        seFiltro = true;
    }

    public void restablecerListaAlumnos() {
        if(!seFiltro) {
            return;
        }

        while (tablaAlumnos.getRowCount() > 0) {
            tablaAlumnos.removeRow(0);
        }
    
        for (int i = 0; i < actividad.cantidadAlumnos(actividad); i++) {
            Alumnos alumno = actividad.recorrerListaAlumnos(actividad, i);
            tablaAlumnos.addRow(new Object[]{alumno.getNombre(), alumno.getApellido(), alumno.getRut()});
        }
        seFiltro = false;
    }
}
