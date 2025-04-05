package DAOs;

import Enums.Tipo;
import conexion.Conexion;
import entidades.Producto;
import exception.ProductoException;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la implementacion del DAO de Producto.
 * Estas pruebas verifican el correcto funcionamiento de los metodos principales del DAO.
 * Se usa MySQL como base de datos y se limpian los datos al finalizar cada prueba.
 */
public class ProductoDAOImpTest {

    private ProductoDAOImp productoDAO;

    /**
     * Se ejecuta antes de cada prueba para obtener la instancia del DAO.
     */
    @BeforeEach
    public void setUp() {
        productoDAO = ProductoDAOImp.getInstance();
    }

    /**
     * Se ejecuta despues de cada prueba para eliminar todos los productos registrados
     * y dejar la base de datos en un estado limpio.
     */
    @AfterEach
    public void tearDown() {
        EntityManager em = Conexion.crearConexion();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Producto p").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Prueba que verifica que el metodo getInstance retorna siempre la misma instancia
     * (patron Singleton).
     */
    @Test
    public void testGetInstance() {
        ProductoDAOImp dao1 = ProductoDAOImp.getInstance();
        ProductoDAOImp dao2 = ProductoDAOImp.getInstance();
        assertNotNull(dao1);
        assertSame(dao1, dao2, "Debe ser la misma instancia (singleton)");
    }

    /**
     * Prueba que verifica si un producto puede ser registrado correctamente en la base de datos.
     * @throws ProductoException si ocurre un error al registrar el producto
     */
    @Test
    public void testRegistrarProducto() throws ProductoException {
        Producto nuevoProducto = new Producto("ProductoTest1", 50.00, Tipo.Postre);
        Producto registrado = productoDAO.registrarProducto(nuevoProducto);

        assertNotNull(registrado);
        assertNotNull(registrado.getId());
        assertEquals("ProductoTest1", registrado.getNombre());
    }

    /**
     * Prueba que verifica la busqueda de un producto por su nombre.
     * @throws ProductoException si ocurre un error en la busqueda
     */
    @Test
    public void testBuscarPorNombre() throws ProductoException {
        Producto producto = new Producto("ProductoTest2", 30.00, Tipo.Bebida);
        productoDAO.registrarProducto(producto);

        Producto encontrado = productoDAO.buscarPorNombre("ProductoTest2");

        assertNotNull(encontrado);
        assertEquals("ProductoTest2", encontrado.getNombre());
    }

    /**
     * Prueba que verifica la obtencion de todos los productos registrados en la base de datos.
     * @throws ProductoException si ocurre un error al obtener los productos
     */
    @Test
    public void testBuscarTodos() throws ProductoException {
        productoDAO.registrarProducto(new Producto("ProductoTest3", 15.00, Tipo.Bebida));
        productoDAO.registrarProducto(new Producto("ProductoTest4", 22.00, Tipo.Platillo));

        List<Producto> lista = productoDAO.buscarTodos();

        assertNotNull(lista);
        assertTrue(lista.size() >= 2);
    }
}
