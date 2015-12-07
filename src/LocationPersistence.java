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
 * Persistência dos locais, mantidas em uma ArrayList, e métodos de manutenção desta lista.
 * @author Leandro Faria
 */
public class LocationPersistence {
    private ArrayList<Location> locationList = new ArrayList<>();
    
    /**
     * Método que adiciona um local à lista de locais.
     * @param location Local a ser adicionado.
     */
    public void addLocation(Location location) {
        locationList.add(location);
    }
    
    /**
     * Método que busca um local de palestra pelo nome e o retorna.
     * @param locationName O nome do local que está sendo buscado.
     * @return Retorna o local que possui como atributo o nome passado.
     */
    public Location getLocationByName(String locationName) {
        Location location = null;
        locationName = locationName.toUpperCase();
        for (Location l : this.locationList) {
            if (l.getName().equals(locationName)) {
                location = l;
            }
        }
        return location;
    }
    
    /**
     * Método para fins de debug, que imprime a lista de locais.
     */
    public void printLocationList() {
        System.out.println("Locais Definidos:");
        for (Location l : locationList) {
            l.printLocation();
        }
    }
}
