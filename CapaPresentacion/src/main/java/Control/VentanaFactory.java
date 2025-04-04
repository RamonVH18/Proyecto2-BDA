/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import static Control.TipoVentana.COMANDAS;
import static Control.TipoVentana.REGISTRO_INGREDIENTES;
import Ventanas.InicioSesion;
import Ventanas.MenuAdministrador;
import Ventanas.MenuComandas;
import Ventanas.MenuIngredientes;
import Ventanas.RegistroIngrediente;
import Ventanas.VentanaBase;
import Ventanas.VerIngredientes;

/**
 * Esta clase es donde se crea el FactoryMethod necesario para cuando se quiera 
 * acceder a una ventana sin especificar cual
 * @author Ramon Valencia
 */
public class VentanaFactory {
    ControlDeNavegacion control = ControlDeNavegacion.getInstance();
    
    public VentanaBase crearVentana(TipoVentana tipo) {
        switch (tipo) {
            case INICIO:
                return new InicioSesion(control);
            case ADMINISTRADOR:
                return new MenuAdministrador(control);
            case COMANDAS:
                return new MenuComandas(control);
            case INGREDIENTES:
                return new MenuIngredientes(control);
            case REGISTRO_INGREDIENTES:
                return new RegistroIngrediente(control);
            case VER_INGREDIENTES:
                return new VerIngredientes(control);  
            default:
                throw new IllegalArgumentException("Tipo de ventana no soportado: " + tipo);
        }
    }
}
