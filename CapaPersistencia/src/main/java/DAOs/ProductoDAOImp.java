/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Enums.Tipo;
import conexion.Conexion;
import entidades.Producto;
import exception.ProductoException;
import interfaces.IProducto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author rodri
 */
public class ProductoDAOImp implements IProducto{

    EntityManager em = Conexion.crearConexion();
    
    @Override
    public Producto registrarProducto(Producto producto) throws ProductoException {
        try {
            crearConexion();
            //Comensar la transacción
            em.getTransaction().begin();

            //Persistimos el objetito
            em.persist(producto);

            //Aplicamos el commit
            em.getTransaction().commit();

            //Regresamos el producto
            return producto;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ProductoException("No se pudo registrar el producto");
        } finally{
            cerrarConexion();
        }
    }
    
    @Override
    public List<Producto> buscarTodos() throws ProductoException {
        try{
             
           crearConexion();
           
           return em.createQuery("Select p FROM Producto")
                    .getResultList();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new ProductoException("Error al buscar todo los productos");
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public Producto buscarPorNombre(String nombre) throws ProductoException {
        try {
            crearConexion();
            
            return (Producto) em.createQuery("Select p FROM Producto p WHERE p.nombre = :nombre", Producto.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ProductoException("No se encontró el Producto: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public List<Producto> buscarPorTipo(Tipo tipo) throws ProductoException {
        try {
            //Validamos que la conexion si o si se encuentra abierta antes del iniciar
            crearConexion();
            
            return em.createQuery("SELECT p FROM Producto P WHERE p.tipo = :tipo", Producto.class)
                    .setParameter("tipo", tipo)
                    .getResultList();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ProductoException("No se encontraron Productos: " + e.getMessage());
        } finally {
            //Independientemente de lo que pase cerramos la conexion
            cerrarConexion();
        }
    }
    
    @Override
    public boolean actualizarProducto(String nombre, Producto producto) throws ProductoException {
        try {
            
            Producto productoActualizar = buscarPorNombre(nombre);
            
            //Validamos que la conexion si o si se encuentra abierta antes del iniciar
            crearConexion();
           
            //Realmente solo se van a poder actualizar estos datos del Producto
            productoActualizar.setEstado(producto.getEstado());
            productoActualizar.setPrecio(producto.getPrecio());
            
            //Comensar la transacción
            em.getTransaction().begin();
            //Persistimos el objetito
            em.merge(productoActualizar);
            //Aplicamos el commit
            em.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ProductoException("No se pudo actualizar el Producto" + e.getMessage());
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
