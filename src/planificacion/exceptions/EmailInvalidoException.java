package planificacion.exceptions;
/**
 * Excepción que se lanza cuando el email ingresado no es válido
 */
public class EmailInvalidoException extends Exception {
    public EmailInvalidoException(String message) {
        super(message);
    }
}