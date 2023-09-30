import java.io.*;
import javax.swing.*;

//Planificación de las actividades del área de Extensión de una Universidad

public class proyecto{
    public static void main(String[] args) throws IOException{
        
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                new Menu();
            }
        });
    }
}