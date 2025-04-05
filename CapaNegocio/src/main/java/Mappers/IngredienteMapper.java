/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.CantidadIngredienteDTO;
import Enums.Unidad;
import entidades.Ingrediente;

/**
 *
 * @author Ramon Valencia
 */
public class IngredienteMapper {

    public IngredienteMapper() {
    }
    
    public CantidadIngredienteDTO toCantidadIngredienteDTO(Ingrediente ingrediente) {
        return new CantidadIngredienteDTO(ingrediente.getNombre(), 
                ingrediente.getUnidadMedida(), 
                ingrediente.getCantidadActual()
        );
    }
    
    public Ingrediente toEntity(CantidadIngredienteDTO ingredienteDTO) {
        return new Ingrediente(ingredienteDTO.getNombre(), 
                ingredienteDTO.getUnidadMedida(), 
                ingredienteDTO.getCantidadUsada()
        );
    }
}
