/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteFrecuente;
import exception.ClienteFrecuenteDAOException;
import java.util.List;

/**
 * Esta interfaz representa lo que debe cumplir cualquier clase DAO que maneje
 * objetos de tipo ClienteFrecuente. Define las operaciones CRUD (principalmente
 * consultas y registro en este caso) que se pueden realizar sobre la base de
 * datos para esta entidad.
 *
 * @author Daniel Miribe
 */
public interface IClienteFrecuenteDAOImp {

    /**
     * Registra un nuevo cliente frecuente en la base de datos.
     *
     * @param cliente el objeto ClienteFrecuente que se desea guardar
     * @return el mismo objeto cliente con los datos registrados
     * @throws ClienteFrecuenteDAOException si ocurre un error durante el guardado
     */
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws ClienteFrecuenteDAOException;

    /**
     * Recupera todos los clientes frecuentes almacenados en la base de datos.
     *
     * @return una lista con todos los clientes frecuentes registrados
     * @throws ClienteFrecuenteDAOException si ocurre un error durante la busqueda
     */
    public List<ClienteFrecuente> buscarTodos() throws ClienteFrecuenteDAOException;

    /**
     * Busca un cliente frecuente por su nombre completo.
     *
     * @param nombre el nombre del cliente a buscar
     * @return el cliente encontrado, o null si no se encuentra
     * @throws ClienteFrecuenteDAOException si ocurre un error o no se encuentra
     */
    public ClienteFrecuente buscarPorNombre(String nombre) throws ClienteFrecuenteDAOException;

    /**
     * Busca un cliente frecuente por su numero de telefono.
     *
     * @param telefono el numero de telefono a buscar
     * @return el cliente encontrado, o null si no se encuentra
     * @throws ClienteFrecuenteDAOException si ocurre un error o no se encuentra
     */
    public ClienteFrecuente buscarPorTelefono(String telefono) throws ClienteFrecuenteDAOException;

    /**
     * Busca un cliente frecuente por su correo electronico.
     *
     * @param correo el correo del cliente a buscar
     * @return el cliente encontrado, o null si no se encuentra
     * @throws ClienteFrecuenteDAOException si ocurre un error o no se encuentra
     */
    public ClienteFrecuente buscarPorCorreo(String correo) throws ClienteFrecuenteDAOException;
}
