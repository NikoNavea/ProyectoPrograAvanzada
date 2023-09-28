import javax.swing.*;
import java.awt.*;

public class Alumnos extends Persona{
    private String carrera;
    private String anioIngreso;
    
    public Alumnos(String nombre, String apellido, String rut, String carrera, String anioIngreso){
        super(nombre, apellido, rut);
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
    }

    public String getCarrera(){
        return carrera;
    }

    public String setCarrera(String carrera){
        this.carrera = carrera;
        return carrera;
    }

    public String getAnioIngreso(){
        return anioIngreso;
    }

    public String setAnioIngreso(String anioIngreso){
        this.anioIngreso = anioIngreso;
        return anioIngreso;
    }
    
    public JPanel mostrarInfo() {
        JPanel panel = super.mostrarInfo();

        JLabel lblCarrera = new JLabel("Carrera: " + carrera);
        JLabel lblAnioIngreso = new JLabel("Año de Ingreso: " + anioIngreso);

        panel.setLayout(new GridLayout(5, 1));
        panel.add(lblCarrera);
        panel.add(lblAnioIngreso);

        JFrame frame = new JFrame("Información del Alumno");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.add(panel);
        frame.setVisible(true);

        return panel;
    }
}
