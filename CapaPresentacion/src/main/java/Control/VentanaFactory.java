/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Ventanas.MenuAdministrador;
import Ventanas.MenuComandas;
import Ventanas.MenuIngredientes;
import Ventanas.VentanaBase;

/**
 *
 * @author Ramon Valencia
 */
public class VentanaFactory {
    ControlDeNavegacion control = ControlDeNavegacion.getInstance();
    
    public VentanaBase crearVentana(TipoVentana tipo) {
        switch (tipo) {
            case ADMINISTRADOR:
                return new MenuAdministrador(control);
            case INGREDIENTES:
                return new MenuIngredientes(control);
            case COMANDAS:
                return new MenuComandas(control);
            default:
                throw new IllegalArgumentException("Tipo de ventana no soportado: " + tipo);
        }
    }
}
