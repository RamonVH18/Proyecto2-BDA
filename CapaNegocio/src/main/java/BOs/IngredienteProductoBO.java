/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.IngredienteDAO;
import DAOs.IngredienteProductoDAOImp;
import DAOs.ProductoDAOImp;
import DTOs.IngredienteProductoDTO;
import DTOs.IngredienteProductoFinalDTO;
import Exceptions.IngredienteBOException;
import Exceptions.IngredienteProductoBOException;
import Exceptions.ProductoBOException;
import Mappers.IngredienteMapper;
import Mappers.IngredienteProductoFinalMapper;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Producto;
import exception.IngredienteException;
import exception.IngredienteProductoException;
import exception.ProductoException;
import interfaces.IIngredienteDAO;
import interfaces.IIngredienteProducto;
import interfaces.IIngredienteProductoBO;
import interfaces.IProducto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class IngredienteProductoBO implements IIngredienteProductoBO{

    private IIngredienteProducto ipDAO = IngredienteProductoDAOImp.getInstance();
    private IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstance();
    private IProducto productoDAO = ProductoDAOImp.getInstance();
    private IngredienteProductoFinalMapper mapperIp = new IngredienteProductoFinalMapper();
    
    private static IngredienteProductoBO instanceBO;

    public IngredienteProductoBO() {
    }
    
    public static IngredienteProductoBO getInstance(){
        if(instanceBO == null) {
            instanceBO = new IngredienteProductoBO();
        }
        return instanceBO;
    }
    
    @Override
    public List<IngredienteProductoFinalDTO> agregarIngredienteAProducto(List<IngredienteProductoDTO> ingredientes, String nombre) throws IngredienteProductoBOException, ProductoBOException, IngredienteBOException {
        
        try{
            
            List<IngredienteProductoFinalDTO> listaFinal = new ArrayList<>();
            Producto productoViejo = productoDAO.buscarPorNombre(nombre);
            for (IngredienteProductoDTO ingrediente : ingredientes) {
                
                Ingrediente ingredienteViejo = ingredienteDAO.buscarIngredientePorNombre(ingrediente.getIngrediente(), ingrediente.getUnidadMedida());
                IngredienteProductoFinalDTO ipF = new IngredienteProductoFinalDTO(Integer.valueOf(ingrediente.getCantidad()), productoViejo, ingredienteViejo);
                IngredienteProducto ipFE = mapperIp.toEntity(ipF);
                ipDAO.registrarIngredienteProducto(ipFE);
                listaFinal.add(ipF);
            }
            return listaFinal;
            
        } catch (ProductoException ex) {
            Logger.getLogger(IngredienteProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductoBOException("Error al buscar producto " + ex.getMessage());
        } catch (IngredienteException ex) {
            Logger.getLogger(IngredienteProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IngredienteBOException("Error al buscar ingrediente " + ex.getMessage());
        } catch (IngredienteProductoException ex) {
            Logger.getLogger(IngredienteProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new IngredienteProductoBOException("Error al registrar Ingrediente para Producto " + ex.getMessage());
        }
        
    }
    
    
    
}
