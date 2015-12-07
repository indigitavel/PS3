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
 * Persistência dos Professores, mantidos em uma ArrayList, e métodos de manutenção desta lista.
 * @author Leandro Faria
 */
public class ProfessorPersistence {
    private ArrayList<Professor> professorList = new ArrayList<>();
    
    /**
     * Método que adiciona um Professor à lista de Professores.
     * @param professor Professor a ser adicionado.
     */
    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }
    
    /**
     * Método que busca um Professor pelo nome e o retorna.
     * @param professorName O nome do Professor que está sendo buscado.
     * @return Retorna o Professor que possui como atributo o nome passado.
     */
    public Professor getProfessorByName(String professorName) {
        Professor prof = null;
        professorName = professorName.toUpperCase();
        for (Professor p : this.professorList) {
            if (p.getName().equals(professorName)) {
                prof = p;
            }
        }
        return prof;
    }
    
    /**
     * Método para fins de debug, que imprime a lista de Professores.
     */
    public void printProfessorList() {
        System.out.println("Professores Definidos:");
        for (Professor p : professorList) {
            p.printProfessor();
        }
    }
}
