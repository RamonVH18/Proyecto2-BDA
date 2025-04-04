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
import java.util.List;

/**
 *
 * @author Ramon Valencia
 */
public class IngredientePruebas {
    
    
    public static void main(String[] args) throws IngredienteException{
        IIngredienteDAO ingredienteDAO = new IngredienteDAO();
//        Ingrediente ingrediente1 = new Ingrediente("Miel", Unidad.MILILITRO, 200.00);
//        Ingrediente ingrediente2 = new Ingrediente("Carne De Toro", Unidad.PIEZA, 80.00);
//        
//        ingrediente1 = ingredienteDAO.registraIngrediente(ingrediente1);
//        ingrediente2 = ingredienteDAO.registraIngrediente(ingrediente2);

        Ingrediente ingrediente = ingredienteDAO.buscarIngredientePorNombre("Melcoche", Unidad.GRAMO);
        
        Long id = ingredienteDAO.obtenerIdIngrediente(ingrediente);
        
        ingrediente = ingredienteDAO.modificarStockIngrediente(id, 25.00);
        
//        ingredienteDAO.eliminarIngrediente(id);
        
        
    }
}
