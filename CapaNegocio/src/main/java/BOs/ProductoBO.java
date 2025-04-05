/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ProductoDAOImp;
import DTOs.ProductoDTO;
import Enums.Tipo;
import Exceptions.ProductoBOException;
import Mappers.ProductoMapper;
import entidades.Producto;
import exception.ProductoException;
import interfaces.IProducto;
import interfaces.IProductoBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class ProductoBO implements IProductoBO{
    
    private IProducto productoDAO = ProductoDAOImp.getInstance();
    private ProductoMapper mapper = new ProductoMapper();
    
    private static ProductoBO instanceBO;

    public ProductoBO() {
    }
    
    public static ProductoBO getInstance(){
        if(instanceBO == null) {
            instanceBO = new ProductoBO();
        }
        return instanceBO;
    }

    @Override
    public ProductoDTO registrarProducto(String nombre, String precio, Tipo tipo) throws ProductoBOException {
        try {
            /**
             * Validaciones
             */
            if (nombre == null || nombre.isBlank()){
                throw new ProductoBOException("El nombre no puede estar vacio");
            }
            
            if (nombre.length() > 50) {
                throw new ProductoBOException("El nombre del producto no puede rebasar los 50 caracteres");
            }
            
            if (precio == null) {
                throw new ProductoBOException("El precio no puede estar vacio");
            }
            
            if (!precio.matches("^-?\\d+(\\.\\d+)?$")) {
                throw new ProductoBOException("La cantidad que ingreso es invalida");
            }
            
            Double precioProducto = Double.valueOf(precio);
            
            if (tipo == null) {
                throw new ProductoBOException("El campo de la unidad de medida no puede estar vacio");
            }
            
            /**
             * Se crea el producto con la informacion obtenidad y despues se mapea
             */
            ProductoDTO productoNuevo = new ProductoDTO(nombre, precioProducto, tipo);
            Producto producto = mapper.toEntity(productoNuevo);
            /**
             * Se llama a un metodo de la DAO para confirmar que el ingrediente no exista
             */
            Producto productoViejo = productoDAO.buscarPorNombre(nombre);
            if (productoViejo != null) {
                throw  new ProductoBOException("Este producto ya se encuentra registrado");
            }
            /**
             * Finalmente se registra el producto
             */
            productoDAO.registrarProducto(producto);
            
            return productoNuevo;
        } catch (ProductoException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductoBOException("Error al registrar el producto " + ex.getMessage());
        }
    }
    
}
