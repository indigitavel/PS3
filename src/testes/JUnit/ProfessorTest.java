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

public class ProfessorTest {
    
    public ProfessorTest() {
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
     * Adiciona e executa os testes da classe Professor.
     * @author Lisa
     */     
    Professor instance = new Professor(); 
    @Test
    public void addTests() {
        System.out.println("Teste: Professor");
        testSetName();
        testGetName();
        testAddDisponibility();
        testGetAvailability();
    }
    
    /**
     * Testa o método getName.
     */
    public void testGetName() {
        System.out.println("- getName");
        String expResult = ("Professor Pardal").toUpperCase();
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setName.
     */
    public void testSetName() {
        System.out.println("- setName");
        String name = "Professor Pardal";
        instance.setName(name);
    }

    /**
     * Testa o método addDisponibility.
     * Adiciona uma disponilidade à lista de disponibilidades do Professor
     */
    public void testAddDisponibility() {
        System.out.println("- addDisponibility");
        Disponibility disponibility = new Disponibility();
        String info = "Ter, 10/11/2015, 10:00-12:00";
        disponibility.populateData(info);        
        instance.addDisponibility(disponibility);
    }

    /**
     * Testa o método getAvailability.
     */
    public void testGetAvailability() {
        System.out.println("- getAvailability");
        int year = 2015;
        int month = 10; /* O mês da classe Calendário começa em zero */
        int day = 10;
        int dayOfWeek = 3;
        int howLong = 120;
        int expResult = 600;
        int result = instance.getAvailability(year, month, day, dayOfWeek, howLong);
        assertEquals(expResult, result);
    }
    
}
