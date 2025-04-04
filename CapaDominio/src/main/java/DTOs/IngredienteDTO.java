/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 * DTO que es utilizada para registrar la info de un ingrediente nuevo 
 * o tambien para mostrar la info de un ingrediente que ya existe
 * @author Ramon Valencia
 */
public class IngredienteDTO {
    /**
     * Atributo encargado de guardar el nombre del ingrediente
     */
    private String nombreIngrediente;
    /**
     * Atributo encargado de guardar el tipo de unidad de medidad del ingrediente
     */
    private String unidadMedida;
    /**
     * Atributo encargado de guardar la cantidad en TOTAL que hay de un ingrediente
     */
    private Double cantidadTotal;
    /**
     * Constructor vacio
     */
    public IngredienteDTO() {
    }
    /**
     * Constructor con todos los atributos
     * @param nombreIngrediente
     * @param unidadMedida
     * @param cantidadTotal 
     */
    public IngredienteDTO(String nombreIngrediente, String unidadMedida, Double cantidadTotal) {
        this.nombreIngrediente = nombreIngrediente;
        this.unidadMedida = unidadMedida;
        this.cantidadTotal = cantidadTotal;
    }
    /**
     * Getters y Setters
     */
    
    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Double cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" + 
                "nombreIngrediente=" + nombreIngrediente + 
                ", unidadMedida=" + unidadMedida + 
                ", cantidadTotal=" + cantidadTotal + 
                '}';
    }
    
    

}
