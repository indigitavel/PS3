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

/**
 * Evento Configurado. Palestra com dia definido. Cada Evento Configurado será armazenado em uma lista do Calendário.
 * @author Leandro Faria
 */
public class EventSetup {
    private int year;
    private int month;
    private int day;
    private int startMin;
    private Lecture lecture;
    
    /**
     * Construtor do novo evento configurado e definido (Palestra).
     * @param year Ano.
     * @param month Mês.
     * @param day Dia.
     * @param startMin Horário em minutos correspondente ao início da palestra.
     * @param lecture Palestra a ser realizada.
     */
    public EventSetup(int year, int month, int day, int startMin, Lecture lecture) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.startMin = startMin;
        this.lecture = lecture;
    }
    
    /**
     * Método que retorna o ano do evento definido.
     * @return Inteiro que representa o ano definido.
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     * Método que retorna o mês do evento definido.
     * @return Inteiro que representa o mês definido.
     */
    public int getMonth() {
        return this.month;
    }
    
    /**
     * Método que retorna o dia do evento definido.
     * @return Inteiro que representa o dia definido.
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * Método que retorna o horário de início do evento definido.
     * @return Inteiro que representa o horário de início do evento definido.
     */
    public int getStartMin() {
        return this.startMin;
    }
    
    /**
     * Método que retorna a palestra definida para aquele dia.
     * @return A palestra.
     */
    public Lecture getLecture() {
        return this.lecture;
    }
}
