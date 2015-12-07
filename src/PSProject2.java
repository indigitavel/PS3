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

import java.util.Scanner;

/**
 * Projeto de Agendamento de Palestras, de acordo com listas previamente informadas de Locais, Professores e Palestras.
 * @author Leandro Faria
 */
public class PSProject2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filename;
        int n = 0, requirementsFail = 0;
        
        LocationReader locationReader = new LocationReader();
        LocationPersistence locationPersistence = new LocationPersistence();
        
        ProfessorReader professorReader = new ProfessorReader();
        ProfessorPersistence professorPersistence = new ProfessorPersistence();
        
        LectureReader lectureReader = new LectureReader();
        LecturePersistence lecturePersistence = new LecturePersistence();
        
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Por favor informe o caminho completo para o arquivo de locais:");
            filename = userInput.nextLine();
            n = locationReader.readFile(filename, locationPersistence);
            //locationPersistence.printLocationList();
            if (n == 0) {
                System.out.println("Nenhum local de palestra definido. Abortando execucao.");
                requirementsFail = 1;
            } else {
                System.out.println("Leitura OK! " + n + " Locais de palestra definidos.");            
            }
        } catch (InvalidFileFormatException e) {
            System.out.println(e.getMessage());
            requirementsFail = 1;
        }
        
        if (requirementsFail != 1) {
            try {
                Scanner userInput = new Scanner(System.in);
                System.out.println("Por favor informe o caminho completo para o arquivo de Professores:");
                filename = userInput.nextLine();
                n = professorReader.readFile(filename, professorPersistence);
                //professorPersistence.printProfessorList();
                if (n == 0) {
                    System.out.println("Nenhum Professor definido. Abortando execucao.");
                    requirementsFail = 1;
                } else {
                    System.out.println("Leitura OK! " + n + " Professores definidos.");            
                }
            } catch (InvalidFileFormatException e) {
                System.out.println(e.getMessage());
                requirementsFail = 1;
            }
        }
        
        if (requirementsFail != 1) {
            try {
                Scanner userInput = new Scanner(System.in);
                System.out.println("Por favor informe o caminho completo para o arquivo de palestras:");
                filename = userInput.nextLine();
                n = lectureReader.readFile(filename, professorPersistence, locationPersistence, lecturePersistence);
                //lecturePersistence.printLectureList();
                if (n == 0) {
                    System.out.println("Nenhuma palestra definida. Abortando execucao.");
                    requirementsFail = 1;
                } else {
                    System.out.println("Leitura OK! " + n + " Palestra definidas.");
                }
            } catch (InvalidFileFormatException e) {
                System.out.println(e.getMessage());
                requirementsFail = 1;
            } catch (InvalidDataMentionException e) {
                System.out.println(e.getMessage());
                requirementsFail = 1;
            }
        }
        
        if (requirementsFail != 1) {
            LectureCalendar lectureCalendar = new LectureCalendar();
            lectureCalendar.createLectureCalendar(professorPersistence, locationPersistence, lecturePersistence);
            System.out.println("");
            lectureCalendar.printCalendar();
        }
    }
    
}
