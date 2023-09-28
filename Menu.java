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

    public void mostrarMenuPrincipal() {
        coleccion.inicializarActs();
        panelPrincipal = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel labelBienvenido = new JLabel("Bienvenido al Sistema de Gestión");
        labelBienvenido.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(labelBienvenido, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        panelPrincipal.add(new JLabel(), gbc);

        JButton btnActividades = new JButton("Gestión de Actividades");
        JButton btnAlumnos = new JButton("Gestión de Alumnos");
        JButton btnSalir = new JButton("Salir");

        btnActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuActividades();
            }
        });
        
        btnAlumnos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuAlumnos();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gbc.gridy++;
        gbc.weighty = 0.0;
        panelPrincipal.add(btnActividades, gbc);

        gbc.gridy++;
        panelPrincipal.add(btnAlumnos, gbc);

        gbc.gridy++;
        panelPrincipal.add(btnSalir,gbc);

        frame.add(panelPrincipal, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}