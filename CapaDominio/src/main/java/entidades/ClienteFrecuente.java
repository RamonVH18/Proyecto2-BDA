/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Daniel Miribe
 *
 * Entidad hija llamada ClienteFrecuente que hereda los atributos de la entidad
 * padre Cliente. Esta entidad guarda los datos de un tipo de cliente, el cual
 * es Cliente Frecuente.
 */
@Entity
@Table(name = "ClientesFrecuentes")
@DiscriminatorValue("1")
public class ClienteFrecuente extends Cliente implements Serializable {

    /**
     * Atributos
     */
    /**
     * Atributo que guarda el numero de visitas de un cliente.
     */
    @Transient
    private Integer numVisitas;

    /**
     * Atributo que guarda el total gastado por parte de un cliente.
     */
    @Transient
    private Double totalGastado;

    /**
     * Atributo que guarda los puntos de fidelidad de un cliente, los cuales se
     * consiguen cada 20 pesos gastados. 20 pesos = 1 punto.
     */
    @Transient
    private Integer puntosDeFidelidad;

    /**
     * Constructor vacio requerido
     */
    public ClienteFrecuente() {
    }

    /**
     * Constructor que inicializa todos los parametros de la entidad
     *
     * @param numVisitas
     * @param totalGastado
     * @param puntosDeFidelidad
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     */
    public ClienteFrecuente(String nombreCompleto, String numeroTelefono, String correo, LocalDateTime fechaRegistro,
            Integer numVisitas, Double totalGastado, Integer puntosDeFidelidad) {
        super(nombreCompleto, numeroTelefono, correo, fechaRegistro);
        this.numVisitas = numVisitas;
        this.totalGastado = totalGastado;
        this.puntosDeFidelidad = puntosDeFidelidad;
    }

    /**
     * Getters y Setters
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
        return "ClienteFrecuente{"
                + "numVisitas=" + numVisitas
                + ", totalGastado=" + totalGastado
                + ", puntosDeFidelidad=" + puntosDeFidelidad
                + '}';
    }

}
