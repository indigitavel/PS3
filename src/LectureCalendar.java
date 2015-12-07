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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Calendário. Módulo responsável por controlar e designar as palestras nas datas e locais disponíveis.
 * @author Leandro Faria
 */
public class LectureCalendar {
    private ArrayList<EventSetup> events = new ArrayList<>();
    
    /**
     * Com todos os dados lidos, este método é responsável por criar o calendário, evitando choque de datas.
     * @param professorsPersistence Instância de persistência dos Professores.
     * @param locationPersistence Instância de persistência dos locais de palestra.
     * @param lecturePersistence Instância de persistência das palestras.
     */
    public void createLectureCalendar(ProfessorPersistence professorsPersistence, LocationPersistence locationPersistence, LecturePersistence lecturePersistence) {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        /* Seta o Calendário de Palestras para começar no dia seguinte. */
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH) + 1);
        
        Lecture lecture = null;
        while ((lecture = lecturePersistence.getUnsetLecture()) != null) {
            /* Temos uma palestra a ser marcada no calendário. */
            /* Verificar se o professor está disponível para o próximo dia do calendário. */
            /* Caso contrário, tentar outra palestra. Apenas uma palestra será marcada por dia. */
            if (lecture.getProfessor().getAvailability(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.DAY_OF_WEEK), lecture.getDuration()) != -1) {
                events.add(new EventSetup(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH), lecture.getProfessor().getAvailability(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.DAY_OF_WEEK), lecture.getDuration()), lecture));
                lecture.setSetup(true);
            }
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH) + 1);
            /* Reseta a palestra para próxima iteração do while. */
            lecture = null;
        }
        /* Já marcamos todas as palestras da lista. */
    }
    
    /**
     * Método que imprime o calendário de palestras marcadas.
     */
    public void printCalendar() {
        System.out.println("#############################");
        System.out.println("## Calendario de Palestras ##");
        System.out.println("#############################");
        System.out.println();
        for (EventSetup e : this.events) {
            System.out.println("Data: " + e.getDay() + "/" + e.getMonth() + "/" + e.getYear());
            System.out.println("Palestra com inicio as: " + (e.getStartMin()/60) + ":" + String.format("%02d", e.getStartMin()%60));
            e.getLecture().printLecture();
        }
    }
}
