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

public class LectureReaderTest {
    
    public LectureReaderTest() {
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
     * Adiciona e executa os testes da classe LectureReader.
     * @author Lisa
     */     
    @Test
    public void addTests() {
        System.out.println("Teste: LectureReader");        
        try {
            testReadFile();
        } catch (Exception e) {
            System.out.println("- " + e.toString());
        }     
    }      
    
    /**
     * Testa o metodo readFile.
     * @throws Exceção lançada quando o formato do arquivo de Palestras não corresponde ao esperado.
     */
    public void testReadFile() throws Exception {
        System.out.println("- readFile");
        String filename = "bin\\Palestras.txt";
        
        /**
        * Cria um arquivo de professores para teste.
        */        
        ProfessorPersistence professorPersistence = new ProfessorPersistence();
        Professor p1 = new Professor();
        Professor p2 = new Professor();
        p1.setName("Leandro Faria");
        p2.setName("Caio Oliveira");
        professorPersistence.addProfessor(p1);
        professorPersistence.addProfessor(p2); 
        
        /**
        * Cria um arquivo de locais para teste.
        */          
        LocationPersistence locationPersistence = new LocationPersistence();
        Location l1 = new Location();
        Location l2 = new Location();
        l1.setName("Sala Multiuso CIC");
        l2.setName("Anfiteatro 4");
        locationPersistence.addLocation(l1);
        locationPersistence.addLocation(l2);
        
        /**
        * Testa o arquivo de teste Palestras.
        */          
        LecturePersistence lecturePersistence = new LecturePersistence();
        LectureReader instance = new LectureReader();
        int expResult = 2;
        int result = instance.readFile(filename, professorPersistence, locationPersistence, lecturePersistence);
        assertEquals(expResult, result);
    }
    
}
