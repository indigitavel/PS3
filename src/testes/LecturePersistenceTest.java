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

public class LecturePersistenceTest {
    
    public LecturePersistenceTest() {
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
     * Adiciona e executa os testes da classe LecturePersistence.
     * @author Lisa
     */     
    LecturePersistence instance = new LecturePersistence();
    Lecture lec1 = new Lecture();
    Lecture lec2 = new Lecture();
    Lecture lec3 = new Lecture();
    @Test
    public void addTests() {
        System.out.println("Teste: LecturePersistence");
        testAddLecture();
        testGetUnsetLecture();
    }
    
    /**
     * Testa o método addLecture.
     * Adiciona 3 à lista de Lectures.
     */
    public void testAddLecture() {
        System.out.println("- addLecture");
        lec1.setName("Lecture 1");
        lec1.setSetup(true);
        lec2.setName("Lecture 2");
        lec2.setSetup(false);
        lec3.setName("Lecture 3");
        lec3.setSetup(true);
        instance.addLecture(lec1);
        instance.addLecture(lec2);
        instance.addLecture(lec3);
    }

    /**
     * Testa o método getUnsetLecture.
     * Testa uma palestra que ainda não foi marcada no calendário
     */
    public void testGetUnsetLecture() {
        System.out.println("- getUnsetLecture");
        Lecture expResult = lec2;
        Lecture result = instance.getUnsetLecture();
        assertEquals(expResult, result);
    }
    
}
