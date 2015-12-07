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

public class LectureTest {
    
    public LectureTest() {
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
     * Adiciona e Executa os testes da classe Lecture.
     * @author Lisa
     */
    Lecture instance = new Lecture();
    @Test
    public void addTests() {
        System.out.println("Teste: Lecture");
        testSetName();
        testGetName();
        testSetTopic();
        testGetTopic();
        testSetProfessor();
        testGetProfessor();
        testSetLocation();
        testGetLocation();
        testSetDuration();
        testGetDuration();
        testSetSetup();
        testGetSetup();
    }    
    /**
     *  Testa o método getName.
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
     * Testa o método getTopic.
     */
    public void testGetTopic() {
        System.out.println("- getTopic");
        String expResult = ("Java").toUpperCase();
        String result = instance.getTopic();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setTopic.
     */
    public void testSetTopic() {
        System.out.println("- setTopic");
        String topic = "Java";
        instance.setTopic(topic);
    }

    /**
     * Testa o método getProfessor.
     * A classe professor será testada separadamento, por isso usamos null
     */
    public void testGetProfessor() {
        System.out.println("- getProfessor");
        Professor expResult = null;
        Professor result = instance.getProfessor();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setProfessor.
     * A classe Professor será testada separadamento, por isso usamos null
     */
    public void testSetProfessor() {
        System.out.println("- setProfessor");
        Professor professor = null;
        instance.setProfessor(professor);
    }

    /**
     * Testa o método getLocation.
     * A classe Location será testada separadamento, por isso usamos null
     */
    public void testGetLocation() {
        System.out.println("- getLocation");
        Location expResult = null;
        Location result = instance.getLocation();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setLocation.
     * A classe Location será testada separadamento, por isso usamos null
     */
    public void testSetLocation() {
        System.out.println("- setLocation");
        Location location = null;
        instance.setLocation(location);
    }

    /**
     * Testa o método getDuration.
     */
    public void testGetDuration() {
        System.out.println("- getDuration");
        int expResult = 120;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setDuration.
     */
    public void testSetDuration() {
        System.out.println("- setDuration");
        int duration = 120;
        instance.setDuration(duration);
    }

    /**
     * Testa o método getSetup.
     */
    public void testGetSetup() {
        System.out.println("- getSetup");
        boolean expResult = false;
        boolean result = instance.getSetup();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método setSetup.
     */
    public void testSetSetup() {
        System.out.println("- setSetup");
        boolean setup = false;
        instance.setSetup(setup);
    }
    
}
