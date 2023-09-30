package views;
import models.Persona;

import javax.swing.*;
import java.awt.*;

public class PersonaVista {
    protected Persona persona;
    public PersonaVista (Persona persona){
        this.persona = persona;
    }

    
    public JPanel mostrarInfo(){
        JPanel panel = new JPanel(new GridLayout(3, 1));
    
        JLabel lblNombre = new JLabel("Nombre: " + persona.getNombre());
        JLabel lblApellido = new JLabel("Apellido: " + persona.getApellido());
        JLabel lblRut = new JLabel("RUT: " + persona.getRut());
    
        panel.add(lblNombre);
        panel.add(lblApellido);
        panel.add(lblRut);
    
        return panel;
    }
}
