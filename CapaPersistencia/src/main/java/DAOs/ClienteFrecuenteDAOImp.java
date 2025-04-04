/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import exception.ClienteFrecuenteException;
import interfaces.IClienteFrecuenteDAOImp;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Implementación del DAO para ClienteFrecuente. Utiliza el patron Singleton
 * para asegurar una sola instancia del DAO. Contiene metodos para registrar y
 * buscar clientes frecuentes en la base de datos.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteDAOImp implements IClienteFrecuenteDAOImp {

    /**
     * Instancia estatica para aplicar el patron Singleton
     */
    private static ClienteFrecuenteDAOImp instanceClienteFrecuenteDAO;

    /**
     * Constructor privado para que no se pueda instanciar desde fuera
     */
    private ClienteFrecuenteDAOImp() {
    }

    /**
     * Metodo estatico que devuelve la unica instancia del DAO
     *
     * @return
     */
    public static ClienteFrecuenteDAOImp getInstanceDAO() {
        if (instanceClienteFrecuenteDAO == null) {
            instanceClienteFrecuenteDAO = new ClienteFrecuenteDAOImp();
        }

        return instanceClienteFrecuenteDAO;
    }

    /**
     * Metodo para registrar un nuevo cliente frecuente en la base de datos.
     *
     * @param clienteFrecuente Objeto a guardar.
     * @return ClienteFrecuente guardado.
     * @throws ClienteFrecuenteException si ocurre un error al guardar.
     */
    @Override
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente clienteFrecuente) throws ClienteFrecuenteException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            // Encriptar el número de teléfono antes de persistir
            String telefonoOriginal = clienteFrecuente.getNumeroTelefono();
            String telefonoEncriptado = UtileriasPersistencia.EncriptadorAES.encriptar(telefonoOriginal);
            clienteFrecuente.setNumeroTelefono(telefonoEncriptado);

            em.persist(clienteFrecuente);

            em.getTransaction().commit();
            return clienteFrecuente;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new ClienteFrecuenteException("Error al guardar el cliente frecuente: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Metodo para obtener todos los clientes frecuentes registrados.
     *
     * @return Lista de clientes frecuentes.
     * @throws ClienteFrecuenteException si ocurre un error en la consulta.
     */
    @Override
    public List<ClienteFrecuente> buscarTodos() throws ClienteFrecuenteException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT cf FROM ClienteFrecuente cf")
                    .getResultList(); // Ejecuta la consulta JPQL
        } catch (Exception e) {
            throw new ClienteFrecuenteException("Error al buscar clientes frecuentes: " + e.getMessage());
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    /**
     * Busca un cliente frecuente por su nombre completo.
     *
     * @param nombre Nombre del cliente.
     * @return ClienteFrecuente encontrado.
     * @throws ClienteFrecuenteException si ocurre un error o no se encuentra.
     */
    @Override
    public ClienteFrecuente buscarPorNombre(String nombre) throws ClienteFrecuenteException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT cf FROM ClienteFrecuente cf WHERE cf.nombreCompleto = :nombre", ClienteFrecuente.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            throw new ClienteFrecuenteException("Error al buscar cliente frecuente por nombre: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Busca un cliente frecuente por su numero de telefono.
     *
     * @param telefono Telefono del cliente.
     * @return ClienteFrecuente encontrado.
     * @throws ClienteFrecuenteException si ocurre un error o no se encuentra.
     */
    @Override
    public ClienteFrecuente buscarPorTelefono(String telefono) throws ClienteFrecuenteException {
        EntityManager em = Conexion.crearConexion();
        try {
            // Encriptar el telefono que se recibio como parametro
            String telefonoEncriptado = UtileriasPersistencia.EncriptadorAES.encriptar(telefono);

            return em.createQuery("SELECT cf FROM ClienteFrecuente cf WHERE cf.numeroTelefono = :telefono", ClienteFrecuente.class)
                    .setParameter("telefono", telefonoEncriptado)
                    .getSingleResult();

        } catch (Exception e) {
            throw new ClienteFrecuenteException("Error al buscar cliente frecuente por telefono: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Busca un cliente frecuente por su correo electronico.
     *
     * @param correo Correo del cliente.
     * @return ClienteFrecuente encontrado.
     * @throws ClienteFrecuenteException si ocurre un error o no se encuentra.
     */
    @Override
    public ClienteFrecuente buscarPorCorreo(String correo) throws ClienteFrecuenteException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT cf FROM ClienteFrecuente cf WHERE cf.correo = :correo", ClienteFrecuente.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (Exception e) {
            throw new ClienteFrecuenteException("Error al buscar cliente frecuente por correo: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
