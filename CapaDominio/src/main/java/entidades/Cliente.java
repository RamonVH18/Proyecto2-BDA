/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Daniel M
 *
 * Entidad padre que guarda los atributos comunes de cada cliente.
 *
 * Estrategia JOINED utilizada, para mejor flexibilidad a la hora de realizar
 * consultas, al mismo tiempo que se separan en diferentes tablas para mejor
 * claridad.
 */
@Entity
@Table(name = "Clientes")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_cliente", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Cliente implements Serializable {

    /**
     * Atributos
     */
    /**
     * Atributo encargado de guardar el ID del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Guarda el nombre completo del cliente, es obligatorio y tiene una
     * longitud maxima de 100 caracteres
     */
    @Column(name = "nombreCompleto", length = 100, nullable = false)
    private String nombreCompleto;

    /**
     * Atributo que guarda el telefono del cliente encriptado, es obligatorio, irrepetible
     * y tiene una longitud maxima de 100 caracteres
     */
    @Column(name = "numeroTelefono", nullable = false, unique = true)
    private String numeroTelefono;

    /**
     * Atributo que guarda el correo del cliente, es opcional, irrepetible y
     * tiene una longitud maxima de 100 caracteres
     */
    @Column(name = "correo", length = 100, nullable = true, unique = true)
    private String correo;

    /**
     * Atributo que guarda la fecha en la que el cliente fue registrado, es
     * obligatorio
     */
    @Column(name = "fechaRegistro", nullable = false)
    private LocalDateTime fechaRegistro;

    /**
     * Constructor vacio requerido
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa todos los parametros de la entidad cliente
     *
     * @param nombreCompleto
     * @param numeroTelefono
     * @param correo
     * @param fechaRegistro
     */
    public Cliente(String nombreCompleto, String numeroTelefono, String correo, LocalDateTime fechaRegistro) {
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
        return "Cliente{"
                + "id=" + id
                + ", nombreCompleto=" + nombreCompleto
                + ", numeroTelefono=" + numeroTelefono
                + ", correo=" + correo
                + ", fechaRegistro=" + fechaRegistro
                + '}';
    }

}
