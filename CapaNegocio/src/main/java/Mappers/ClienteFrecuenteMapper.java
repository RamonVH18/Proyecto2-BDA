package Mappers;

import DTOs.NuevoClienteFrecuenteDTO;
import entidades.ClienteFrecuente;

/**
 * Clase encargada de mapear entre objetos ClienteFrecuente y
 * NuevoClienteFrecuenteDTO. Facilita la conversion entre entidades y DTOs
 * usados en la capa de negocio o presentacion.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteMapper {

    /**
     * Constructor vacio del mapper.
     */
    public ClienteFrecuenteMapper() {
    }

    /**
     * Convierte un objeto ClienteFrecuente en un NuevoClienteFrecuenteDTO.
     *
     * @param clienteFrecuente Objeto ClienteFrecuente a convertir.
     * @return NuevoClienteFrecuenteDTO con los datos mapeados desde la entidad.
     */
    public NuevoClienteFrecuenteDTO toClienteFrecuenteDTO(ClienteFrecuente clienteFrecuente) {
        return new NuevoClienteFrecuenteDTO(
                clienteFrecuente.getNombreCompleto(),
                clienteFrecuente.getNumeroTelefono(),
                clienteFrecuente.getCorreo(),
                clienteFrecuente.getFechaRegistro(),
                clienteFrecuente.getNumVisitas(),
                clienteFrecuente.getTotalGastado(),
                clienteFrecuente.getPuntosDeFidelidad()
        );
    }

    /**
     * Convierte un objeto NuevoClienteFrecuenteDTO en una entidad
     * ClienteFrecuente.
     *
     * @param nuevoClienteFrecuente DTO con los datos a mapear.
     * @return ClienteFrecuente con los datos convertidos desde el DTO.
     */
    public ClienteFrecuente toEntity(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) {
        return new ClienteFrecuente(
                nuevoClienteFrecuente.getNombreCompleto(),
                nuevoClienteFrecuente.getNumeroTelefono(),
                nuevoClienteFrecuente.getCorreo(),
                nuevoClienteFrecuente.getFechaRegistro(),
                nuevoClienteFrecuente.getNumVisitas(),
                nuevoClienteFrecuente.getTotalGastado(),
                nuevoClienteFrecuente.getPuntosDeFidelidad()
        );
    }
}
