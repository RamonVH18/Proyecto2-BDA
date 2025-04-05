/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Enums.Unidad;

/**
 *
 * @author rodri
 */
public class IngredienteProductoDTO {
    
    private String cantidad;    
    private String producto;
    private String ingrediente;    
    private Unidad unidadMedida;

    public IngredienteProductoDTO() {
    }

    public IngredienteProductoDTO(String cantidad, String nombreProducto, String nombreIngrediente, Unidad unidadMedida) {
        this.cantidad = cantidad;
        this.producto = nombreProducto;
        this.ingrediente = nombreIngrediente;
        this.unidadMedida = unidadMedida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Unidad getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Unidad unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
    
    
}
