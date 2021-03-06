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

public class LocationReaderTest {
    
    public LocationReaderTest() {
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
     * Adiciona e executa os testes da classe LocationReader.
     * @author Lisa
     */     
    @Test
    public void addTests() {
        System.out.println("Teste: LocationReader");        
        try {
            testReadFile();
        } catch (Exception e) {
            System.out.println("- " + e.toString());
        }     
    }      
    
    /**
     * Testa o metodo readFile.
     * @throws Exceção lançada quando o formato do arquivo de Locais não corresponde ao esperado.
     */
    public void testReadFile() throws Exception {
        System.out.println("- readFile");
        String filename = "bin\\Locais.txt"; 
        LocationPersistence locationPersistence = new LocationPersistence();
        LocationReader instance = new LocationReader();
        int expResult = 3;
        int result = instance.readFile(filename, locationPersistence);
        assertEquals(expResult, result);
    }
    
}
