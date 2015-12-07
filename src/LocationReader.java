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
public class LocationReader {
    /**
     * Método que lê, trata e aloca os dados dos locais de palestra, armazenados em uma instância de persistência dos locais.
     * @param filename Arquivo de texto com as informações dos locais de palestra.
     * @param locationPersistence Instância de persistência dos locais de palestra, onde serão armazenados os dados de cada local.
     * @return Retorna a quantidade de locais lidos no arquivo.
     * @throws psproject2.InvalidFileFormatException Exceção lançada quando o formato do arquivo de locais não corresponde ao esperado.
     */
    public int readFile(String filename, LocationPersistence locationPersistence) throws InvalidFileFormatException {
        int nLocation = 0, index;
        BufferedReader bf = null;
        String line;
        Location location = null;
        try {
            bf = new BufferedReader(new FileReader(filename));
            while ((line = bf.readLine()) != null) {
                location = new Location();
                if (line.lastIndexOf(".") == -1) {
                    InvalidFileFormatException e = new InvalidFileFormatException();
                    e.setMessage("Erro na definição do arquivo de locais. Abortando execução.");
                    throw e;
                }
                location.setName(line.substring(0, line.lastIndexOf(".")));
                locationPersistence.addLocation(location);
                nLocation++;
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
        return nLocation;
    }
}
