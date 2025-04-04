/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 * DTO encargado de guardar la info de cuanto material de un ingrediente se ocupa en un prodcuto en especifico
 * Es igual que IngredienteDTO sin embargo este DTO se ocupara en otras partes
 * @author Ramon Valencia
 */
public class CantidadIngredienteDTO {
    /**
     * Atributo encargado de guardar el nombre del ingrediente utilizado
     */
    private String nombre;
    /**
     * Atributo encargado de guardar la unidad de medida en la que se mide el ingrediente
     */
    private String unidadMedida;
    /**
     * Atributo encargado de guardar la cantidad que se va usar en ese producto en especifico
     */
    private Double cantidadUsada;
    /**
     * Constructor vacio
     */
    public CantidadIngredienteDTO() {
    }
    /**
     * Constructor con todos los atributos
     * @param nombre
     * @param unidadMedida
     * @param cantidadUsada 
     */
    public CantidadIngredienteDTO(String nombre, String unidadMedida, Double cantidadUsada) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadUsada = cantidadUsada;
    }
    /**
     * Getters y Setters
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadUsada() {
        return cantidadUsada;
    }

    public void setCantidadUsada(Double cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }

    @Override
    public String toString() {
        return "CantidadIngredienteDTO{" + 
                "nombre=" + nombre + 
                ", unidadMedida=" + unidadMedida + 
                ", cantidadUsada=" + cantidadUsada + 
                '}';
    }
    
    
}
