/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Ventanas.VentanaBase;

/**
 *
 * @author Ramon Valencia
 */
public interface IControl {
    
    /**
     * Metodo que se encarga de abrir las ventana seleccionada
     * @param nombre 
     */
    public void abrirVentana(String nombre);
    /**
     * Metodo que se encarga de guardar la ventana que se acaba de abrir en el HashMap y de esa manera se pueda manipular y se pueda abrir
     * @param nombre
     * @param ventana 
     */
    public void registrarVentana(String nombre, VentanaBase ventana);
    /**
     * Este metodo se encarga de cerrar una ventan
     * @param nombre 
     */
    public void cerrarVentana(String nombre);
}
