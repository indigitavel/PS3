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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe de leitura dos locais de palestra.
 * @author Leandro Faria
 */
public class ProfessorReader {
    /**
     * Método que lê, trata e aloca os dados dos Professores, armazenados em uma instância de persistência dos Professores.
     * @param filename Arquivo de texto com as informações dos Professores.
     * @param professorPersistence Instância de persistência dos Professores, onde serão armazenados os dados de cada Professor.
     * @return Retorna a quantidade de Professores lidos no arquivo.
     * @throws psproject2.InvalidFileFormatException  Exceção lançada quando o formato do arquivo de Professores não corresponde ao esperado.
     */
    public int readFile(String filename, ProfessorPersistence professorPersistence) throws InvalidFileFormatException {
        int nProf = 0, index;
        BufferedReader bf = null;
        String line;
        Professor professor = null;
        try {
            bf = new BufferedReader(new FileReader(filename));
            while ((line = bf.readLine()) != null) {
                if (line.startsWith("Nome:")) {
                    /* Estamos lendo o nome do Professor. */
                    if (professor != null) {
                        professorPersistence.addProfessor(professor);
                        nProf++;
                    }
                    index = 6;
                    professor = new Professor();
                    if (line.lastIndexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de Professores. Abortando execução.");
                        throw e;
                    }
                    professor.setName(line.substring(index, line.lastIndexOf(".")));
                } else if (professor != null && line.startsWith("Disponibilidade:")) {
                    /* Estamos lendo a parte das disponibilidades do Professor em questão. */
                    index = 17;
                    while (line.indexOf(";", index) != -1) {
                        String disponibilityText = line.substring(index, line.indexOf(";", index));
                        Disponibility disponibility = new Disponibility();
                        disponibility.populateData(disponibilityText);
                        professor.addDisponibility(disponibility);
                        index = line.indexOf(";", index) + 2;
                    }
                    if (line.indexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de Professores. Abortando execução.");
                        throw e;
                    }
                    String disponibilityText = line.substring(index, line.indexOf(".", index));
                    Disponibility disponibility = new Disponibility();
                    disponibility.populateData(disponibilityText);
                    professor.addDisponibility(disponibility);
                }
            }
            if (professor != null) {
                professorPersistence.addProfessor(professor);
                nProf++;
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao tentar realizar a leitura do arquivo " + filename);
            System.out.println("Descrição do erro: " + e.getMessage());
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println("Houve um erro ao fechar o arquivo " + filename);
                System.out.println("Descrição do erro: " + e.getMessage());
            }
        }
        return nProf;
    }
}
