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

public class LectureCalendarTest {
    
    public LectureCalendarTest() {
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
     * Adiciona e executa os testes da classe LectureCalendar.
     * @author Lisa
     */
    LectureCalendar instance = new LectureCalendar();
    @Test
    public void addTests() {
        System.out.println("Teste: LectureCalendar");
        testCreateLectureCalendar();
    }
    /**
     * Testa o método createLectureCalendar da classe LectureCalendar.
     * Criar o calendário com professores, locais e palestras.
     */
    public void testCreateLectureCalendar() {
        System.out.println("- createLectureCalendar");

        /**
        * Cria um arquivo de professores para teste.
        */ 
        ProfessorPersistence professorsPersistence = new ProfessorPersistence();
        Professor professor = new Professor();
        professor.setName("Professor 1");
        professorsPersistence.addProfessor(professor);

        /**
        * Cria um arquivo de locais para teste.
        */          
        LocationPersistence locationPersistence = new LocationPersistence();
        Location location = new Location();
        location.setName("Local 1");
        locationPersistence.addLocation(location);

        /**
        * Cria um arquivo de palestras para teste.
        */          
        LecturePersistence lecturePersistence = new LecturePersistence();
        Lecture lecture = new Lecture();
        lecture.setName("Lecture 1");
        lecture.setSetup(true);        
        lecturePersistence.addLecture(lecture);
        
        /**
        * Testa a criacao de um calendario.
        */        
        instance.createLectureCalendar(professorsPersistence, locationPersistence, lecturePersistence);
    }
    
}
