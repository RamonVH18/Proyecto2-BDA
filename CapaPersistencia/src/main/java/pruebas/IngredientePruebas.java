/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import DAOs.IngredienteDAO;
import Enums.Unidad;
import entidades.Ingrediente;
import exception.IngredienteException;
import interfaces.IIngredienteDAO;

/**
 *
 * @author Ramon Valencia
 */
public class IngredientePruebas {
    
    
    public static void main(String[] args) throws IngredienteException{
        IIngredienteDAO ingredienteDAO = new IngredienteDAO();
        Unidad ml = Unidad.MILILITRO;
        Unidad grm = Unidad.GRAMO;
        Ingrediente ingrediente1 = new Ingrediente("Miel", ml, 200.00);
        Ingrediente ingrediente2 = new Ingrediente("Melcoche", grm, 350.00);
        
        ingrediente1 = ingredienteDAO.registraIngrediente(ingrediente1);
        ingrediente2 = ingredienteDAO.registraIngrediente(ingrediente2);
    }
}
