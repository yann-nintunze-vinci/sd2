import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
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
