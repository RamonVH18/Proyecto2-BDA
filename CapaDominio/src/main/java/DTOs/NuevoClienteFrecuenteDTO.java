/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;

/**
 * Subclase DTO que hereda los atributos comunes de la clase NuevoClienteDTO.
 * Esta clase guarda los atributos de un cliente frecuente.
 *
 * @author Daniel Miribe
 */
public class NuevoClienteFrecuenteDTO {

    /**
     * Atributos
     *
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
     * Atributo que guarda el numero de visitas de un cliente frecuente.
     */
    private Integer numVisitas;

    /**
     * Atributo que guarda el total gastado de un cliente frecuente.
     */
    private Double totalGastado;

    /**
     * Atributo que guarda los puntos de fidelidad de un cliente, estos puntos
     * se consiguen gastando dinero. 20 pesos = 1 punto.
     */
    private Integer puntosDeFidelidad;

    /**
     * Constructor vacio requerido.
     */
    public NuevoClienteFrecuenteDTO() {
    }

    /**
     * Constructor que incializa los atributos de un cliente frecuente.
     *
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     * @param numVisitas
     * @param totalGastado
     * @param puntosDeFidelidad
     */
    public NuevoClienteFrecuenteDTO(String nombreCompleto, String numeroTelefono, String correo, LocalDateTime fechaRegistro, Integer numVisitas, Double totalGastado, Integer puntosDeFidelidad) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.numVisitas = numVisitas;
        this.totalGastado = totalGastado;
        this.puntosDeFidelidad = puntosDeFidelidad;
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

    public Integer getNumVisitas() {
        return numVisitas;
    }

    public void setNumVisitas(Integer numVisitas) {
        this.numVisitas = numVisitas;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getPuntosDeFidelidad() {
        return puntosDeFidelidad;
    }

    public void setPuntosDeFidelidad(Integer puntosDeFidelidad) {
        this.puntosDeFidelidad = puntosDeFidelidad;
    }

    /**
     * Metodo toString que devuelve los atributos de cada cliente frecuente
     *
     * @return Atributos de cada cliente frecuente
     */
    @Override
    public String toString() {
        return "NuevoClienteFrecuenteDTO{"
                + "nombreCompleto=" + nombreCompleto
                + ", numeroTelefono=" + numeroTelefono
                + ", correo=" + correo
                + ", fechaRegistro=" + fechaRegistro
                + ", numVisitas=" + numVisitas
                + ", totalGastado=" + totalGastado
                + ", puntosDeFidelidad=" + puntosDeFidelidad
                + '}';
    }

}
