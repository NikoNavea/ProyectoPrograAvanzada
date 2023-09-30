package views;
import models.*;
import exceptions.*;
import controllers.ColeccionActividades;

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
        coleccion.cargarDatos();
        //coleccion.inicializarActs();
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
                coleccion.generarReporte();
                System.exit(0);
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(frame, 
                "Estas saliendo sin guardar, ¿Deseas guardar?",
                 "Confirmar salida", 
                 JOptionPane.YES_NO_OPTION, 
                 JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    coleccion.guardarDatos();
                    coleccion.generarReporte();
                    System.exit(0);
                }
                else if (respuesta == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
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

        JButton btnAgregarActividad = new JButton("Agregar Actividad");
        JButton btnEliminarActividad = new JButton("Eliminar Actividad");
        JButton btnMostrarActividades = new JButton("Mostrar Actividades");
        JButton btnCambiarEncargado = new JButton("Cambiar el encargado de una actividad");
        JButton btnInfo = new JButton("Información sobre una actividad");
        JButton btnEncargado = new JButton("Información de un encargado");
        JButton btnVolver = new JButton("Volver al menú principal");
        
        //Llamado a metodo agregarActividad
        btnAgregarActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panelDatosActividad = new JPanel();
                panelDatosActividad.setLayout(new BoxLayout(panelDatosActividad, BoxLayout.Y_AXIS));

                JTextField nombreField = new JTextField(20);
                JTextField claveHorariaField = new JTextField(20);
                JTextField diaField = new JTextField(20);

                panelDatosActividad.add(new JLabel("Nombre de la actividad:"));
                panelDatosActividad.add(nombreField);

                panelDatosActividad.add(new JLabel("Clave Horaria:"));
                panelDatosActividad.add(claveHorariaField);

                panelDatosActividad.add(new JLabel("Día:"));
                panelDatosActividad.add(diaField);

                int option = JOptionPane.showOptionDialog(
                        null,
                        panelDatosActividad,
                        "Ingrese los siguientes datos de la actividad:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new Object[]{"OK", "Cancel"},
                        "OK"
                );


                // Verificar si el usuario hizo clic en OK
                if (option == JOptionPane.OK_OPTION) {

                    JPanel panelDatosEncargado = new JPanel();
                    
                    panelDatosEncargado.setLayout(new BoxLayout(panelDatosEncargado, BoxLayout.Y_AXIS));

                    JTextField nombreEField = new JTextField(20);
                    JTextField apellidoEField = new JTextField(20);
                    JTextField rutEField = new JTextField(20);
                    JTextField cargoEField = new JTextField(20);
                    JTextField telefonoEField = new JTextField(20);
                    JTextField correoEField = new JTextField(20);

                    panelDatosEncargado.add(new JLabel("Nombre del encargado:"));
                    panelDatosEncargado.add(nombreEField);
                    
                    panelDatosEncargado.add(new JLabel("Apellido del encargado:"));
                    panelDatosEncargado.add(apellidoEField);

                    panelDatosEncargado.add(new JLabel("Rut del encargado, sin puntos y con guión:"));
                    panelDatosEncargado.add(rutEField);

                    panelDatosEncargado.add(new JLabel("Cargo del encargado:"));
                    panelDatosEncargado.add(cargoEField);
    
                    panelDatosEncargado.add(new JLabel("Telefono del encargado:"));
                    panelDatosEncargado.add(telefonoEField);

                    panelDatosEncargado.add(new JLabel("Correo del encargado de la forma @pucv.cl:"));
                    panelDatosEncargado.add(correoEField);
                    
                    int option2 = JOptionPane.showOptionDialog(
                        null,
                        panelDatosEncargado,
                        "Ingrese los siguientes datos del encargado:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new Object[]{"OK", "Cancel"},
                        "OK"
                    );

                    if(option2 == JOptionPane.OK_OPTION){
                        try{
                            String nombre = nombreEField.getText();
                            String apellido = apellidoEField.getText();
                            String rut = rutEField.getText();
                            validarRut(rut);
                            String cargo = cargoEField.getText();
                            String telefono = telefonoEField.getText();
                            String correo = correoEField.getText();
                            verificarEmail(correo);

                            Encargado encargadoVerif = coleccion.buscarEncargadoPorRut(rut);
                            if(encargadoVerif != null){
                                JOptionPane.showMessageDialog(null, "El encargado ya esta a cargo de una actividad.");
                                return;
                            }

                            Encargado encargado = new Encargado(nombre, apellido, rut, cargo, telefono, correo);
                            
                            String nombreAct = nombreField.getText();
                            String claveHoraria = claveHorariaField.getText();
                            String dia = diaField.getText();

                            if(coleccion.verifClaveHoraria(dia,claveHoraria)){
                                JOptionPane.showMessageDialog(null, "La clave horaria ya esta ocupada.");
                                return;
                            }

                            coleccion.agregarActividad(new Actividad(nombreAct,dia, claveHoraria, encargado), encargado);
                        } catch (RutInvalidoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        } catch (EmailInvalidoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                }
            }
        });

        //Llamado a metodo eliminarActividad
        btnEliminarActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String actividadEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la actividad que desea eliminar");
                coleccion.eliminarActividad(actividadEliminar);
            }
        });

        //Llamado a metodo mostrarActividades, donde se mostraran todas las actividades
        btnMostrarActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coleccion.mostrarActividades();
            }
        });
        
        //Llamado a metodo cambiarEncargado
        btnCambiarEncargado.addActionListener(new ActionListener() {
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
                    
                    try{
                        String actividadEncargado = actividadEncargadoField.getText();

                        validarRut(rutEncargadoField.getText());
                        verificarEmail(correoEncargadoField.getText());

                        Encargado nuevoEncargado = new Encargado(nombreEncargadoField.getText(), 
                        apellidoEncargadoField.getText(), rutEncargadoField.getText(), cargoEncargadoField.getText(), 
                        telefonoEncargadoField.getText(), correoEncargadoField.getText());

                        coleccion.cambiarEncargado(nuevoEncargado, actividadEncargado);
                    } catch (RutInvalidoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (EmailInvalidoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
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
                try{
                    String rut = JOptionPane.showInputDialog("Ingrese el rut del encargado que desea ver");
                    validarRut(rut);
                    coleccion.mostrarInfoEncargado(rut);
                } catch (RutInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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
        panelActividades.add(btnAgregarActividad, gbc);

        gbc.gridy++;
        panelActividades.add(btnEliminarActividad, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrarActividades, gbc);

        gbc.gridy++;
        panelActividades.add(btnCambiarEncargado, gbc);

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

        JButton btnAgregarAlumno = new JButton("Agregar alumno");
        JButton btnEliminarAlumno = new JButton("Eliminar alumno de una actividad");
        JButton btnMostrarAlumnos = new JButton("Mostrar todos los alumnos de la Universidad");
        JButton btnMostrarInfoAlumno = new JButton("Mostrar datos de un alumno");
        JButton btnCambiarCarreraAlumno = new JButton("Cambiar carrera alumno");
        JButton btnVolverPrincipal = new JButton("Volver al menú principal");
        
        //Llamado a metodo agregarAlumno
        btnAgregarAlumno.addActionListener(new ActionListener() {
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

                panelAgregarAlumno.add(new JLabel("Rut del alumno, sin puntos y con guion:"));
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

                    try{
                        String nombreAlumno = nombreAlumnoField.getText();
                        String apellidoAlumno = apellidoAlumnoField.getText();
                        String rutAlumno = rutAlumnoField.getText();
                        
                        validarRut(rutAlumno);

                        Alumnos verifAlumno = coleccion.buscarAlumnoListaMaestra(rutAlumno);

                        if(verifAlumno != null){
                            JOptionPane.showMessageDialog(null, "El alumno ya pertenece a otra actividad");
                            return;
                        }

                        String carreraAlumno = carreraField.getText();
                        String anioAlumno = anioField.getText();
                        
                        Actividad actividad = coleccion.getMapaActividades().get(nombreAct);
                        Alumnos alumno = new Alumnos(nombreAlumno, apellidoAlumno, rutAlumno, carreraAlumno, anioAlumno);
                        
                        
                        if(actividad.agregarAlumno(alumno, actividad)){
                            coleccion.agregarAlumnoListaMaestra(alumno);
                        } 
                    } catch (RutInvalidoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }

                JOptionPane.showMessageDialog(null, "Acción realizada con éxito");
            }
        });

        //Llamado a metodo eliminarAlumno
        btnEliminarAlumno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame frameOpciones = new JFrame("Seleccionar opción");
                frameOpciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameOpciones.setSize(300, 150);
                
                JPanel panelOpciones = new JPanel();
                
                JButton btnRut = new JButton("Eliminar por RUT");
                JButton btnNombre = new JButton("Eliminar por Nombre y Apellido");

                String nombreAct2 = JOptionPane.showInputDialog("Ingrese el nombre de la actividad de la que desea eliminar al alumno: ");

                if(!coleccion.verifActividad(nombreAct2)){
                    return; 
                }

                Actividad  actividadEliminacion = coleccion.getMapaActividades().get(nombreAct2);
                
                btnRut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        try{
                            String rutEliminar = JOptionPane.showInputDialog("Ingrese el rut del alumno que desea eliminar, sin puntos y con guion: ");
                            validarRut(rutEliminar);
                            if(actividadEliminacion.eliminarAlumno(actividadEliminacion, rutEliminar)){
                                coleccion.eliminarAlumnoListaMaestra(rutEliminar);
                            }
                            frameOpciones.dispose();

                        } catch (RutInvalidoException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                });
                
                btnNombre.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del alumno que desea eliminar: ");
                                    
                        String apellidoEliminar = JOptionPane.showInputDialog("Ingrese el apellido del alumno que desea eliminar: ");
                        if(actividadEliminacion.eliminarAlumno(actividadEliminacion, nombreEliminar, apellidoEliminar)){
                            coleccion.eliminarAlumnoListaMaestra(nombreEliminar, apellidoEliminar);
                        }
                        actividadEliminacion.eliminarAlumno(actividadEliminacion, nombreEliminar, apellidoEliminar);;
                        frameOpciones.dispose();
                    }
                });
                
                panelOpciones.add(btnRut);
                panelOpciones.add(btnNombre);
                
                frameOpciones.add(panelOpciones);
                frameOpciones.setVisible(true);
            }
        });
        
        //Llamado a metodo mostrarAlumnosListaMaestra
        btnMostrarAlumnos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coleccion.mostrarAlumnosListaMaestra();
            }
        });

        
        //Llamado a metodo mostrarInfoAlumno
        btnMostrarInfoAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String rut = JOptionPane.showInputDialog("Ingrese el rut del alumno que desea ver su información: "); 
                    validarRut(rut);
                    coleccion.mostrarInfoAlumno(rut);
                } catch (RutInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
        });

        btnCambiarCarreraAlumno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JPanel panelCambiarCarrera = new JPanel();
                panelCambiarCarrera.setLayout(new BoxLayout(panelCambiarCarrera, BoxLayout.Y_AXIS));

                JTextField rutAlumnoField = new JTextField(20);
                JTextField carreraAlumnoField = new JTextField(20);

                panelCambiarCarrera.add(new JLabel("Rut del alumno, sin puntos y con guion:"));
                panelCambiarCarrera.add(rutAlumnoField);

                panelCambiarCarrera.add(new JLabel("Nueva carrera del alumno:"));
                panelCambiarCarrera.add(carreraAlumnoField);

                int option = JOptionPane.showOptionDialog(
                    null,
                    panelCambiarCarrera,
                    "Ingrese los siguientes datos del alumno:",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new Object[]{"Cambiar", "Cancelar"},
                    "Cambiar"
                );

                if (option == JOptionPane.OK_OPTION) {
                    try{
                        String rutAlumno = rutAlumnoField.getText();

                        validarRut(rutAlumno);

                        String carreraAlumno = carreraAlumnoField.getText();

                        coleccion.cambiarCarreraAlumno(rutAlumno, carreraAlumno);
                    } catch (RutInvalidoException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }

            }
        });

        //Accion de volver al menu principal
        btnVolverPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelActividades);
                frame.add(panelPrincipal);
                frame.revalidate();
                frame.repaint();
            }
        });

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelActividades.add(btnAgregarAlumno, gbc);

        gbc.gridy++;
        panelActividades.add(btnEliminarAlumno, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrarAlumnos, gbc);

        gbc.gridy++;
        panelActividades.add(btnMostrarInfoAlumno, gbc);

        gbc.gridy++;
        panelActividades.add(btnCambiarCarreraAlumno, gbc);

        gbc.gridy++;
        panelActividades.add(btnVolverPrincipal, gbc);

        frame.remove(panelPrincipal);
        frame.add(panelActividades);
        frame.revalidate();
        frame.repaint();
    }

    public void mostrarClavesHorarias(){
        // Nombres de las columnas para la tabla
        String[] columnNames = {"Clave Horaria", "Inicio", "Fin"};
    
        // Datos para la tabla
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
    
        // Crear la tabla
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        table.setFillsViewportHeight(true);
    
        // Usar un panel de desplazamiento para acomodar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Mostrar la tabla en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, scrollPane, "Información de Claves Horarias", JOptionPane.INFORMATION_MESSAGE);
    }

    public void validarRut(String rut) throws RutInvalidoException {

        if (!rut.matches("^\\d{7,8}-[\\dkK]$")) {
            throw new RutInvalidoException("El formato del RUT es inválido.");
        }
    }

    public void verificarEmail(String email) throws EmailInvalidoException {
        if (!email.endsWith("@pucv.cl")) {
            throw new EmailInvalidoException("El email debe terminar con '@pucv.cl'");
        }
    }

    


}
