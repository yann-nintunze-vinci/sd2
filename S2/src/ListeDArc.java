import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ListeDArc extends Graph {

  private ArrayList<Flight> flights;

  public ListeDArc() {
    super();
    flights = new ArrayList<>();
  }

  @Override
  // Complexit�: Inutile
  protected void ajouterSommet(Airport a) {
  }

  @Override
  // Complexit�: O(1)
  protected void ajouterArc(Flight f) {
    flights.add(f);
  }

  @Override
  // Complexit�: O(N)
  public Set<Flight> arcsSortants(Airport a) {
    return flights
        .stream()
        .filter(f -> f.getSource().equals(a))
        .collect(Collectors.toSet());
  }

  @Override
  // Complexit�: O(N)
  public boolean sontAdjacents(Airport a1, Airport a2) {
    return flights
        .stream()
        .anyMatch(f -> f.getSource().equals(a1) && f.getDestination().equals(a2));
  }

}
