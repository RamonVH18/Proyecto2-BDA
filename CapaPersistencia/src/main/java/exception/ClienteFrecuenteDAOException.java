/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Esta clase representa una excepcion personalizada para errores que ocurren
 * durante las operaciones relacionadas con la entidad ClienteFrecuente.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteDAOException extends Exception {

    /**
     * Constructor que permite lanzar la excepcion con un mensaje personalizado.
     *
     * @param message Descripcion del error ocurrido
     */
    public ClienteFrecuenteDAOException(String message) {
        super(message);
    }

    /**
     * Constructor que permite lanzar la excepcion con un mensaje personalizado
     * y una causa original (otra excepcion).
     *
     * @param message Descripcion del error
     * @param cause Causa original del error (por ejemplo, una excepcion de JPA)
     */
    public ClienteFrecuenteDAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
