import java.util.*;

public class AcademieAvecDesistement {
    private HashMap<String, Deque<String>> instrumentToDequeEleve;

    public AcademieAvecDesistement(ArrayList<String> v) {
        instrumentToDequeEleve = new HashMap<>();
        for (String s : v) {
            instrumentToDequeEleve.put(s, new ArrayDeque<>());
        }
    }

    public void mettreEnAttente(String instrument, String nomEleve) {
		getQueueForInstrument(instrument).add(nomEleve);
    }

    public void desistement(String instrument, String eleve) {
		getQueueForInstrument(instrument).remove(eleve);
    }

    //supprime uniquement l'�l�ve de la file d'attente
    public String attribuerPlace(String instrument) {
		return getQueueForInstrument(instrument).poll();
    }

	private Deque<String> getQueueForInstrument(String instrument) {
		return instrumentToDequeEleve.get(instrument);
	}


}
