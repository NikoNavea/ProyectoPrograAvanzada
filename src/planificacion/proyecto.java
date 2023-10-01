package planificacion;
import java.io.*;
import javax.swing.*;

import planificacion.views.Menu;
//Planificación de las actividades del área de Extensión de una Universidad
/**
 * Clase que ejecuta el programa
 */
public class proyecto{
    public static void main(String[] args) throws IOException{
        
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new Menu();
            }
        });
    }
}