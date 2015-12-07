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

public class ProfessorPersistenceTest {
    
    public ProfessorPersistenceTest() {
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
     * Adiciona e executa os testes da classe ProfessorPersistence.
     * @author Lisa
     */     
    ProfessorPersistence instance = new ProfessorPersistence();
    Professor p1 = new Professor();
    Professor p2 = new Professor();
    Professor p3 = new Professor();
    @Test
    public void addTests() {
        System.out.println("Teste: ProfessorPersistence");
        testAddProfessor();
        testGetProfessorByName();
    }
    
    /**
     * Testa o método addProfessor.
     * Adiciona 3 à lista de Professores.
     */
    public void testAddProfessor() {
        System.out.println("- addProfessor");
        p1.setName("Professor 1");
        p2.setName("Professor 2");
        p3.setName("Professor 3");        
        instance.addProfessor(p1);
        instance.addProfessor(p2);
        instance.addProfessor(p3);
    }

    /**
     * Testa o método getProfessorByName.
     * Procura Pelo professor 2.
     */
    public void testGetProfessorByName() {
        System.out.println("- getProfessorByName");
        String professorName = "Professor 2";
        Professor expResult = p2;
        Professor result = instance.getProfessorByName(professorName);
        assertEquals(expResult, result);
    }
    
}
