/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;

/**
 * Clase Padre DTO encargado de mostrar los atributos comunes de los tipos de
 * clientes registrados.
 *
 * @author Daniel Miribe
 */
public class ClienteDTO {

    /**
     * Atributos
     */
    /**
     * Atributo que representa el ID de un cliente.
     */
    private Long id;

    /**
     * Atributo que representa el nombre completo de un cliente.
     */
    private String nombreCompleto;

    /**
     * Atributo que representa el numero de telefono de un cliente.
     */
    private String numeroTelefono;

    /**
     * Atributo que representa el correo de un cliente.
     */
    private String correo;

    /**
     * Atributo que representa la fecha en la que se registro un cliente.
     */
    private LocalDateTime fechaRegistro;

    /**
     * Constructor vacio requerido.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor que inicializa los atributos del cliente.
     *
     * @param id
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     */
    public ClienteDTO(Long id, String nombreCompleto, String numeroTelefono, String correo, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getters y Setters
     *
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Metodo toString que devuelve los atributos de cada cliente
     *
     * @return Atributos de cada cliente
     */
    @Override
    public String toString() {
        return "ClienteDTO{"
                + "id=" + id
                + ", nombreCompleto=" + nombreCompleto
                + ", numeroTelefono=" + numeroTelefono
                + ", correo=" + correo
                + ", fechaRegistro=" + fechaRegistro
                + '}';
    }

}
