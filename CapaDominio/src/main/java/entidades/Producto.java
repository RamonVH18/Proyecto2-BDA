/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Enums.Tipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rodri
 */
@Entity
public class Producto implements Serializable {

    //Atributos ----------------------------------------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre",nullable = false,unique = true)
    private String nombre;
    
    @Column(name = "precio",nullable = false)
    private Integer precio;
    
    @Column(name = "tipo", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;
    
    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true) // Composición
    private List<IngredienteProducto> ingredientesUsados = new ArrayList<>();
    
    //Constructores ------------------------------------------------------------

    public Producto() {
    }

    public Producto(String nombre, Integer precio, Tipo tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
    
    
    
    

    //Getters y Setters --------------------------------------------------------
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<IngredienteProducto> getIngredientesUsados() {
        return ingredientesUsados;
    }

    public void setIngredientesUsados(List<IngredienteProducto> ingredientesUsados) {
        this.ingredientesUsados = ingredientesUsados;
    }
    
    
    
    
    

    //Cosas que se generan solas -----------------------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    // toString ----------------------------------------------------------------

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", ingredientesUsados=" + ingredientesUsados + '}';
    }

    
    
}
