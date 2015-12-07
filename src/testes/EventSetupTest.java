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

public class EventSetupTest {
    
    public EventSetupTest() {
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
     * Adiciona e Executa os testes da classe EventSetup.
     * @author Lisa
     */
    EventSetup instance = new EventSetup(2015,11,10,600,null);
    @Test
    public void addTests() {
        System.out.println("Teste: EventSetup");
        testGetYear();
        testGetMonth();
        testGetDay();
        testGetStartMin();
        testGetLecture();
    }
    /**
     * Testa o método getYear.
     */
    public void testGetYear() {
        System.out.println("- getYear");
        int expResult = 2015;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método getMonth.
     */
    public void testGetMonth() {
        System.out.println("- getMonth");
        int expResult = 11;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método getDay.
     */
    public void testGetDay() {
        System.out.println("- getDay");
        int expResult = 10;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método getStartMin.
     */
    public void testGetStartMin() {
        System.out.println("- getStartMin");
        int expResult = 600;
        int result = instance.getStartMin();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método getLecture.
     */
    public void testGetLecture() {
        System.out.println("- getLecture");
        Lecture expResult = null;
        Lecture result = instance.getLecture();
        assertEquals(expResult, result);
    }
    
}
