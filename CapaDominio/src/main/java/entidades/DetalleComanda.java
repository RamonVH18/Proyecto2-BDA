/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ramon Valencia
 */
@Entity
@Table (name = "DetallesComanda")
public class DetalleComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Atributo para escribir las especificaciones que puede tener uno o dos productos
     * Siempre y cuando ambos sean iguales
     */
    @Column (name = "Especificaciones", nullable = true, length = 400)
    private String especificaciones;
    /**
     * Atributo para escribir la cantidad de productos que tienen estos detalles en especifico
     */
    @Column (name = "Cantidad", nullable = false)
    private int cantidad;
    /**
     * Atributo para definir el precio en el que se van a vender el o los productos
     */
    @Column (name = "Precio_Venta", nullable = false)
    private Double precioVenta;
    /**
     * Mapeo de la relacion muchos a uno
     * Aqui definimos que una comanda puede tener muchos detalles
     * Pero un detalle solo le puede pertenecer a una comanda
     */
    @ManyToOne
    @JoinColumn(name = "idComanda", nullable = false) 
    private Comanda comanda;
    /**
     * Mapeo de la relacion muchos a uno, en este caso como es una relacion unidireccional 
     * solo se ocupa poner un atributo producto en esta clase, producto se deja igual
     */
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    
    /**
     * Constructor vacio
     */
    public DetalleComanda() {
    }
    /**
     * Constructor con todos los atributos
     * @param id
     * @param especificaciones
     * @param cantidad
     * @param precioVenta
     * @param comanda
     * @param producto 
     */
    public DetalleComanda(Long id, String especificaciones, int cantidad, Double precioVenta, Comanda comanda, Producto producto) {
        this.id = id;
        this.especificaciones = especificaciones;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.comanda = comanda;
        this.producto = producto;
    }
    /**
     * Constructor con todos los atributos excepto el ID
     * @param especificaciones
     * @param cantidad
     * @param precioVenta
     * @param comanda
     * @param producto 
     */
    public DetalleComanda(String especificaciones, int cantidad, Double precioVenta, Comanda comanda, Producto producto) {
        this.especificaciones = especificaciones;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.comanda = comanda;
        this.producto = producto;
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

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleComanda{" + 
                "id=" + id + 
                ", especificaciones=" + especificaciones + 
                ", cantidad=" + cantidad + 
                ", precioVenta=" + precioVenta + 
                ", comanda=" + comanda + 
                ", producto=" + producto +
                '}';
    }
}
