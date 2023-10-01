package views;
import models.Persona;

import javax.swing.*;
import java.awt.*;
/**
 * Clase que crea la interfaz gráfica para mostrar información sobre una persona
 * @see Persona
 */
public class PersonaVista {
    protected Persona persona;
    /**
     * Constructor de la clase PersonaVista
     * @param persona Persona de la cual se mostrará la información 
     */
    public PersonaVista (Persona persona){
        this.persona = persona;
    }

    /**
     * Muestra la información de la persona
     * @return JPanel con la información de la persona
     */
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
