import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    private JFrame frame;
    private JPanel panelPrincipal;
    private ColeccionActividades coleccion;

    
    public Menu() {
        frame = new JFrame("Sistema de Planificación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        coleccion = new ColeccionActividades();
        mostrarMenuPrincipal();
    }
}