/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.Ingrediente;
import entidades.Producto;

/**
 *
 * @author rodri
 */
public class IngredienteProductoFinalDTO {
    
    private Integer cantidad;
    private Producto producto;
    private Ingrediente ingrediente;
    
    public IngredienteProductoFinalDTO() {
    }

    public IngredienteProductoFinalDTO(Integer cantidad, Producto producto, Ingrediente ingrediente) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
