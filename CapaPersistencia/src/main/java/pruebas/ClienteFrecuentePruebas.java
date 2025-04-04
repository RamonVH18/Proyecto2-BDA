/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import DAOs.ClienteFrecuenteDAOImp;
import entidades.ClienteFrecuente;
import exception.ClienteFrecuenteException;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel M
 */
public class ClienteFrecuentePruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteFrecuenteDAOImp clienteFrecuenteDAO = ClienteFrecuenteDAOImp.getInstanceDAO();
        try {
            
            ClienteFrecuente clienteFrecuente1 = new ClienteFrecuente("Abraham Coronel Lerma", "6442324156", "aCL@gmail.com", LocalDateTime.now(), 5, 1932.23, 96);
            ClienteFrecuente clienteFrecuente2 = new ClienteFrecuente("Ramon Lerma Bringas", "6441211232", "rLB@gmail.com", LocalDateTime.now(), 3, 1212.12, 67);
            ClienteFrecuente clienteFrecuente3 = new ClienteFrecuente("Sebastian Tovar Valencia", "6441339120", "sTV@gmail.com", LocalDateTime.now(), 6, 2112.31, 106);
            
            clienteFrecuenteDAO.registrarClienteFrecuente(clienteFrecuente1);
            clienteFrecuenteDAO.registrarClienteFrecuente(clienteFrecuente2);
            clienteFrecuenteDAO.registrarClienteFrecuente(clienteFrecuente3);
            
            System.out.println("Cliente 1: " + clienteFrecuente1);
            System.out.println("\nCliente 2: " + clienteFrecuente2);
            System.out.println("\nCliente 3: " + clienteFrecuente3);

        } catch (ClienteFrecuenteException e) {
            System.err.println("Ocurrio un error durante la prueba: " + e.getMessage());
        }
    }

}
