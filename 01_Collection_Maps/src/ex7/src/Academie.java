package ex7.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Academie {

    private HashMap<String, Deque<String>> instrumentToDequeEleve;

    public Academie(ArrayList<String> v) {
		instrumentToDequeEleve = new HashMap<>();
		for (String s : v) {
			instrumentToDequeEleve.put(s, new ArrayDeque<>());
		}
    }

    public void mettreEnAttente(String instrument, String nomEleve) {
		if (!instrumentToDequeEleve.containsKey(instrument)) return;
		instrumentToDequeEleve.get(instrument).add(nomEleve);
    }

    // supprime uniquement l'�l�ve de la file d'attente et le renvoie
    // renvoie null s�il n�y a pas d��l�ve en attente pour cet instrument
    public String attribuerPlace(String instrument) {
		if (!instrumentToDequeEleve.containsKey(instrument)) return null;
        return instrumentToDequeEleve.get(instrument).poll();
    }

}
