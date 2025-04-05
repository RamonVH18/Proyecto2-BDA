/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;


import DAOs.IngredienteDAO;
import DTOs.CantidadIngredienteDTO;
import Enums.Unidad;
import Exceptions.IngredienteBOException;
import Mappers.IngredienteMapper;
import entidades.Ingrediente;
import exception.IngredienteException;
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Valencia
 */
public class IngredienteBO implements IIngredienteBO {
    
    private IIngredienteDAO ingredienteDAO = IngredienteDAO.getInstance();
    private IngredienteMapper mapeador = new IngredienteMapper();
    
    private static IngredienteBO instanceBO;
    
    private IngredienteBO(){
    }
    
    public static IngredienteBO getInstance(){
        if(instanceBO == null) {
            instanceBO = new IngredienteBO();
        }
        return instanceBO;
    }
    /**
     * Metodo para registrar un ingrediente en BO
     * @param nombre
     * @param unidad
     * @param cantidad
     * @return
     * @throws IngredienteBOException 
     */
    @Override
    public CantidadIngredienteDTO registrarIngrediente(String nombre, Unidad unidad, String cantidad) throws IngredienteBOException {
        try {
            /**
             * Validaciones
             */
            if (nombre == null || nombre.isBlank()){
                throw new IngredienteBOException("El campo del nombre no puede estar vacio");
            }
            
            if (nombre.length() > 50) {
                throw new IngredienteBOException("El nombre del ingrediente no puede rebasar los 50 caracteres");
            }
            /**
             * Se llama a un metodo especial para validar la unidad de medida
             */
            
            /**
             * mas validaciones
             */
            if (cantidad == null || cantidad.isBlank()) {
                throw new IngredienteBOException("El campo de la cantidad no puede estar vacio");
            }
             
            if (!cantidad.matches("^-?\\d+(\\.\\d+)?$")) {
                throw new IngredienteBOException("La cantidad que ingreso es invalida");
            }
            
            Double cantidadUsada = Double.parseDouble(cantidad);
            /**
             * Se crea el ingrediente con la informacion obtenidad y despues se mapea
             */
            CantidadIngredienteDTO ingredienteNuevo = new CantidadIngredienteDTO(nombre, unidad, cantidadUsada);
            Ingrediente ingrediente = mapeador.toEntity(ingredienteNuevo);
            /**
             * Se llama a un metodo de la DAO para confirmar que el ingrediente no exista
             */
            Ingrediente ingredienteViejo = ingredienteDAO.buscarIngredientePorNombre(nombre, unidad);
            if (ingredienteViejo != null) {
                throw  new IngredienteBOException("Este ingrediente ya se encuentra registrado");
            } 
            /**
             * Finalmente se registra el ingrediente
             */
            ingredienteDAO.registraIngrediente(ingrediente);
            
            return ingredienteNuevo;
            
            
        } catch (Exception e) {
            throw new IngredienteBOException("Hubo un error al registrar el ingrediente: " + e.getMessage());
        }
    }
    /**
     * Metodo que sirve para validar que el tipo de unidad de medida este bien
     * Perdon Profe se que un combobox solucionaba todos mis problemas, pero es que el diseño de la ventana ya habia quedado bien bonito, 
     * y aparte me traumaron los comboBox
     * Ya se corrigio, siempre si agregue el comboBox, gracias RodrigoDeidad
     * Dejare esto aqui por si acaso
     * @param unidad
     * @return
     * @throws IngredienteBOException 
     */
    public Unidad validarUnidadMedida(String unidad) throws IngredienteBOException{
        
        if (null == unidad) {
            throw new IngredienteBOException("No existe esa unidad de medida");
        }
        unidad = unidad.trim().toLowerCase();
        
        switch (unidad) {
            case "gramo":
            case "gramos":
            case "gr":
            case "g":
                return Unidad.GRAMO;
            case "mililitro":
            case "mililitros":
            case "ml":
                return Unidad.MILILITRO;
            case "pieza":
            case "piezas":
            case "pz":
            case "p":
                return Unidad.PIEZA;
            default:
                throw new IngredienteBOException("No existe esa unidad de medida");
        }
    }
    /**
     * Metodo que se encarga de obtener todos los Ingredientes que existen
     * @return
     * @throws IngredienteBOException 
     */
    @Override 
    public List<CantidadIngredienteDTO> obtenerIngredientesDisponibles() throws IngredienteBOException{
        List<CantidadIngredienteDTO> ingredientesDisponibles = new ArrayList<>();
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.buscarTodosLosIngredientes();
            /**
             * For que se encarga de mapear toda la lista por completo
             */
            for (int i = 0; i < ingredientes.size(); i++) {
                Ingrediente ingrediente = ingredientes.get(i);
                CantidadIngredienteDTO ingredienteViejo = mapeador.toCantidadIngredienteDTO(ingrediente);
                ingredientesDisponibles.add(ingredienteViejo);
            }
            
            return ingredientesDisponibles;
            
        } catch (IngredienteException ex) {
            throw new IngredienteBOException("Hubo un error al consultar los ingredientes disponibles");
        }
        
    }
    /**
     * Metodo que se encarga de eliminar un ingrediente
     * @param ingredienteDTO
     * @return
     * @throws IngredienteBOException 
     */
    @Override
    public boolean eliminarIngrediente(CantidadIngredienteDTO ingredienteDTO) throws IngredienteBOException {
        try {
            
            Ingrediente ingrediente = mapeador.toEntity(ingredienteDTO);
            /**
             * Se llama a este metodo de la DAO para obtener el Id
             */
            Long id = ingredienteDAO.obtenerIdIngrediente(ingrediente);
            /**
             * En esta condicional se maneja el metodo de eliminar, si todos sale bien se regresa un true
             * y si no se crea una excepcion
             */
            if (ingredienteDAO.eliminarIngrediente(id)) {
                return true;
            } else {
                throw new IngredienteBOException("No se pudo eliminar este ingrediente");
            }
            
        } catch (Exception ex) {
            throw new IngredienteBOException("No se pudo eliminar este ingrediente");
        } 
    }
    /**
     * Metodo para aumentar el stock
     * NO CONFUNDIR CON disminuirStock!!
     * @param ingredienteDTO
     * @param stock
     * @return
     * @throws IngredienteBOException 
     */
    @Override
    public boolean aumentarStock(CantidadIngredienteDTO ingredienteDTO, Double stock) throws IngredienteBOException {
        try {
            /**
             * Se crea el nuevoStock sumando la cantidad a agregar al antiguo Stock
             */
            Double nuevoStock = (ingredienteDTO.getCantidadUsada() + stock);
            
            Ingrediente ingrediente = mapeador.toEntity(ingredienteDTO);
            /**
             * Se llama un metodo para buscar el ingrediente
             */
            Long id = ingredienteDAO.obtenerIdIngrediente(ingrediente);
            
            ingredienteDAO.modificarStockIngrediente(id, nuevoStock);
            
            return true;
        } catch (IngredienteException ex) {
            throw new IngredienteBOException("No se pudo agregar mas stock al inventario");
        }
    }
    /**
     * Metodo que se encarga de disminuir el stock
     * NO CONFUNDIR CON aumentarStock
     * @param ingredienteDTO
     * @param stock
     * @return
     * @throws IngredienteBOException 
     */
    @Override
    public boolean disminuirStock(CantidadIngredienteDTO ingredienteDTO, Double stock) throws IngredienteBOException {
        try {
            /**
             * Se crea el nuevoStock restando la cantidad a agregar al antiguo Stock
             */
            Double nuevoStock = (ingredienteDTO.getCantidadUsada() - stock);
            /**
             * Validacion para que no se pueda guardar un stock negativo
             */
            if (nuevoStock < 0) {
                throw new IngredienteBOException("Esta intentando quitar mas stock de la que hay disponible");
            }
            
            Ingrediente ingrediente = mapeador.toEntity(ingredienteDTO);
            /**
             * Se llama un metodo para buscar el ingrediente
             */
            Long id = ingredienteDAO.obtenerIdIngrediente(ingrediente);
            
            ingredienteDAO.modificarStockIngrediente(id, nuevoStock);
            
            return true;
        } catch (IngredienteException e) {
            throw new IngredienteBOException("ERROR: " + e.getMessage());
        }
    }
}
