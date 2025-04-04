/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 * DTO usado para mostrar el numero de una mesa en especifico
 * @author Ramon Valencia
 */
public class MesaDTO {
    /**
     * Atributo que se encarga de guardar el numero de la mesa
     */
    private Integer numMesa;
    /**
     * Constructor Vacio
     */
    public MesaDTO() {
    }
    /**
     * Constructor con todos los atributos
     * @param numMesa 
     */
    public MesaDTO(Integer numMesa) {
        this.numMesa = numMesa;
    }
    /**
     * Getters y Setters
     */
    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }
    
    @Override
    public String toString() {
        return "MesaDTO{" + 
                "numMesa=" + numMesa + 
                '}';
    }
}
