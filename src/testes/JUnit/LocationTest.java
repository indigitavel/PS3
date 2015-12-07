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

public class LocationTest {
    
    public LocationTest() {
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
     * Adiciona e executa os testes da classe Location.
     * @author Lisa
     */     
    Location instance = new Location();
    @Test
    public void addTests() {
        System.out.println("Teste: Location");
        testSetName();
        testGetName();
    }
    
    /**
     * Testa o método getName.
     */
    public void testGetName() {
        System.out.println("- getName");
        String expResult = "BSS 302";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setName.
     */
    public void testSetName() {
        System.out.println("- setName");
        String name = "BSS 302";
        instance.setName(name);
    }
   
}
