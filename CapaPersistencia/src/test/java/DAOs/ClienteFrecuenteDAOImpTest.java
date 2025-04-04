/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para ClienteFrecuenteDAOImp. Se encarga de
 * verificar el correcto funcionamiento del acceso a datos para clientes
 * frecuentes.
 *
 * @author Daniel Miribe
 */
public class ClienteFrecuenteDAOImpTest {

    private ClienteFrecuenteDAOImp dao;
    private ClienteFrecuente clientePrueba;

    /**
     * Este metodo se ejecuta antes de cada prueba. Se inicializa el DAO y se
     * registra un cliente de prueba.
     *
     * @throws Exception si ocurre un error durante el registro
     */
    @BeforeEach
    public void setUp() throws Exception {
        dao = ClienteFrecuenteDAOImp.getInstanceDAO();

        clientePrueba = new ClienteFrecuente();
        clientePrueba.setNombreCompleto("Ramoncito Classic");
        clientePrueba.setNumeroTelefono("6621234567");
        clientePrueba.setCorreo("ramensito@gmail.com");
        clientePrueba.setFechaRegistro(LocalDateTime.now());
        clientePrueba.setPuntosDeFidelidad(0);

        dao.registrarClienteFrecuente(clientePrueba);
    }

    /**
     * Este metodo se ejecuta despues de cada prueba. Se eliminan todos los
     * registros de clientes para evitar conflictos.
     *
     * @throws Exception si ocurre un error durante la limpieza
     */
    @AfterEach
    public void tearDown() throws Exception {
        EntityManager em = Conexion.crearConexion();

        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM ClienteFrecuente").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Prueba que verifica que la instancia del DAO no sea null.
     */
    @Test
    public void testGetInstanceDAO() {
        ClienteFrecuenteDAOImp instance = ClienteFrecuenteDAOImp.getInstanceDAO();
        assertNotNull(instance, "La instancia DAO no deberia ser null.");
    }

    /**
     * Prueba para verificar que un cliente nuevo se registre correctamente.
     *
     * @throws Exception si ocurre un error durante el registro
     */
    @Test
    public void testRegistrarClienteFrecuente() throws Exception {
        ClienteFrecuente nuevoCliente = new ClienteFrecuente();
        nuevoCliente.setNombreCompleto("Rodri Classic");
        nuevoCliente.setNumeroTelefono("6629876543");
        nuevoCliente.setCorreo("rodrigogo@gmail.com");
        nuevoCliente.setFechaRegistro(LocalDateTime.now());
        nuevoCliente.setPuntosDeFidelidad(100);

        ClienteFrecuente resultado = dao.registrarClienteFrecuente(nuevoCliente);

        assertNotNull(resultado);
        assertEquals("Rodri Classic", resultado.getNombreCompleto());
        String telefonoDesencriptado = UtileriasPersistencia.EncriptadorAES.desencriptar(resultado.getNumeroTelefono());
        assertEquals("6629876543", telefonoDesencriptado);
    }

    /**
     * Prueba que verifica que se obtengan todos los clientes registrados.
     *
     * @throws Exception si ocurre un error al buscar los clientes
     */
    @Test
    public void testBuscarTodos() throws Exception {
        List<ClienteFrecuente> clientes = dao.buscarTodos();
        assertNotNull(clientes, "La lista de clientes no deberia ser null.");
        assertTrue(clientes.size() > 0, "Deberia haber al menos un cliente en la lista.");
    }

    /**
     * Prueba para buscar un cliente por su nombre.
     *
     * @throws Exception si ocurre un error durante la busqueda
     */
    @Test
    public void testBuscarPorNombre() throws Exception {
        ClienteFrecuente resultado = dao.buscarPorNombre("Ramoncito Classic");
        assertNotNull(resultado, "El cliente no fue encontrado por nombre.");
        assertEquals("ramensito@gmail.com", resultado.getCorreo());
    }

    /**
     * Prueba para buscar un cliente por su numero de telefono.
     *
     * @throws Exception si ocurre un error durante la busqueda
     */
    @Test
    public void testBuscarPorTelefono() throws Exception {
        ClienteFrecuente resultado = dao.buscarPorTelefono("6621234567");
        assertNotNull(resultado, "El cliente no fue encontrado por telefono.");
        assertEquals("Ramoncito Classic", resultado.getNombreCompleto());
    }

    /**
     * Prueba para buscar un cliente por su correo electronico.
     *
     * @throws Exception si ocurre un error durante la busqueda
     */
    @Test
    public void testBuscarPorCorreo() throws Exception {
        ClienteFrecuente resultado = dao.buscarPorCorreo("ramensito@gmail.com");
        assertNotNull(resultado, "El cliente no fue encontrado por correo.");
        String telefonoDesencriptado = UtileriasPersistencia.EncriptadorAES.desencriptar(resultado.getNumeroTelefono());
        assertEquals("6621234567", telefonoDesencriptado);
    }

}
