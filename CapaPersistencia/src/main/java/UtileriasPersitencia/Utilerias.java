/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtileriasPersitencia;

import conexion.Conexion;
import javax.persistence.EntityManager;

/**
 *
 * @author Ramon Valencia
 */
public class Utilerias {
    
    public static EntityManager validarConexion(EntityManager em) {
        //Validamos que la conexion si o si se encuentra abierta antes del iniciar
            if(em == null || !em.isOpen()){
                em = Conexion.crearConexion();
            }
            return em;
    }
    
    public static void cerrarConexion(EntityManager em){
            //Independientemente de lo que pase cerramos la conexion
            em.close();
            Conexion.cerrarConexion();
    }
}
