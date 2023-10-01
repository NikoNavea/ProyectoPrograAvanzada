package exceptions;
/**
 * Excepción que se lanza cuando el rut ingresado no es válido
 */
public class RutInvalidoException extends Exception {
    public RutInvalidoException(String message) {
        super(message);
    }
}


