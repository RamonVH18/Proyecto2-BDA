/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enums.Unidad;
import UtileriasPersistencia.Utilerias;
import conexion.Conexion;
import entidades.Ingrediente;
import exception.IngredienteException;
import interfaces.IIngredienteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 * Clase que se encarga todo lo relacionado a insertar, eliminar o  modificar un ingrediente
 * @author Ramon Valencia
 */
public class IngredienteDAO implements IIngredienteDAO {

    EntityManager em = Conexion.crearConexion();
    /**
     * Metodo encargado de registrar un ingrediente nuevo
     * @param ingrediente
     * @return
     * @throws IngredienteException 
     */
    @Override
    public Ingrediente registraIngrediente(Ingrediente ingrediente) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);

            em.getTransaction().begin();

            em.persist(ingrediente);

            em.getTransaction().commit();

            if (ingrediente.getId() == null) {
                throw new IngredienteException("No se genero correctamente el id");
            }

            return ingrediente;
        } catch (IngredienteException e) {
            throw new IngredienteException("No se pudo registrar el ingrediente: " + e.getMessage());
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }
    /**
     * Metodo necesario para buscar todos los ingredientes en la base de datos
     * @return
     * @throws IngredienteException 
     */
    @Override
    public List<Ingrediente> buscarTodosLosIngredientes() throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);
            return em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new IngredienteException("Error al obtener todos los ingredientes", e);
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }
    /**
     * Metodo usado para buscar todos un ingrediente en especifico usando su nombre y
     * el tipo de unidad de medida que usan
     * @param nombre
     * @return
     * @throws IngredienteException 
     */
    @Override
    public Ingrediente buscarIngredientePorNombre(String nombre, Unidad unidad) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);
            return em.createQuery("SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidad", Ingrediente.class)
                    .setParameter("nombre", nombre)
                    .setParameter("unidad", unidad)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new IngredienteException("No se encontro un ingrediente con el nombre: " + e.getMessage());
        } catch (NonUniqueResultException e) {
            throw new IngredienteException("Más de un ingrediente con el nombre: " + e.getMessage());
        } catch (Exception e) {
            throw new IngredienteException("Error al buscar ingrediente por nombre", e);
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }
    /**
     * Metodo que obtiene el id de ingrediente, para esto se utiliza el nombre del ingrediente y su unidad de medida,
     * el cual se extrae del mismo ingrediente 
     * @param ingrediente
     * @return
     * @throws IngredienteException 
     */
    @Override
    public Long obtenerIdIngrediente(Ingrediente ingrediente) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);

            em.getTransaction().begin();

            return em.createQuery(
                    "SELECT i.id FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidad", Long.class)
                    .setParameter("nombre", ingrediente.getNombre())
                    .setParameter("unidad", ingrediente.getUnidadMedida())
                    .getSingleResult();

        } catch (NoResultException e) {
            throw new IngredienteException("No se encontro un ingrediente con el nombre: " + e.getMessage());
        } catch (NonUniqueResultException e) {
            throw new IngredienteException("Más de un ingrediente con el nombre: " + e.getMessage());
        } catch (Exception e) {
            throw new IngredienteException("Error al buscar el id del ingrediente" + e.getMessage());
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }
    /**
     * Metodo usado para modificar el stock de un ingrediente, para esto se usa el id del ingrediente y 
     * el nuevo stock que se desea registrar
     * @param idIngrediente
     * @param Stock
     * @return
     * @throws IngredienteException 
     */
    @Override
    public Ingrediente modificarStockIngrediente(Long idIngrediente, Double Stock) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);

            em.getTransaction().begin();

            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);

            ingrediente.setCantidadActual(Stock);
            if (ingrediente == null) {
                throw new IngredienteException("El ingrediente con id " + idIngrediente + " no existe.");
            }
            em.getTransaction().commit();
            
            return ingrediente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new IngredienteException("Hubo un error al modificar el stock de este ingrediente: " + e.getMessage());
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }
    /**
     * Metodo para eliminar un ingrediente, para esto ocupamos el id de el ingrediente
     * @param idIngrediente
     * @return
     * @throws IngredienteException 
     */
    @Override
    public boolean eliminarIngrediente(Long idIngrediente) throws IngredienteException {
        try {
            em = Utilerias.validarConexion(em);
            
            em.getTransaction().begin();
            
            Ingrediente ingrediente = em.find(Ingrediente.class, idIngrediente);
            
            em.remove(ingrediente);
            
            em .getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new IngredienteException("Hubo un error al eliminar este ingrediente: " + e.getMessage());
        } finally {
            Utilerias.cerrarConexion(em);
        }
    }

}
