/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Enums.Unidad;
import entidades.Ingrediente;
import exception.IngredienteException;
import java.util.List;

/**
 *
 * @author Ramon Valencia
 */
public interface IIngredienteDAO {
    
    public Ingrediente registraIngrediente(Ingrediente ingrediente) throws IngredienteException;
    
    public List<Ingrediente> buscarTodosLosIngredientes() throws IngredienteException;
    
    public Ingrediente buscarIngredientePorNombre(String nombre, Unidad unidad) throws IngredienteException;
    
    public Long obtenerIdIngrediente(Ingrediente ingrediente) throws IngredienteException;
    
    public Ingrediente modificarStockIngrediente(Long idIngrediente, Double Stock) throws IngredienteException;
    
    public boolean eliminarIngrediente(Long idIngrediente) throws IngredienteException;
}
