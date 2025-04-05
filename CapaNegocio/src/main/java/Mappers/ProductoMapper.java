/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOs.ProductoDTO;
import Enums.Tipo;
import entidades.Producto;

/**
 *
 * @author rodri
 */
public class ProductoMapper {

    public ProductoMapper() {
    }
    
    /**
     * Metodo para mapear una entidad Producto a un DTO ProductoDTO
     * @param producto 
     * @return 
     */
    public ProductoDTO toDTO (Producto producto){
        return new ProductoDTO(producto.getNombre(), 
                producto.getPrecio(), 
                producto.getTipo()
        );
    }
    
    public Producto toEntity (ProductoDTO productoDTO){
        return new Producto(productoDTO.getNombre(), 
                productoDTO.getPrecio(), 
                productoDTO.getTipo()
        );
    }
    
    
}
