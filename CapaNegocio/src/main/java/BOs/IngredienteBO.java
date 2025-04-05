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
    public CantidadIngredienteDTO registrarIngrediente(String nombre, String unidad, String cantidad) throws IngredienteBOException {
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
            
            if (unidad == null || unidad.isBlank()) {
                throw new IngredienteBOException("El campo de la unidad de medida no puede estar vacio");
            }
            /**
             * Se llama a un metodo especial para validar la unidad de medida
             */
            Unidad unidadMedida = validarUnidadMedida(unidad);
            
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
            CantidadIngredienteDTO ingredienteNuevo = new CantidadIngredienteDTO(nombre, unidadMedida, cantidadUsada);
            Ingrediente ingrediente = mapeador.toEntity(ingredienteNuevo);
            /**
             * Se llama a un metodo de la DAO para confirmar que el ingrediente no exista
             */
            Ingrediente ingredienteViejo = ingredienteDAO.buscarIngredientePorNombre(nombre, unidadMedida);
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
    
    @Override 
    public List<CantidadIngredienteDTO> obtenerIngredientesDisponibles() throws IngredienteBOException{
        List<CantidadIngredienteDTO> ingredientesDisponibles = new ArrayList<>();
        try {
            List<Ingrediente> ingredientes = ingredienteDAO.buscarTodosLosIngredientes();
            
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
}
