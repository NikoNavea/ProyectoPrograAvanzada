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
        coleccion.cargarDatos();
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
        JButton btnClaves = new JButton("Información claves horarias");
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

        btnClaves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarClavesHorarias();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coleccion.guardarDatos();
                System.exit(0);
            }
        });

        gbc.gridy++;
        gbc.weighty = 0.0;
        panelPrincipal.add(btnActividades, gbc);

        gbc.gridy++;
        panelPrincipal.add(btnAlumnos, gbc);

        gbc.gridy++;
        panelPrincipal.add(btnClaves, gbc);

        gbc.gridy++;
        panelPrincipal.add(btnSalir,gbc);

        frame.add(panelPrincipal, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void mostrarMenuActividades() {
        JPanel panelActividades = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy++;
        gbc.weighty = 1.0;
        panelPrincipal.add(new JLabel(), gbc);

        JButton btnAgregar = new JButton("Agregar Actividad");
        JButton btnEliminar = new JButton("Eliminar Actividad");
        JButton btnMostrar = new JButton("Mostrar Actividades");
        JButton btnCambiar = new JButton("Cambiar el encargado de una actividad");
        JButton btnInfo = new JButton("Información sobre una actividad");
        JButton btnEncargado = new JButton("Información de un encargado");
        JButton btnVolver = new JButton("Volver al menú principal");
        
        //Llamado a metodo agregarActividad
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panelAgregarAlumno = new JPanel();
                panelAgregarAlumno.setLayout(new BoxLayout(panelAgregarAlumno, BoxLayout.Y_AXIS));

                JTextField actividadField = new JTextField(20);
                JTextField nombreAlumnoField = new JTextField(20);
                JTextField apellidoAlumnoField = new JTextField(20);
                JTextField rutAlumnoField = new JTextField(20);
                JTextField carreraField = new JTextField(20);
                JTextField anioField = new JTextField(20);
                
                panelAgregarAlumno.add(new JLabel("Nombre de la actividad:"));
                panelAgregarAlumno.add(actividadField);

                panelAgregarAlumno.add(new JLabel("Nombre del alumno:"));
                panelAgregarAlumno.add(nombreAlumnoField);

                panelAgregarAlumno.add(new JLabel("Apellido del alumno:"));
                panelAgregarAlumno.add(apellidoAlumnoField);

                panelAgregarAlumno.add(new JLabel("Rut del alumno:"));
                panelAgregarAlumno.add(rutAlumnoField);

                panelAgregarAlumno.add(new JLabel("Carrera del alumno:"));
                panelAgregarAlumno.add(carreraField);

                panelAgregarAlumno.add(new JLabel("Año de ingreso del alumno:"));
                panelAgregarAlumno.add(anioField);

                int option = JOptionPane.showOptionDialog(
                    null,
                    panelAgregarAlumno,
                    "Ingrese los siguientes datos del alumno:",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new Object[]{"Agregar", "Cancelar"},
                    "Agregar"
                );

                if (option == JOptionPane.OK_OPTION) {
                    String nombreAct = actividadField.getText();

                    if(coleccion.verifActividad(nombreAct) == false){
                        return; 
                    }	
                    String nombreAlumno = nombreAlumnoField.getText();
                    String apellidoAlumno = apellidoAlumnoField.getText();
                    String rutAlumno = rutAlumnoField.getText();
                    String carreraAlumno = carreraField.getText();
                    String anioAlumno = anioField.getText();

                    Actividad actividad = coleccion.getMapaActividades().get(nombreAct);
                    Alumnos alumno = new Alumnos(nombreAlumno, apellidoAlumno, rutAlumno, carreraAlumno, anioAlumno);
                    
                    if(actividad.agregarAlumno(alumno, actividad)){
                        coleccion.agregarAlumnoListaMaestra(alumno);
                    }
                }

                JOptionPane.showMessageDialog(null, "Acción realizada con éxito");
            }
        });

        //Llamado a metodo eliminarActividad
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String actividadEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la actividad que desea eliminar");
                coleccion.eliminarActividad(actividadEliminar);
            }
        });

        //Llamado a metodo mostrarActividades, donde se mostraran todas las actividades
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coleccion.mostrarActividades();
            }
        });
        
        //Llamado a metodo cambiarEncargado
        btnCambiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panelCambiarEncargado = new JPanel();
                panelCambiarEncargado.setLayout(new BoxLayout(panelCambiarEncargado, BoxLayout.Y_AXIS));

                JTextField actividadEncargadoField = new JTextField(20);
                JTextField nombreEncargadoField = new JTextField(20);
                JTextField apellidoEncargadoField = new JTextField(20);
                JTextField rutEncargadoField = new JTextField(20);
                JTextField cargoEncargadoField = new JTextField(20);
                JTextField telefonoEncargadoField = new JTextField(20);
                JTextField correoEncargadoField = new JTextField(20);
                
                
                panelCambiarEncargado.add(new JLabel("Nombre de la actividad:"));
                panelCambiarEncargado.add(actividadEncargadoField);
                
                panelCambiarEncargado.add(new JLabel("Nombre del nuevo encargado:"));
                panelCambiarEncargado.add(nombreEncargadoField);

                panelCambiarEncargado.add(new JLabel("Apellido del encargado:"));
                panelCambiarEncargado.add(apellidoEncargadoField);

                panelCambiarEncargado.add(new JLabel("Rut del encargado:"));
                panelCambiarEncargado.add(rutEncargadoField);

                panelCambiarEncargado.add(new JLabel("Cargo del encargado:"));
                panelCambiarEncargado.add(cargoEncargadoField);

                panelCambiarEncargado.add(new JLabel("Telefono del encargado:"));
                panelCambiarEncargado.add(telefonoEncargadoField);

                panelCambiarEncargado.add(new JLabel("Correo del encargado:"));
                panelCambiarEncargado.add(correoEncargadoField);

                //Encargado encargado = new Encargado(nombre, apellido, rut, cargo, telefono, correo)

                int option = JOptionPane.showOptionDialog(
                    null,
                    panelCambiarEncargado,
                    "Cambiar el encargado de una actividad:",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new Object[]{"Cambiar", "Cancelar"},
                    "Cambiar"
                );

                if (option == JOptionPane.OK_OPTION) {
                    
                    String actividadEncargado = actividadEncargadoField.getText();
                    Encargado nuevoEncargado = new Encargado(nombreEncargadoField.getText(), 
                    apellidoEncargadoField.getText(), rutEncargadoField.getText(), cargoEncargadoField.getText(), 
                    telefonoEncargadoField.getText(), correoEncargadoField.getText());

                    coleccion.cambiarEncargado(nuevoEncargado, actividadEncargado);
                }
            }
        });

        //Llamado a metodo mostrarActividades, donde se mostrara informacion de una actividad en especifico
        btnInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreActividad = JOptionPane.showInputDialog("Ingrese el nombre de la actividad que desea ver");
                coleccion.mostrarActividades(nombreActividad);
            }
        });

        //Llamado a metodo mostrarInfoEncargado.
        btnEncargado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rut = JOptionPane.showInputDialog("Ingrese el rut del encargado que desea ver");
                coleccion.mostrarInfoEncargado(rut);
            }
        });

        //Accion de volver al menu principal
        btnVolver.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelActividades);
                frame.add(panelPrincipal);
                frame.revalidate();
                frame.repaint();
            }
        });

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelActividades.add(btnAgregar, gbc);

        gbc.gridy++;
        panelActividades.add(btnEliminar, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrar, gbc);

        gbc.gridy++;
        panelActividades.add(btnCambiar, gbc);

        gbc.gridy++;
        panelActividades.add(btnInfo, gbc);

        gbc.gridy++;
        panelActividades.add(btnEncargado, gbc);

        gbc.gridy++;
        panelActividades.add(btnVolver, gbc);

        frame.remove(panelPrincipal);
        frame.add(panelActividades);
        frame.revalidate();
        frame.repaint();
    }

    private void mostrarMenuAlumnos() {
        JPanel panelActividades = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy++;
        gbc.weighty = 1.0;
        panelPrincipal.add(new JLabel(), gbc);

        JButton btnAgregar = new JButton("Agregar alumno");
        JButton btnEliminar = new JButton("Eliminar alumno de una actividad");
        JButton btnMostrar = new JButton("Mostrar todos los alumnos de la Universidad");
        JButton btnMostrarInfoAlumno = new JButton("Mostrar datos de un alumno");
        JButton btnVolver = new JButton("Volver al menú principal");
        
        //Llamado a metodo agregarAlumno
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreAct = JOptionPane.showInputDialog("Ingrese el nombre de la actividad a la que desea inscribir al alumno: ");
                if(coleccion.verifActividad(nombreAct) == false){
                    return; 
                }
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno: ");
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido del alumno: ");
                String rut = JOptionPane.showInputDialog("Ingrese el rut del alumno: ");
                String carrera = JOptionPane.showInputDialog("Ingrese la carrera del alumno: ");
                String anioIngreso = JOptionPane.showInputDialog("Ingrese el año de ingreso del alumno: ");

                Actividad actividad = coleccion.getMapaActividades().get(nombreAct);
                Alumnos alumno = new Alumnos(nombre, apellido, rut, carrera, anioIngreso);
                
                if(actividad.agregarAlumno(alumno, actividad)){
                    coleccion.agregarAlumnoListaMaestra(alumno);
                }

                JOptionPane.showMessageDialog(null, "Acción realizada con éxito");
            }
        });

        //Llamado a metodo eliminarAlumno
        btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String opcionString;
                String nombreAct2;
                
                do{
                    opcionString = JOptionPane.showInputDialog("Ingrese si quiere eliminar al alumno por rut o nombre: ");
                    opcionString = opcionString.toLowerCase();
                }while(!opcionString.equals("rut") == false && !opcionString.equals("nombre") == false);
                            
                nombreAct2 = JOptionPane.showInputDialog("Ingrese el nombre de la actividad de la que desea eliminar al alumno: ");

                if(!coleccion.verifActividad(nombreAct2)){
                    return; 
                }

                Actividad actividadEliminacion = coleccion.getMapaActividades().get(nombreAct2);
           
                if(opcionString.equals("rut")){
                    String rutEliminar = JOptionPane.showInputDialog("Ingrese el rut del alumno que desea eliminar: ");
                    if(actividadEliminacion.eliminarAlumno(actividadEliminacion, rutEliminar)){
                        coleccion.eliminarAlumnoListaMaestra(rutEliminar);
                    }
                } else{
                    String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del alumno que desea eliminar: ");
                                
                    String apellidoEliminar = JOptionPane.showInputDialog("Ingrese el apellido del alumno que desea eliminar: ");
                    if(actividadEliminacion.eliminarAlumno(actividadEliminacion, nombreEliminar, apellidoEliminar)){
                        coleccion.eliminarAlumnoListaMaestra(nombreEliminar, apellidoEliminar);
                    }
                    actividadEliminacion.eliminarAlumno(actividadEliminacion, nombreEliminar, apellidoEliminar);
                }

            }
        });

        
        //Llamado a metodo mostrarAlumnosListaMaestra
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coleccion.mostrarAlumnosListaMaestra();
            }
        });

        
        //Llamado a metodo mostrarInfoAlumno
        btnMostrarInfoAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rut = JOptionPane.showInputDialog("Ingrese el rut del alumno que desea ver su información: "); 
                coleccion.mostrarInfoAlumno(rut);
            }
        });


        //Accion de volver al menu principal
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelActividades);
                frame.add(panelPrincipal);
                frame.revalidate();
                frame.repaint();
            }
        });

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelActividades.add(btnAgregar, gbc);

        gbc.gridy++;
        panelActividades.add(btnEliminar, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrar, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrarInfoAlumno, gbc);

        gbc.gridy++;
        panelActividades.add(btnVolver, gbc);

        frame.remove(panelPrincipal);
        frame.add(panelActividades);
        frame.revalidate();
        frame.repaint();
    }

    public void mostrarClavesHorarias(){
        String[] columnNames = {"Clave Horaria", "Inicio", "Fin"};
    
        Object[][] data = {
            {"1-2", "8:15", "9:25"},
            {"3-4", "9:35", "10:45"},
            {"5-6", "11:00", "12:10"},
            {"7-8", "12:20", "13:30"},
            {"ALMUERZO", "", ""},
            {"9-10", "14:30", "15:40"},
            {"11-12", "15:50", "17:00"},
            {"13-14", "17:10", "18:20"}
        };
    
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        table.setFillsViewportHeight(true);
    
        JScrollPane scrollPane = new JScrollPane(table);
    
        JOptionPane.showMessageDialog(null, scrollPane, "Información de Claves Horarias", JOptionPane.INFORMATION_MESSAGE);
    }
}