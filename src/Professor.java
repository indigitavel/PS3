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
 * Palestrante/Professor. Possui campos para identificar cada variável referente ao Professor.
 * @author Leandro Faria
 */
public class Professor {
    private String name;
    private ArrayList<Disponibility> disponibilities = new ArrayList<>();
    
    /**
     * Método que retorna o nome do Professor em questão.
     * @return Retorna um String representando o nome do Professor.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Método que define o nome do Professor em questão.
     * @param name O nome a ser setado para o Professor.
     */
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    /**
     * Método que adiciona uma disponilidade à lista de disponibilidades do Professor em questão.
     * @param disponibility A disponibilidade a ser acrescentada.
     */
    public void addDisponibility(Disponibility disponibility) {
        disponibilities.add(disponibility);
    }
    
    /**
     * Método que retorna se há ou não disponibilidade do Professor para aquele dia e horário.
     * @param year Ano.
     * @param month Mês.
     * @param day Dia.
     * @param dayOfWeek Dia da semana.
     * @param howLong Por quanto tempo o Professor precisa estar disponível.
     * @return Retorna um inteiro representando em minutos o início do horário de disponibilidade do Professor.
     */
    public int getAvailability(int year, int month, int day, int dayOfWeek, int howLong) {
        for (Disponibility d : disponibilities) {
            if (d.match(year, month, day, dayOfWeek, howLong)) {
                return d.getStartTime();
            }
        }
        return -1;
    }
    
    /**
     * Método para fins de debug, que imprime as informações do Professor em questão.
     */
    public void printProfessor() {
        System.out.println("Nome: " + this.name);
        System.out.println("Disponibilidade: ");
        for (Disponibility d : this.disponibilities) {
            d.printDisponibility();
        }
        System.out.println("");
    }
}
