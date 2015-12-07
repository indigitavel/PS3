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

public class DisponibilityTest {
    
    public DisponibilityTest() {
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
     * Adiciona e executa os testes da classe Disponibility.
     * @author Lisa
     */     
    Disponibility instance = new Disponibility(); 
    @Test
    public void addTests() {
        System.out.println("Teste: Disponibility");
        testPopulateData();
        testGetStartTime();
        testMatch();
    }
    /**
     * Testa o método que preenche os dados referentes à disponilidade.
     * String info: A string que contém toda e qualquer informação a respeito desta disponibilidade.
     */   
    public void testPopulateData() {
        System.out.println("- populateData");
        String info = "Ter, 10/11/2015, 10:00-12:00";
        instance.populateData(info);
    }

    /**
     * Testa o horário de início da disponibilidade.
     * expResult: Inteiro representando em minutos o horário de início da disponibilidade.
     */
    public void testGetStartTime() {
        System.out.println("- getStartTime");
        int expResult = 600;
        int result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Testa o método match que verifica se a disponibilidade desejada bate com a disponibilidade existente.
     */
    public void testMatch() {
        System.out.println("- match");
        int year = 2015;
        int month = 10; /* O mês da classe Calendário começa em zero */
        int day = 10;
        int dayOfWeek = 3;
        int howLong = 120;
        boolean expResult = true;
        boolean result = instance.match(year, month, day, dayOfWeek, howLong);
        assertEquals(expResult, result);
    }

}
