import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph{
	
	private Map<Airport,Set<Flight>> outputFlights;

	public ListeDAdjacence(){
		super();
		outputFlights=new HashMap<Airport,Set<Flight>>();

	}

	@Override
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		//� compl�ter

	}

	@Override
	// Complexit�: ?
	protected void ajouterArc(Flight f) {
		//� compl�ter
	}

	@Override
	// Complexit�: ?
	public Set<Flight> arcsSortants(Airport a) {
		//� compl�ter
		return null;
	}

	@Override
	// Complexit�: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
		return false;
	}

}
