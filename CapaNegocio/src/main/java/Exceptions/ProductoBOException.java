/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author rodri
 */
public class ProductoBOException extends Exception{

    public ProductoBOException(String message) {
        super(message);
    }

    public ProductoBOException(String message, Throwable cause) {
        super(message, cause);
    }
}
