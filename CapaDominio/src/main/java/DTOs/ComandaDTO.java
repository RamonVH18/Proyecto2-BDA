/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Enums.Estado;
import java.time.LocalDateTime;

/**
 *
 * @author rodri
 */
public class ComandaDTO {
    
    private int mesa;
    private String telefono;
    private String folio;
    private LocalDateTime fechaHora;
    private Estado estado = Estado.Activa;
    private double precio;

    
    public ComandaDTO() {
    }

    //Constructor solo con mesa y otro con mesa y teléfono por si no se asigna cliente a la comanda
    public ComandaDTO(int mesa) {
        this.mesa = mesa;
    }

    public ComandaDTO(int mesa, String telefono) {
        this.mesa = mesa;
        this.telefono = telefono;
    }
    //---------------------------------------------------------------------------------------------
    
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    @Override
    public String toString() {
        return "ComandaDTO{" + "mesa=" + mesa + ", telefono=" + telefono + ", folio=" + folio + ", fechaHora=" + fechaHora + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
    
    
    
    
    
    
    
}
