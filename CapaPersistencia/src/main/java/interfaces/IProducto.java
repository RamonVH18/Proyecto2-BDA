/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Enums.Tipo;
import entidades.Producto;
import exception.ProductoException;
import java.util.List;

/**
 *
 * @author rodri
 */
public interface IProducto {
    
    public Producto registrarProducto (Producto producto) throws ProductoException;
    
    public List<Producto> buscarTodos() throws ProductoException;
    
    public Producto buscarPorNombre (String nombre) throws ProductoException;
    
    public List<Producto> buscarPorTipo (Tipo tipo) throws ProductoException;
    
    public boolean actualizarProducto (String nombre, Producto producto) throws ProductoException;
}
