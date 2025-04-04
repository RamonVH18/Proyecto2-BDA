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
    
    public void abrirVentana(String nombre);
    
    public void registrarVentana(String nombre, VentanaBase ventana);
    
    public void cerrarVentana();
    
    public void abrirCuadroError();
}
