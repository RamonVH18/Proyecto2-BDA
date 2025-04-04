/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author rodri
 */
public class IngredienteProductoDTO {
    
    private String cantidad;    
    private String nombreProducto;
    private String nombreIngrediente;    
    private String unidadMedida;

    public IngredienteProductoDTO() {
    }

    public IngredienteProductoDTO(String cantidad, String nombreProducto, String nombreIngrediente, String unidadMedida) {
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.nombreIngrediente = nombreIngrediente;
        this.unidadMedida = unidadMedida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

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
    
    
    
    
}
