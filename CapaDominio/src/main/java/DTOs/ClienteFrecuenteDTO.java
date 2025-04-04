/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDateTime;

/**
 * Subclase DTO que hereda los atributos comunes de la clase ClienteDTO. Esta
 * clase muestra los atributos de un cliente frecuente ya existente en la BD.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteDTO extends ClienteDTO {

    /**
     * Atributos
     *
     */
    /**
     * Atributo que representa el numero de visitas de un cliente frecuente.
     */
    private Integer numVisitas;

    /**
     * Atributo que representa el total gastado de un cliente frecuente.
     */
    private Double totalGastado;

    /**
     * Atributo que representa los puntos de fidelidad de un cliente, estos
     * puntos se consiguen gastando dinero. 20 pesos = 1 punto.
     */
    private Integer puntosDeFidelidad;

    /**
     * Constructor vacio requerido.
     */
    public ClienteFrecuenteDTO() {
    }

    /**
     * Constructor que inicializa los atributos de un cliente frecuente.
     *
     * @param id
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     * @param numVisitas
     * @param totalGastado
     * @param puntosDeFidelidad
     */
    public ClienteFrecuenteDTO(Long id, String nombreCompleto, String numeroTelefono, String correo,
            LocalDateTime fechaRegistro, Integer numVisitas, Double totalGastado,
            Integer puntosDeFidelidad) {
        super(id, nombreCompleto, numeroTelefono, correo, fechaRegistro);
        this.numVisitas = numVisitas;
        this.totalGastado = totalGastado;
        this.puntosDeFidelidad = puntosDeFidelidad;
    }

    /**
     * Getters y Setters.
     *
     */
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
        return "ClienteFrecuenteDTO{"
                + "numVisitas=" + numVisitas
                + ", totalGastado=" + totalGastado
                + ", puntosDeFidelidad=" + puntosDeFidelidad
                + '}';
    }

}
