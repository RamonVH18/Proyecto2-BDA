/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 * DTO encargado de mostrarnos los ingredientes que tiene un producto en especifico, servira para guardar los porductos que tendra un producto en especifico
 * tambien para mostrar los ingredientes y que tanto se usa de ellos.
 * @author Ramon Valencia
 */
public class ProductoIngredientesDTO {
    /**
     * Atributo encargado de guardar el nombre del producto
     */
    private String nombreProducto;
    /**
     * Atributo que se encarga de guardar la cantidad que se usa de cada ingrediente
     */
    private List<CantidadIngredienteDTO> ingredientes;
    /**
     * Constructor vacio
     */
    public ProductoIngredientesDTO() {
    }
    /**
     * Constructor con todos los atributos
     * @param nombreProducto
     * @param ingredientes 
     */
    public ProductoIngredientesDTO(String nombreProducto, List<CantidadIngredienteDTO> ingredientes) {
        this.nombreProducto = nombreProducto;
        this.ingredientes = ingredientes;
    }
    /**
     * Getters y Setters
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<CantidadIngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<CantidadIngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "ProductoIngredientesDTO{" + 
                "nombreProducto=" + nombreProducto + 
                ", ingredientes=" + ingredientes + 
                '}';
    }
    
    
    
}
