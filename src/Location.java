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
 * Local. Possui campos para identificar cada variável referente ao local.
 * @author Leandro Faria
 */
public class Location {
    String name;
    
    /**
     * Método que retorna o nome do local em questão.
     * @return Retorna o nome do local.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Método que define o nome do local em questão.
     * @param name O nome a ser setado para o local.
     */
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    /**
     * Método para fins de debug, que imprime a disponibilidade.
     */
    public void printLocation() {
        System.out.println("Nome: " + this.name);
        System.out.println("");
    }
}
