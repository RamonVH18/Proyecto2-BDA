/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.IngredienteProducto;
import exception.IngredienteProductoException;
import exception.ProductoException;
import interfaces.IIngredienteProducto;
import javax.persistence.EntityManager;

/**
 *
 * @author rodri
 */
public class IngredienteProductoDAOImp implements IIngredienteProducto{
    
    private static IngredienteProductoDAOImp instanceDAO;

    EntityManager em = Conexion.crearConexion();
    
    private IngredienteProductoDAOImp() {
    }
    
    public static IngredienteProductoDAOImp getInstance() {
        if (instanceDAO == null) {
            instanceDAO = new IngredienteProductoDAOImp();
        }
        return instanceDAO;
    }
    
    @Override
    public IngredienteProducto registrarIngredienteProducto(IngredienteProducto ingredienteProducto) throws IngredienteProductoException {
        try {
            crearConexion(); //Metodo para no andar copia y pega todo el rato
            //Comensar la transacción
            em.getTransaction().begin();

            //Persistimos el objetito
            em.persist(ingredienteProducto);

            //Aplicamos el commit
            em.getTransaction().commit();

            //Regresamos el producto
            return ingredienteProducto;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new IngredienteProductoException("No se pudo registrar el ingrediente para el producto");
        } finally{
            cerrarConexion(); //Igual para no andar copia y pega todo el rato
        }
    }

    @Override
    public boolean eliminarIngredienteProducto(Long id) throws IngredienteProductoException {
        try{
            crearConexion();
            
            em.getTransaction().begin();
            em.remove(em.find(IngredienteProducto.class, id));
            em.getTransaction().commit();
            return true;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new IngredienteProductoException(" No se eliminó el producto" + e.getMessage());
        } finally{
            //Independientemente de lo que pase cerramos la conexion
            cerrarConexion();
        }
    }
    
    public void crearConexion(){
        //Validamos que la conexion si o si se encuentra abierta antes del iniciar
            if(em == null || !em.isOpen()){
                em = Conexion.crearConexion();
            }
    }
    
    public void cerrarConexion(){
            //Independientemente de lo que pase cerramos la conexion
            em.close();
            Conexion.cerrarConexion();
    }
    
}
