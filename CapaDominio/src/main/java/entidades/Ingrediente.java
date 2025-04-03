/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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
    
    @Column (name = "Nombre_Ingrediente", nullable = false, length = 50)
    private String nombre;
    
    @Column (name = "Unidad_Medida", nullable = false, length = 50, unique = true)
    private String unidadMedida;
    
    @Column (name = "Cantidad_Actual", nullable = false)
    private Double cantidadActual; 

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nombre, String unidadMedida, Double cantidadActual) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadActual = cantidadActual;
    }

    public Ingrediente(String nombre, String unidadMedida, Double cantidadActual) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadActual = cantidadActual;
    }

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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
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
