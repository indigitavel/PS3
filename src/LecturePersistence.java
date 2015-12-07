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

/**
 * Persistência das palestras, mantidas em uma ArrayList, e métodos de manutenção desta lista.
 * @author Leandro Faria
 */
public class LecturePersistence {
    private ArrayList<Lecture> lectureList = new ArrayList<>();
    
    /**
     * Método que adiciona uma palestra à lista de palestras.
     * @param lecture Palestra a ser adicionada.
     */
    public void addLecture(Lecture lecture) {
        lectureList.add(lecture);
    }
    
    /**
     * Método que retorna uma palestra que ainda não foi marcada no calendário.
     * @return Uma palestra ainda não marcada no calendário.
     */
    public Lecture getUnsetLecture() {
        Lecture lecture = null;
        for (Lecture l : this.lectureList) {
            if (l.getSetup() == false) {
                lecture = l;
                return lecture;
            }
        }
        return lecture;
    }
    
    /**
     * Método para fins de debug, que imprime a lista de palestras.
     */
    public void printLectureList() {
        System.out.println("Palestras Definidas:");
        for (Lecture l : lectureList) {
            l.printLecture();
        }
    }
}
