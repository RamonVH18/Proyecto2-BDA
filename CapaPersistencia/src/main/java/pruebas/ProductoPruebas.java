/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import DAOs.ProductoDAOImp;
import Enums.Tipo;
import entidades.Producto;
import exception.ProductoException;
import interfaces.IProducto;
import java.util.List;

/**
 *
 * @author rodri
 */
public class ProductoPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        IProducto productoDAO = ProductoDAOImp.getInstance();
        
        try{
            
//      Agregar Producto    
        Producto producto1 = new Producto("Hamburguesa", 120.00, Tipo.Platillo);
        Producto producto2 = new Producto("Limonada", 30.00, Tipo.Bebida);
        Producto producto3 = new Producto("Cheescake", 45.00, Tipo.Postre);
        Producto producto4 = new Producto("Jamaica", 31.00, Tipo.Bebida);
        
        productoDAO.registrarProducto(producto1);
        productoDAO.registrarProducto(producto2);
        productoDAO.registrarProducto(producto3);
        productoDAO.registrarProducto(producto4);
        
        System.out.println(producto1);
        System.out.println(producto2);
        System.out.println(producto3);
        System.out.println(producto4);

//      Buscar Por Nombre
        Producto productoBuscar = productoDAO.buscarPorNombre("Hamburguesa");
        System.out.println(productoBuscar);

//      Buscar por tipo
        List<Producto> productoBuscarTipo = productoDAO.buscarPorTipo(Tipo.Bebida);
        System.out.println(productoBuscarTipo);
        
////      Actualizar producto
//        productoBuscar.setPrecio(200.00);
//        productoBuscar.setEstado(Boolean.FALSE);
//        Boolean resultado = productoDAO.actualizarProducto(productoBuscar.getNombre(), productoBuscar);
//            System.out.println(resultado);
        
//      Buscar Todos
        List<Producto> todosProductos = productoDAO.buscarTodos();
            System.out.println(todosProductos);
        
        } catch (ProductoException e){
            System.err.println("Error al registrar productos" + e.getMessage());
        }
    }
    
}
