/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Ventanas.VentanaBase;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ramon Valencia
 */
public class ControlDeNavegacion implements IControl{
    
    private Map<String, VentanaBase> ventanas = new HashMap<>();
    private static ControlDeNavegacion instance;
    
    private ControlDeNavegacion() {
    }
    
    public static ControlDeNavegacion getInstance() {
        if (instance == null) {
            instance = new ControlDeNavegacion();
        }
        return instance;
    }

    @Override
    public void abrirVentana(String nombre) {
        for (VentanaBase ventana : ventanas.values()) {
            ventana.setVisible(false); // Oculta todas las ventanas
        }
        if (ventanas.containsKey(nombre)) {
            ventanas.get(nombre).setVisible(true); // Muestra la ventana solicitada
        }
    }
    
    @Override
    public void registrarVentana(String nombre, VentanaBase ventana) {
        ventanas.put(nombre, ventana);
    }
    
    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirCuadroError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
