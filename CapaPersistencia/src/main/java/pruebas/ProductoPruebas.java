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

/**
 *
 * @author rodri
 */
public class ProductoPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        IProducto productoDAO = new ProductoDAOImp();
        
        try{
        Producto producto1 = new Producto("Hamburguesa", 120, Tipo.Platillo, Boolean.TRUE);
        Producto producto2 = new Producto("Limonada", 30, Tipo.Bebida, Boolean.TRUE);
        Producto producto3 = new Producto("Cheescake", 45, Tipo.Postre, Boolean.TRUE);
        
        productoDAO.registrarProducto(producto1);
        productoDAO.registrarProducto(producto2);
        productoDAO.registrarProducto(producto3);
        
        System.out.println(producto1);
        System.out.println(producto2);
        System.out.println(producto3);
        
        } catch (ProductoException e){
            System.err.println("Error al registrar productos" + e.getMessage());
        }
    }
    
}
