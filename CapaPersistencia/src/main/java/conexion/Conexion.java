/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rodri
 */
public class Conexion {
        
    //hacemos un atributo static (una vez que se genera
    private static EntityManagerFactory emf;
    
    public static EntityManager crearConexion(){
        
        //Primero verificamos si está abierto, si no la abrimos
        if(emf == null || !emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("ConexionPu");
        }
        //Crear entity manager
        EntityManager entityManager = emf.createEntityManager();
        
        //Regresamos el entity manager
        return entityManager;
    }
    
    
    //Método para cerrar el factory
    public static void cerrarConexion(){
        if(emf != null){
            emf.close();
        }
        
    }
}
