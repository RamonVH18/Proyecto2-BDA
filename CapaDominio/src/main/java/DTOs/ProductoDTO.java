/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Enums.Tipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ProductoDTO {

    private String nombre;
    private Integer precio;
    private Tipo tipo;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, Integer precio, Tipo tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NuevoProductoDTO{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientesUsados=" + '}';
    }
    
    
}
