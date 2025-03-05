import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph {

  private Map<Airport, Set<Flight>> outputFlights;

  public ListeDAdjacence() {
    super();
    outputFlights = new HashMap<>();
  }

  @Override
  // Complexité: O(1)
  protected void ajouterSommet(Airport a) {
    outputFlights.put(a, new HashSet<>());
  }

  @Override
  // Complexité: O(1)
  protected void ajouterArc(Flight f) {
    Airport source = f.getSource();
    outputFlights.get(source).add(f);
  }

  @Override
  // Complexité: O(1)
  public Set<Flight> arcsSortants(Airport a) {
    return outputFlights.get(a);
  }

  @Override
  // Complexité: O(N)
  public boolean sontAdjacents(Airport a1, Airport a2) {
    var set1 = outputFlights.get(a1);
    for (Flight f : set1) {
      if (f.getDestination().equals(a2))
        return true;
    }
    return false;
  }

}
