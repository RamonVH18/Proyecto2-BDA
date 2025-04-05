package DAOs;

import conexion.Conexion;
import entidades.Ingrediente;
import entidades.IngredienteProducto;
import entidades.Producto;
import Enums.Tipo;
import Enums.Unidad;
import exception.IngredienteProductoException;
import org.junit.jupiter.api.*;
import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para IngredienteProductoDAOImp
 * Prueba las operaciones registrar, eliminar y singleton
 */
public class IngredienteProductoDAOImpTest {

    private IngredienteProductoDAOImp ingredienteProductoDAO;
    private Producto productoTest;
    private Ingrediente ingredienteTest;

    @BeforeEach
    public void setUp() {
        ingredienteProductoDAO = IngredienteProductoDAOImp.getInstance();

        // Creamos producto e ingrediente dummy para pruebas
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();

        productoTest = new Producto("ProductoTestIP", 40, Tipo.Platillo, true);
        ingredienteTest = new Ingrediente("IngredienteTest", Unidad.PIEZA, 20.00);

        em.persist(productoTest);
        em.persist(ingredienteTest);

        em.getTransaction().commit();
        em.close();
    }

    @AfterEach
    public void tearDown() {
        // Elimina todo lo creado (ingredientesProducto, producto, ingrediente)
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();

        em.createQuery("DELETE FROM IngredienteProducto").executeUpdate();
        em.createQuery("DELETE FROM Producto p WHERE p.nombre = 'ProductoTestIP'").executeUpdate();
        em.createQuery("DELETE FROM Ingrediente i WHERE i.nombre = 'IngredienteTest'").executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    /**
     * Prueba que getInstance retorna siempre la misma instancia
     */
    @Test
    public void testGetInstance() {
        IngredienteProductoDAOImp dao1 = IngredienteProductoDAOImp.getInstance();
        IngredienteProductoDAOImp dao2 = IngredienteProductoDAOImp.getInstance();

        assertNotNull(dao1);
        assertSame(dao1, dao2, "Debe devolver la misma instancia (singleton)");
    }

    /**
     * Prueba que se puede registrar un IngredienteProducto
     */
    @Test
    public void testRegistrarIngredienteProducto() throws IngredienteProductoException {
        IngredienteProducto ip = new IngredienteProducto(5, productoTest, ingredienteTest);

        IngredienteProducto registrado = ingredienteProductoDAO.registrarIngredienteProducto(ip);

        assertNotNull(registrado);
        assertNotNull(registrado.getId());
        assertEquals(5, registrado.getCantidad());
    }

    /**
     * Prueba que se puede eliminar un IngredienteProducto por id
     */
    @Test
    public void testEliminarIngredienteProducto() throws IngredienteProductoException {
        IngredienteProducto ip = new IngredienteProducto(3, productoTest, ingredienteTest);
        IngredienteProducto registrado = ingredienteProductoDAO.registrarIngredienteProducto(ip);

        boolean eliminado = ingredienteProductoDAO.eliminarIngredienteProducto(registrado.getId());

        assertTrue(eliminado);
    }

    /**
     * Prueba crearConexion (solo cobertura, no debe lanzar excepcion)
     */
    @Test
    public void testCrearConexion() {
        assertDoesNotThrow(() -> ingredienteProductoDAO.crearConexion());
    }

    /**
     * Prueba cerrarConexion (solo cobertura, no debe lanzar excepcion)
     */
    @Test
    public void testCerrarConexion() {
        assertDoesNotThrow(() -> ingredienteProductoDAO.cerrarConexion());
    }
}
