import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph {

  private Map<Integer, Airport> correspondanceIndiceAirport;
  private Map<Airport, Integer> correspondanceAirportIndice;
  private static final int TAILLE_MATRICE = 10;
  private Flight[][] matrice = new Flight[TAILLE_MATRICE][TAILLE_MATRICE];
  private int nbAirport = 0;

  public MatriceDAdjacence() {
    super();
    correspondanceAirportIndice = new HashMap<>();
    correspondanceIndiceAirport = new HashMap<>();
  }

  @Override
  // Complexité: O(1)
  protected void ajouterSommet(Airport a) {
    //à compléter
    if (nbAirport == matrice.length) {
      matrice = agrandirMatrice();
    }
    correspondanceIndiceAirport.put(nbAirport, a);
    correspondanceAirportIndice.put(a, nbAirport++);
  }

  private Flight[][] agrandirMatrice() {
    Flight[][] nvMatrice = new Flight[nbAirport * 2][nbAirport * 2];

    for (int i = 0; i < matrice.length; i++) {
      for (int j = 0; j < matrice[0].length; j++) {
        nvMatrice[i][j] = matrice[i][j];
      }
    }

    return nvMatrice;
  }

  @Override
  // Complexité: O(1)
  protected void ajouterArc(Flight f) {
    int indexSource = correspondanceAirportIndice.get(f.getSource());
    int indexDest = correspondanceAirportIndice.get(f.getDestination());

    matrice[indexSource][indexDest] = f;
  }

  @Override
  // Complexité: O(N)
  public Set<Flight> arcsSortants(Airport a) {
    int indexSource = correspondanceAirportIndice.get(a);
    Set<Flight> arcs = new HashSet<>();
    for (int i = 0; i < nbAirport; i++) {
      if (matrice[indexSource][i] != null) {
        arcs.add(matrice[indexSource][i]);
      }
    }
    return arcs;
  }

  @Override
  // Complexité: O(1)
  public boolean sontAdjacents(Airport a1, Airport a2) {
    int indexSource = correspondanceAirportIndice.get(a1);
    int indexDest = correspondanceAirportIndice.get(a2);

    return matrice[indexSource][indexDest] != null;
  }


}
