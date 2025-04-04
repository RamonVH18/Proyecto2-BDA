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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ramon Valencia
 */
@Entity
@Table(name = "IngredientesProdcuto")
public class IngredienteProducto implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Columna Encargada de mostrar la cantidad de un ingrediente 
     * en un producto
     */
    @Column (name = "Cantidad_Ingrediente", nullable = false)
    private String cantidad;
    
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idIngrediente", nullable = false)
    private Ingrediente ingrediente;
    
    /**
     * Constructor vacio
     */
    public IngredienteProducto() {
    }
    /**
     * Cosntructor con todos los atributos 
     * @param id
     * @param cantidad 
     */
    public IngredienteProducto(Long id, String cantidad, Producto producto, Ingrediente ingrediente) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }
    /**
     * Constructor con atributos excepto ID
     * @param cantidad 
     */
    public IngredienteProducto(String cantidad, Producto producto, Ingrediente ingrediente) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }
    
    /**
     * Getters y setters
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "IngredienteProducto{" + 
                "id=" + id + 
                ", cantidad=" + cantidad + 
                ", producto=" + producto + 
                ", ingrediente=" + ingrediente + 
                '}';
    }
    
}
