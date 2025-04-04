/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author rodri
 */
public class IngredienteProductoException extends Exception{

    public IngredienteProductoException(String message) {
        super(message);
    }

    public IngredienteProductoException(String message, Throwable cause) {
        super(message, cause);
    }
}
