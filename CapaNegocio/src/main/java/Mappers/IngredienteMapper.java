/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.CantidadIngredienteDTO;
import Enums.Unidad;
import entidades.Ingrediente;

/**
 * Clase mapeadora de ingredientes
 * @author Ramon Valencia
 */
public class IngredienteMapper {

    public IngredienteMapper() {
    }
    /**
     * Metodo para mapear una entidad Ingrediente a un DTO CantidadIngredienteDTO
     * @param ingrediente
     * @return 
     */
    public CantidadIngredienteDTO toCantidadIngredienteDTO(Ingrediente ingrediente) {
        return new CantidadIngredienteDTO(ingrediente.getNombre(), 
                ingrediente.getUnidadMedida(), 
                ingrediente.getCantidadActual()
        );
    }
    /**
     * Metodo para mapear un DTO CantidadIngredienteDTO a una entidad Ingrediente
     * @param ingredienteDTO
     * @return 
     */
    public Ingrediente toEntity(CantidadIngredienteDTO ingredienteDTO) {
        return new Ingrediente(ingredienteDTO.getNombre(), 
                ingredienteDTO.getUnidadMedida(), 
                ingredienteDTO.getCantidadUsada()
        );
    }
}
