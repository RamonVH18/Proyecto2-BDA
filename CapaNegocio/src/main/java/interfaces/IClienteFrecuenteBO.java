package interfaces;

import DTOs.NuevoClienteFrecuenteDTO;
import Exceptions.ClienteFrecuenteBOException;

/**
 * Interfaz que define las operaciones del negocio relacionadas con clientes
 * frecuentes.
 *
 * @author Daniel Miribe
 */
public interface IClienteFrecuenteBO {

    /**
     * Registra un nuevo cliente frecuente con la informacion proporcionada.
     *
     * @param nombreCompleto Nombre completo del cliente.
     * @param telefono Numero de telefono del cliente.
     * @param correo Correo electronico del cliente.
     * @return Objeto NuevoClienteFrecuenteDTO con los datos registrados.
     * @throws ClienteFrecuenteBOException Si ocurre un error durante el
     * registro.
     */
    public NuevoClienteFrecuenteDTO registrarClienteFrecuente(String nombreCompleto, String telefono, String correo) throws ClienteFrecuenteBOException;

}
