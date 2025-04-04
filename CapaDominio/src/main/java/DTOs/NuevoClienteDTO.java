/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;

/**
 *
 * Clase Padre DTO encargado de guardar los atributos comunes de los tipos de
 * clientes registrados.
 *
 * @author Daniel Miribe
 */
public class NuevoClienteDTO {

    /**
     * Atributos
     */
    /**
     * Atributo que guarda el nombre completo de un cliente.
     */
    private String nombreCompleto;

    /**
     * Atributo que guarda el numero de telefono de un cliente.
     */
    private String numeroTelefono;

    /**
     * Atributo que guarda el correo de un cliente.
     */
    private String correo;

    /**
     * Atributo que guarda la fecha en la que se registro un cliente.
     */
    private LocalDateTime fechaRegistro;

    /**
     * Constructor vacio requerido.
     */
    public NuevoClienteDTO() {
    }

    /**
     * Constructor que inicializa los atributos del cliente.
     *
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     */
    public NuevoClienteDTO(String nombreCompleto, String numeroTelefono, String correo, LocalDateTime fechaRegistro) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Getters y Setters.
     *
     */
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
        return "NuevoClienteDTO{"
                + "nombreCompleto=" + nombreCompleto
                + ", numeroTelefono=" + numeroTelefono
                + ", correo=" + correo
                + ", fechaRegistro=" + fechaRegistro
                + '}';
    }

}
