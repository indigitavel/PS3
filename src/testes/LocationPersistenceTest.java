/*
 * Programação Sistemática - Universidade de Brasília
 * Trabalho 02
 * Autores:
 *      - Adriano Torres    11/0106032
 *      - Caio Oliveira     14/0176713
 *      - Leandro Faria     14/0178759
 *      - Lisa Evaldt       09/0093450
 */
package psproject2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocationPersistenceTest {
    
    public LocationPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Adiciona e executa os testes da classe LocationPersistence.
     * @author Lisa
     */
    LocationPersistence instance = new LocationPersistence();
    Location l1 = new Location();
    Location l2 = new Location();
    Location l3 = new Location();    
    @Test
    public void addTests() {
        System.out.println("Teste: LocationPersistence");
        testAddLocation();
        testGetLocationByName();
    }    
    
    /**
     * Testa o método addLocation.
     * Adiciona 3 à lista de Locais.
     */
    public void testAddLocation() {
        System.out.println("- addLocation");
        l1.setName("Local 1");
        l2.setName("Local 2");
        l3.setName("Local 3"); 
        instance.addLocation(l1);
        instance.addLocation(l2);
        instance.addLocation(l3);
    }

    /**
     * Testa o método getLocationByName.
     * Procura pelo Local 2.
     */
    public void testGetLocationByName() {
        System.out.println("- getLocationByName");
        String locationName = "Local 2";
        Location expResult = l2;
        Location result = instance.getLocationByName(locationName);
        assertEquals(expResult, result);
    }
   
}
