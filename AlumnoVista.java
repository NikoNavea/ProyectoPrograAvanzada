package views;
import models.Alumnos;

import javax.swing.*;
import java.awt.*;

public class AlumnoVista extends PersonaVista{
    protected Alumnos alumno;
    public AlumnoVista(Alumnos alumno){
        super(alumno);
        this.alumno = alumno;
    }

    @Override
    public JPanel mostrarInfo(){
        JPanel panel = super.mostrarInfo();

        JLabel lblCarrera = new JLabel("Carrera: " + alumno.getCarrera());
        JLabel lblAnioIngreso = new JLabel("Año de Ingreso: " + alumno.getAnioIngreso());
        JLabel lblActividad = new JLabel("Actividad: " + alumno.getActividad());

        panel.setLayout(new GridLayout(5, 1));
        panel.add(lblCarrera);
        panel.add(lblAnioIngreso);
        panel.add(lblActividad);

        JFrame frame = new JFrame("Información del Alumno");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.add(panel);
        frame.setVisible(true);
        return panel;
    }
}