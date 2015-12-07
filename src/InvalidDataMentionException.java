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
 * Exceção de menção inválida de dado. Lançada quando alguma palestra/professor é mencionado sem ter sido previamente definido no arquivo texto.
 * @author Leandro Faria
 */
class InvalidDataMentionException extends Exception {
    String msg;
    
    public void setMessage(String msg) {
        this.msg = msg;
    }
    
    public String getMessage() {
        return this.msg;
    }
}
