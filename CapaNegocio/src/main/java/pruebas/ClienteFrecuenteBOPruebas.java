/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import BOs.ClienteFrecuenteBO;
import DTOs.NuevoClienteFrecuenteDTO;
import Exceptions.ClienteFrecuenteBOException;

/**
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteBOPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteFrecuenteBO clienteBO = ClienteFrecuenteBO.getInstanceBO();

        String nombre = "daniiel miribe";
        String telefono = "6621234515";
        String correo = "";

        try {
            NuevoClienteFrecuenteDTO clienteRegistrado = clienteBO.registrarClienteFrecuente(nombre, telefono, correo);

            System.out.println("Cliente registrado con exito:");
            System.out.println("Nombre: " + clienteRegistrado.getNombreCompleto());
            System.out.println("Telefono: " + clienteRegistrado.getNumeroTelefono());
            System.out.println("Correo: " + clienteRegistrado.getCorreo());
            System.out.println("Fecha registro: " + clienteRegistrado.getFechaRegistro());

        } catch (ClienteFrecuenteBOException e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
        }
    }

}
