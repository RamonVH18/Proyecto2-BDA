package BOs;

import DAOs.ClienteFrecuenteDAOImp;
import DTOs.NuevoClienteFrecuenteDTO;
import Exceptions.ClienteFrecuenteBOException;
import Mappers.ClienteFrecuenteMapper;
import entidades.ClienteFrecuente;
import exception.ClienteFrecuenteDAOException;
import interfaces.IClienteFrecuenteBO;
import interfaces.IClienteFrecuenteDAOImp;
import java.time.LocalDateTime;

/**
 * Clase que implementa la logica de negocio para el manejo de clientes
 * frecuentes. Se encarga de validar datos y coordinar operaciones entre el DTO,
 * el mapper y el DAO.
 *
 * Implementa el patron Singleton.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteBO implements IClienteFrecuenteBO {

    private IClienteFrecuenteDAOImp clienteFrecuenteDAO = ClienteFrecuenteDAOImp.getInstanceDAO();
    private ClienteFrecuenteMapper mapeador = new ClienteFrecuenteMapper();

    private static ClienteFrecuenteBO instanceClienteFrecuenteBO;

    /**
     * Constructor privado para aplicar el patron Singleton.
     */
    private ClienteFrecuenteBO() {
    }

    /**
     * Obtiene la unica instancia de ClienteFrecuenteBO.
     *
     * @return instancia unica de ClienteFrecuenteBO.
     */
    public static ClienteFrecuenteBO getInstanceBO() {
        if (instanceClienteFrecuenteBO == null) {
            instanceClienteFrecuenteBO = new ClienteFrecuenteBO();
        }

        return instanceClienteFrecuenteBO;
    }

    /**
     * Registra un nuevo cliente frecuente en el sistema. Valida los datos
     * proporcionados y verifica que no exista ya un cliente con el mismo numero
     * de telefono.
     *
     * @param nombreCompleto Nombre completo del cliente.
     * @param telefono Numero de telefono del cliente.
     * @param correo Correo electronico del cliente.
     * @return DTO del nuevo cliente registrado.
     * @throws ClienteFrecuenteBOException Si ocurre un error en la validacion o
     * en la capa de datos.
     */
    @Override
    public NuevoClienteFrecuenteDTO registrarClienteFrecuente(String nombreCompleto, String telefono, String correo) throws ClienteFrecuenteBOException {
        if (nombreCompleto == null || nombreCompleto.isBlank()) {
            throw new ClienteFrecuenteBOException("El nombre no puede estar vacio.");
        }

        if (nombreCompleto.length() > 100) {
            throw new ClienteFrecuenteBOException("El nombre no puede superar los 100 caracteres.");
        }

        if (!esNombreValido(nombreCompleto.trim())) {
            throw new ClienteFrecuenteBOException("El nombre solo puede contener letras y de 2 a 4 palabras (nombre, apellido paterno y opcional materno).");
        }

        if (telefono == null || telefono.isBlank()) {
            throw new ClienteFrecuenteBOException("El numero de telefono no puede estar vacio");
        }

        if (telefono.length() != 10) {
            throw new ClienteFrecuenteBOException("El numero de telefono no puede ser diferente de 10 caracteres.");
        }

        if (correo.length() > 100) {
            throw new ClienteFrecuenteBOException("El correo no puede superar los 100 caracteres.");
        }

        if (!esCorreoValido(correo)) {
            throw new ClienteFrecuenteBOException("El correo no tiene un formato valido.");
        }

        try {
            // Se crea el DTO con los valores por defecto y los datos del cliente
            NuevoClienteFrecuenteDTO nuevoClienteFrecuenteDTO = new NuevoClienteFrecuenteDTO();
            nuevoClienteFrecuenteDTO.setNombreCompleto(nombreCompleto.trim());
            nuevoClienteFrecuenteDTO.setNumeroTelefono(telefono);
            if (!correo.isBlank()) {
                nuevoClienteFrecuenteDTO.setCorreo(correo);
            }
            nuevoClienteFrecuenteDTO.setFechaRegistro(LocalDateTime.now());
            nuevoClienteFrecuenteDTO.setNumVisitas(0);
            nuevoClienteFrecuenteDTO.setTotalGastado(0.0);
            nuevoClienteFrecuenteDTO.setPuntosDeFidelidad(0);

            // Se transforma el DTO en entidad
            ClienteFrecuente clienteFrecuenteEntity = mapeador.toEntity(nuevoClienteFrecuenteDTO);

            // Verifica si ya existe un cliente con el mismo nombre, telefono y correo
            ClienteFrecuente clienteVerificadoNombre = clienteFrecuenteDAO.buscarPorNombre(nombreCompleto);
            ClienteFrecuente clienteVerificadoTelefono = clienteFrecuenteDAO.buscarPorTelefono(telefono);
            ClienteFrecuente clienteVerificadoCorreo = clienteFrecuenteDAO.buscarPorCorreo(correo);

            if (clienteVerificadoNombre != null || clienteVerificadoTelefono != null || clienteVerificadoCorreo != null) {
                throw new ClienteFrecuenteBOException("El cliente que intenta registrar ya existe.");
            }

            // Se registra el nuevo cliente
            clienteFrecuenteDAO.registrarClienteFrecuente(clienteFrecuenteEntity);

            return nuevoClienteFrecuenteDTO;

        } catch (ClienteFrecuenteDAOException e) {
            throw new ClienteFrecuenteBOException("Ocurrio un error durante el registro del cliente: " + e.getMessage());
        }
    }

    /**
     * Valida que el correo tenga un formato valido.
     *
     * @param correo El correo a validar.
     * @return true si el correo tiene un formato valido, false en caso
     * contrario.
     */
    private boolean esCorreoValido(String correo) {
        if (correo == null || correo.isBlank()) {
            return true;
        }

        // Expresion regular para validar el formato del correo
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return correo.matches(regex);
    }

    /**
     * Valida que el nombre completo tenga entre 2 y 4 palabras, solo letras,
     * con espacios entre ellas.
     *
     * @param nombre El nombre completo a validar.
     * @return true si es valido, false en caso contrario.
     */
    private boolean esNombreValido(String nombre) {
        // Elimina espacios al principio y al final
        nombre = nombre.trim();

        return nombre.matches("^([A-Za-zÁÉÍÓÚÜÑáéíóúüñ]{2,})(\\s[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]{2,}){1,2}$");
    }

}
