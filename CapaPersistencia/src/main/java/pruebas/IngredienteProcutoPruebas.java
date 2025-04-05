/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import DAOs.IngredienteDAO;
import DAOs.IngredienteProductoDAOImp;
import DAOs.ProductoDAOImp;
import Enums.Unidad;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Producto;
import exception.IngredienteException;
import exception.IngredienteProductoException;
import exception.ProductoException;
import interfaces.IIngredienteDAO;
import interfaces.IIngredienteProducto;
import interfaces.IProducto;

/**
 *
 * @author rodri
 */
public class IngredienteProcutoPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ProductoException, IngredienteException {
        
        IIngredienteProducto ingredienteProductoDAO = IngredienteProductoDAOImp.getInstance();
        IProducto productoDAO = ProductoDAOImp.getInstance();
        IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstance();
        
        try{
////      Agregar Ingrediente a Producto 
//        Producto producto1 = productoDAO.buscarPorNombre("Hamburguesa");
//        Ingrediente ingrediente1 = ingredienteDAO.buscarIngredientePorNombre("Melcoche",Unidad.GRAMO);
//        
//        IngredienteProducto ingredienteProducto = new IngredienteProducto(100, producto1, ingrediente1);
//        
//        ingredienteProductoDAO.registrarIngredienteProducto(ingredienteProducto);
//        
//        System.out.println(ingredienteProducto);

//      Eliminar Ingrediente de un Producto
        ingredienteProductoDAO.eliminarIngredienteProducto(2l);
        
        } catch (IngredienteProductoException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
