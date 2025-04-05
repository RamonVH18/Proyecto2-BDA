/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import BOs.ProductoBO;
import DTOs.ProductoDTO;
import Enums.Tipo;
import Exceptions.ProductoBOException;
import interfaces.IProductoBO;

/**
 *
 * @author rodri
 */
public class ProductoBOPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IProductoBO productoBO = ProductoBO.getInstance();
        
        try{
            
//            ProductoDTO productoDto = productoBO.registrarProducto("RodriBurger", "500", Tipo.Platillo);
//            
//            System.out.println(productoDto);
            Boolean xd = productoBO.buscarNombre("Hamburguesa");
            System.out.println(xd);
        } catch (ProductoBOException e){
            System.err.println("Error al registrar producto" + e.getMessage());
        }
    }
    
}
