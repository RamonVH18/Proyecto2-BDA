/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import BOs.IngredienteProductoBO;
import DTOs.IngredienteProductoDTO;
import DTOs.IngredienteProductoFinalDTO;
import Enums.Unidad;
import Exceptions.IngredienteBOException;
import Exceptions.IngredienteProductoBOException;
import Exceptions.ProductoBOException;
import exception.IngredienteException;
import exception.IngredienteProductoException;
import exception.ProductoException;
import interfaces.IIngredienteProductoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class IngredientesProductoPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        IIngredienteProductoBO ipBO = IngredienteProductoBO.getInstance();
        
        IngredienteProductoDTO ing1 = new IngredienteProductoDTO("2", "Hamburguesa", "Carne De Toro", Unidad.PIEZA);
        IngredienteProductoDTO ing2 = new IngredienteProductoDTO("3", "Hamburguesa", "Polla", Unidad.PIEZA);
        List<IngredienteProductoDTO> lista = new ArrayList<>();
        lista.add(ing1);
        lista.add(ing2);
        try {
            List<IngredienteProductoFinalDTO> listaFinal = ipBO.agregarIngredienteAProducto(lista, "Hamburguesa");
            
            System.out.println(listaFinal);
            
        } catch (IngredienteProductoBOException ex) {
            Logger.getLogger(IngredientesProductoPruebas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en ingredienteProducto");
        } catch (ProductoBOException ex) {
            Logger.getLogger(IngredientesProductoPruebas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en producto");
        } catch (IngredienteBOException ex) {
            Logger.getLogger(IngredientesProductoPruebas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en ingrediente");
        }
        
    }
    
}
