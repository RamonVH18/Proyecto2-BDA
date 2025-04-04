/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.IngredienteProducto;
import exception.IngredienteProductoException;

/**
 *
 * @author rodri
 */
public interface IIngredienteProducto {
    
    public IngredienteProducto registrarIngredienteProducto(IngredienteProducto ingredienteProducto) throws IngredienteProductoException;
    
    public boolean eliminarIngredienteProducto(Long id) throws IngredienteProductoException;
    
}
