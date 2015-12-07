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
 * Classe de leitura das palestas.
 * @author Leandro Faria
 */
public class LectureReader {
    /**
     * Método que lê, trata e aloca os dados das palestras, armazenadas em uma instância de persistência das palestras.
     * @param filename Arquivo de texto com as informações das palestras.
     * @param professorPersistence Instância de persistência dos Professores, onde estão armazenados os dados de cada Professor.
     * @param locationPersistence Instância de persistência dos locais de palestra, onde estão armazenados os dados de cada local de palestra.
     * @param lecturePersistence Instância de persistência das palestras, onde serão armazenados os dados de cada palestra.
     * @return Retorna a quantidade de palestras lidas no arquivo.
     * @throws psproject2.InvalidFileFormatException Exceção lançada quando o formato do arquivo de Palestras não corresponde ao esperado.
     * @throws psproject2.InvalidDataMentionException Exceção lançada quando há menção de algum dado não definido anteriormente (Professor/Local).
     */
    public int readFile(String filename, ProfessorPersistence professorPersistence, LocationPersistence locationPersistence, LecturePersistence lecturePersistence) throws InvalidFileFormatException, InvalidDataMentionException {
        int nLecture = 0, index;
        BufferedReader bf = null;
        String line;
        Lecture lecture = null;
        try {
            bf = new BufferedReader(new FileReader(filename));
            while ((line = bf.readLine()) != null) {
                if (line.startsWith("Nome:")) {
                    /* Estamos lendo o nome da palestra. */
                    if (lecture != null) {
                        lecturePersistence.addLecture(lecture);
                        nLecture++;
                    }
                    index = 6;
                    lecture = new Lecture();
                    if (line.lastIndexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    lecture.setName(line.substring(index, line.lastIndexOf(".")));
                } else if (lecture != null && line.startsWith("Palestrante:")) {
                    /* Estamos lendo a parte do nome do palestrante da palestra. */
                    index = 13;
                    if (line.lastIndexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    String professorName = line.substring(index, line.lastIndexOf("."));
                    Professor p = null;
                    p = professorPersistence.getProfessorByName(professorName);
                    if (p == null) {
                        InvalidDataMentionException e = new InvalidDataMentionException();
                        e.setMessage("Erro ao ler uma das palestras. O Professor designado não existe no arquivo texto de Professores. Abortando execução.");
                        throw e;
                    }
                    lecture.setProfessor(p);
                } else if (lecture != null && line.startsWith("Tema:")) {
                    /* Estamos lendo a parte do tema da palestra. */
                    index = 6;
                    if (line.lastIndexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    lecture.setTopic(line.substring(index, line.lastIndexOf(".")));
                } else if (lecture != null && line.startsWith("Local:")) {
                    /* Estamos lendo a parte do local da palestra. */
                    index = 7;
                    if (line.lastIndexOf(".") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    String locationName = line.substring(index, line.lastIndexOf("."));
                    Location l = null;
                    l = locationPersistence.getLocationByName(locationName);
                    if (l == null) {
                        InvalidDataMentionException e = new InvalidDataMentionException();
                        e.setMessage("Erro ao ler uma das palestras. O local de palestra designado não existe no arquivo texto de locais. Abortando execução.");
                        throw e;
                    }
                    lecture.setLocation(l);
                } else if (lecture != null && line.startsWith("Duracao:")) {
                    /* Estamos lendo a parte da duração da palestra. */
                    index = 9;
                    int duration = 0;
                    if (line.lastIndexOf(":") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    duration += Integer.parseInt(line.substring(index, line.lastIndexOf(":"))) * 60;
                    index = line.lastIndexOf(":") + 1;
                    if (line.lastIndexOf("h") == -1) {
                        InvalidFileFormatException e = new InvalidFileFormatException();
                        e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                        throw e;
                    }
                    duration += Integer.parseInt(line.substring(index, line.lastIndexOf("h")));
                    lecture.setDuration(duration);
                } else {
                    InvalidFileFormatException e = new InvalidFileFormatException();
                    e.setMessage("Erro na definição do arquivo de palestras. Abortando execução.");
                    throw e;
                }
            }
            if (lecture != null) {
                lecturePersistence.addLecture(lecture);
                nLecture++;
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
        return nLecture;
    }
}
