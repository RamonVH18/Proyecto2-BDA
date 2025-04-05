/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author Ramon Valencia
 */
public class IngredienteBOException extends Exception{

    public IngredienteBOException(String message) {
        super(message);
    }

    public IngredienteBOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
