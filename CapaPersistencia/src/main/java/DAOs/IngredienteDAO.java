/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import UtileriasPersitencia.Utilerias;
import conexion.Conexion;
import entidades.Ingrediente;
import exception.IngredienteException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ramon Valencia
 */
public class IngredienteDAO implements IIngredienteDAO{
    
     EntityManager em = Conexion.crearConexion();

    @Override
    public Ingrediente registraIngrediente(Ingrediente ingrediente) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);
            
            em.getTransaction().begin();
            
            em.persist(ingrediente);
            
            em.getTransaction().commit();
            
            if (ingrediente.getId() == null) {
                throw new IngredienteException("No se genero correctamente el id"  );
            } 
            
            
            return ingrediente;
        } catch (IngredienteException e) {
            throw new IngredienteException("No se pudo registrar el ingrediente: " + e.getMessage());
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }

    @Override
    public List<Ingrediente> buscarTodosLosIngredientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingrediente buscarIngredientePorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long obtenerIdIngrediente(Ingrediente ingrediente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ingrediente modificarStockIngrediente(Long idIngrediente, Double Stock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
