/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Esta clase representa una excepcion personalizada para errores que ocurren
 * durante las operaciones relacionadas con la clase ClienteFrecuenteBO.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteBOException extends Exception {

    /**
     * Constructor que permite lanzar la excepcion con un mensaje personalizado.
     *
     * @param message Descripcion del error ocurrido
     */
    public ClienteFrecuenteBOException(String message) {
        super(message);
    }

    /**
     * Constructor que permite lanzar la excepcion con un mensaje personalizado
     * y una causa original (otra excepcion).
     *
     * @param message Descripcion del error
     * @param cause Causa original del error (por ejemplo, una excepcion de JPA)
     */
    public ClienteFrecuenteBOException(String message, Throwable cause) {
        super(message, cause);
    }

}
