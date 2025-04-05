/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import DTOs.ProductoDTO;
import Enums.Tipo;
import Exceptions.ProductoBOException;

/**
 *
 * @author rodri
 */
public interface IProductoBO {
    
    public ProductoDTO registrarProducto (String nombre, String precio, Tipo tipo) throws ProductoBOException;
    
}
