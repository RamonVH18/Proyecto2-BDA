/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Ingrediente;
import exception.IngredienteException;
import java.util.List;

/**
 *
 * @author Ramon Valencia
 */
public interface IIngredienteDAO {
    
    public Ingrediente registraIngrediente(Ingrediente ingrediente) throws IngredienteException;
    
    public List<Ingrediente> buscarTodosLosIngredientes();
    
    public Ingrediente buscarIngredientePorNombre(String nombre);
    
    public Long obtenerIdIngrediente(Ingrediente ingrediente);
    
    public Ingrediente modificarStockIngrediente(Long idIngrediente, Double Stock);
}
