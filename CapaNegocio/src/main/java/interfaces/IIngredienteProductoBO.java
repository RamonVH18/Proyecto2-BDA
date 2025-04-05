/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.IngredienteProductoDTO;
import DTOs.IngredienteProductoFinalDTO;
import Exceptions.IngredienteBOException;
import Exceptions.IngredienteProductoBOException;
import Exceptions.ProductoBOException;
import java.util.List;


/**
 *
 * @author rodri
 */
public interface IIngredienteProductoBO {
    
    public List<IngredienteProductoFinalDTO> agregarIngredienteAProducto(List<IngredienteProductoDTO> ingredientes, String nombre) throws IngredienteProductoBOException, ProductoBOException, IngredienteBOException;
    
    
    
}
