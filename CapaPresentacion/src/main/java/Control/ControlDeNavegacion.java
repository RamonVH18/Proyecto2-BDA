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
    
    /**
     * HashMap necesario para guardar las ventanas junto a su nombre
     */
    private Map<String, VentanaBase> ventanas = new HashMap<>();
    private static ControlDeNavegacion instance;
    /**
     * Constructor vacio necesario para la creacion de un singletone
     */
    private ControlDeNavegacion() {
    }
    /**
     * Metodo necesario para el funcionamiento del patron Singletone
     * Regresa la instancia de la clase y si no existe crea una
     * @return 
     */
    public static ControlDeNavegacion getInstance() {
        if (instance == null) {
            instance = new ControlDeNavegacion();
        }
        return instance;
    }
    /**
     * Metodo que se encarga de abrir las ventana seleccionada
     * @param nombre 
     */
    @Override
    public void abrirVentana(String nombre) {
        for (VentanaBase ventana : ventanas.values()) {
            ventana.setVisible(false); // Oculta todas las ventanas
        }
        if (ventanas.containsKey(nombre)) {
            ventanas.get(nombre).setVisible(true); // Muestra la ventana solicitada
        }
    }
    /**
     * Metodo que se encarga de guardar la ventana que se acaba de abrir en el HashMap y de esa manera se pueda manipular y se pueda abrir
     * @param nombre
     * @param ventana 
     */
    @Override
    public void registrarVentana(String nombre, VentanaBase ventana) {
        ventanas.put(nombre, ventana);
    }
    /**
     * Este metodo se encarga de cerrar una ventan
     * @param nombre 
     */
    @Override
    public void cerrarVentana(String nombre) {
        ventanas.remove(nombre);
    }
    
}
