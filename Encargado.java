import javax.swing.*;
import java.awt.*;

public class Encargado extends Persona{
    private String cargo;
    private String telefono;
    private String correo;
    
    public Encargado(String nombre, String apellido, String rut, String cargo, String telefono, String correo) {
        super(nombre, apellido, rut);
        this.cargo = cargo;
        this.telefono = telefono;
        this.correo = correo; 
    }

    public String getCargo(){
        return cargo;
    }

    public String setCargo(String cargo){
        this.cargo = cargo;
        return cargo;
    }

    public String getTelefono(){
        return telefono;
    }

    public String setTelefono(String telefono){
        this.telefono = telefono;
        return telefono;
    }

    public String getCorreo(){
        return correo;
    }

    public String setCorreo(String correo){
        this.correo = correo;
        return correo;
    }

    public JPanel mostrarInfo(){
        JPanel panel = super.mostrarInfo(); // Obtiene el panel con la información básica

        JLabel lblCargo = new JLabel("Cargo: " + cargo);
        JLabel lblTelefono = new JLabel("Teléfono: " + telefono);
        JLabel lblCorreo = new JLabel("Correo: " + correo);

        panel.setLayout(new GridLayout(6, 1)); // Actualiza el layout para 6 filas
        panel.add(lblCargo);
        panel.add(lblTelefono);
        panel.add(lblCorreo);

        JFrame frame = new JFrame("Información del Encargado");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.add(panel);
        frame.setVisible(true);

        return panel;
    }

}

