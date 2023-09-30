package views;
import models.Encargado;

import javax.swing.*;
import java.awt.*;

public class EncargadoVista extends PersonaVista {
    protected Encargado encargado;
    
    public EncargadoVista(Encargado encargado){
        super(encargado);
        this.encargado = encargado;
    }

    @Override
    public JPanel mostrarInfo(){
        JPanel panel = super.mostrarInfo();

        JLabel lblCargo = new JLabel("Cargo: " + encargado.getCargo());
        JLabel lblTelefono = new JLabel("Teléfono: " + encargado.getTelefono());
        JLabel lblCorreo = new JLabel("Correo: " + encargado.getCorreo());

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
