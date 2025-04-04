/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ventanas;

import Control.ControlDeNavegacion;

/**
 *
 * @author Ramon Valencia
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControlDeNavegacion control = ControlDeNavegacion.getInstance();
        InicioSesion inicio = new InicioSesion(control);
        
        control.registrarVentana("Inicio Sesion", inicio);
        control.abrirVentana("Inicio Sesion");
    }
    
}
