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
 * Palestra. Possui campos para identificar cada variável referente à palestra.
 * @author Leandro Faria
 */
public class Lecture {
    private String name;
    private String topic;
    private Professor professor;
    private Location location;
    private int duration;
    private boolean setup;
    
    public Lecture() {
        this.setup = false;
    }
    
    /**
     * Método que retorna o nome da palestra em questão.
     * @return Retorna o nome da palestra.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Método que define o nome da palestra em questão.
     * @param name O nome a ser setado para a palestra.
     */
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    /**
     * Método que retorna o tópico da palestra em questão.
     * @return Retorna o tópico da palestra.
     */
    public String getTopic() {
        return this.topic;
    }
    
    /**
     * Método que define o tópico da palestra em questão.
     * @param topic O tópico a ser setado para a palestra.
     */
    public void setTopic(String topic) {
        this.topic = topic.toUpperCase();
    }
    
    /**
     * Método que retorna o Professor da palestra em questão.
     * @return Retorna o Professor da palestra.
     */
    public Professor getProfessor() {
        return this.professor;
    }
    
    /**
     * Método que define o Professor da palestra em questão.
     * @param professor O Professor a ser setado para a palestra.
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    /**
     * Método que retorna a localização da palestra em questão.
     * @return Retorna a localização da palestra.
     */
    public Location getLocation() {
        return this.location;
    }
    
    /**
     * Método que define a localização da palestra em questão.
     * @param location A localização a ser setada para a palestra.
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
    /**
     * Método que retorna a duração da palestra em questão.
     * @return Retorna a duração da palestra.
     */
    public int getDuration() {
        return this.duration;
    }
    
    /**
     * Método que define a duração da palestra em questão.
     * @param duration A duração a ser setada para a palestra.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    /**
     * Método que retorna se a palestra já foi marcada no calendário.
     * @return Boolean que define se a palestra já foi marcada no calendário.
     */
    public boolean getSetup() {
        return this.setup;
    }
    
    /**
     * Método que define se a palestra já foi marcada no calendário.
     * @param setup Boolean que define se a palestra já foi marcada no calendário.
     */
    public void setSetup(boolean setup) {
        this.setup = setup;
    }
    
    /**
     * Método para fins de debug, que imprime as informações da palestra em questão.
     */
    public void printLecture() {
        System.out.println("Nome: " + this.name);
        System.out.println("Topico: " + this.topic);
        System.out.println("Palestrante: " + this.professor.getName());
        System.out.println("Local: " + this.location.getName());
        System.out.println("Duracao: " + this.duration + " minutos");
        System.out.println("");
    }
}
