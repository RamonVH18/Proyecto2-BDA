/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.IngredienteProductoFinalDTO;
import entidades.IngredienteProducto;

/**
 *
 * @author rodri
 */
public class IngredienteProductoFinalMapper {

    public IngredienteProductoFinalMapper() {
    }
    
    public IngredienteProducto toEntity(IngredienteProductoFinalDTO IPDTO){
        return new IngredienteProducto(
                IPDTO.getCantidad(), 
                IPDTO.getProducto(), 
                IPDTO.getIngrediente());
    }
    
}
