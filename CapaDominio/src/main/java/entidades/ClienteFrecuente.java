/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Daniel Miribe
 */
@Entity
@Table(name = "ClientesFrecuentes")
@DiscriminatorValue("1")
public class ClienteFrecuente extends Cliente implements Serializable {

    @Column(name = "numeroVisitas")
    private Integer numVisitas;

    @Column(name = "totalGastado")
    private Double totalGastado;

    @Column(name = "puntosDeFidelidad")
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
     */
    public ClienteFrecuente(Integer numVisitas, Double totalGastado, Integer puntosDeFidelidad) {
        this.numVisitas = numVisitas;
        this.totalGastado = totalGastado;
        this.puntosDeFidelidad = puntosDeFidelidad;
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

    @Override
    public String toString() {
        return "ClienteFrecuente{"
                + "numVisitas=" + numVisitas
                + ", totalGastado=" + totalGastado
                + ", puntosDeFidelidad=" + puntosDeFidelidad
                + '}';
    }

}
