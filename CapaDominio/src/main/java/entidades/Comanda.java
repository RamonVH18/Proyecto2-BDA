/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Enums.Estado;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rodri
 */
@Entity
public class Comanda implements Serializable {

    //Atributos ----------------------------------------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "folio",nullable = false,unique = true)
    private String folio;
    
    @Column(name = "fechaHora",nullable = false)
    private LocalDateTime fecha;
    
    @Column(name = "estado",nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @Column(name = "total",nullable = false)
    private double precio;
    
    
    
    

    //Constructores ------------------------------------------------------------
    public Comanda() {
    }

    public Comanda(String folio, LocalDateTime fecha, Estado estado, double precio) {
        this.folio = folio;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
    }

    
    //Getters y Setters --------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // toString ----------------------------------------------------------------
    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", fecha=" + fecha + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
}
