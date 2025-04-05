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
import interfaces.IIngredienteBO;
import interfaces.IIngredienteDAO;

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
    
    @Override
    public CantidadIngredienteDTO registrarIngrediente(String nombre, String unidad, String cantidad) throws IngredienteBOException {
        try {
            if (nombre == null || nombre.isBlank()){
                throw new IngredienteBOException("El campo del nombre no puede estar vacio");
            }
            
            if (nombre.length() > 50) {
                throw new IngredienteBOException("El nombre del ingrediente no puede rebasar los 50 caracteres");
            }
            
            if (unidad == null || unidad.isBlank()) {
                throw new IngredienteBOException("El campo de la unidad de medida no puede estar vacio");
            }
            
            Unidad unidadMedida = validarUnidadMedida(unidad);
            
            if (cantidad == null || cantidad.isBlank()) {
                throw new IngredienteBOException("El campo de la cantidad no puede estar vacio");
            }
             
            if (!cantidad.matches("^-?\\d+(\\.\\d+)?$")) {
                throw new IngredienteBOException("La cantidad que ingreso es invalida");
            }
            Double cantidadUsada = Double.parseDouble(cantidad);
            
            CantidadIngredienteDTO ingredienteNuevo = new CantidadIngredienteDTO(nombre, unidadMedida, cantidadUsada);
            
            Ingrediente ingrediente = mapeador.toEntity(ingredienteNuevo);
            
            Ingrediente ingredienteViejo = ingredienteDAO.buscarIngredientePorNombre(nombre, unidadMedida);
            
            if (ingredienteViejo != null) {
                throw  new IngredienteBOException("Este ingrediente ya se encuentra registrado");
            } 
            
            ingredienteDAO.registraIngrediente(ingrediente);
            
            return ingredienteNuevo;
            
            
        } catch (Exception e) {
            throw new IngredienteBOException("Hubo un error al registrar el ingrediente: " + e.getMessage());
        }
    }
    
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
}
