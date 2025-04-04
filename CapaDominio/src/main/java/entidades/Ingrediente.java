/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Enums.Unidad;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramon Valencia
 */
@Entity
@Table (name = "Ingredientes")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Atributo para guardar el nombre de un ingrediente
     */
    @Column (name = "Nombre_Ingrediente", nullable = false, length = 50)
    private String nombre;
    /**
     * Atributo para guardar que tipo de unidad de medida se mide el ingrediente
     */
    @Column (name = "Unidad_Medida", nullable = false)
    private Unidad unidadMedida;
    /**
     * Atributo para guardar la cantidad actual que hay de un ingrediente
     */
    @Column (name = "Cantidad_Actual", nullable = false)
    private Double cantidadActual; 

    /**
     * Constructor vacio
     */
    public Ingrediente() {
    }
    /**
     * Constructor con todos los atributos
     * @param id
     * @param nombre
     * @param unidadMedida
     * @param cantidadActual 
     */
    public Ingrediente(Long id, String nombre, Unidad unidadMedida, Double cantidadActual) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadActual = cantidadActual;
    }
    /**
     * Constructor con todos los atributos excepto el ID
     * @param nombre
     * @param unidadMedida
     * @param cantidadActual 
     */
    public Ingrediente(String nombre, Unidad unidadMedida, Double cantidadActual) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadActual = cantidadActual;
    }
    
    /**
     * Getters y Setters
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Unidad getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Unidad unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + 
                "id=" + id + 
                ", nombre=" + nombre + 
                ", unidadMedida=" + unidadMedida + 
                ", cantidadActual=" + cantidadActual + 
                '}';
    }
}
