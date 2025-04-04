/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author rodri
 */
public class ProductoException extends Exception {

    public ProductoException(String message) {
        super(message);
    }

    public ProductoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
