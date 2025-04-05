/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.CantidadIngredienteDTO;
import Exceptions.IngredienteBOException;

/**
 *
 * @author Ramon Valencia
 */
public interface IIngredienteBO {
    
   public CantidadIngredienteDTO registrarIngrediente(String nombre, String unidad, String cantidad) throws IngredienteBOException;
   
}
