/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author rodri
 */
public class DetalleComandaDTO {

    private String especificaciones;
    private int cantidad;
    private Double precioVenta;

    public DetalleComandaDTO() {
    }

    public DetalleComandaDTO(String especificaciones, int cantidad, Double precioVenta) {
        this.especificaciones = especificaciones;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
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

    @Override
    public String toString() {
        return "DetalleComandaDTO{" + "especificaciones=" + especificaciones + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + '}';
    }
    
    
    
}
