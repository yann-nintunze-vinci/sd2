import java.util.*;

public class Ordonnancement {
    public static final int NIVEAU_PRIORITE_MAX = 5;
    HashMap<Integer, Deque<Tache>> taches;

    public Ordonnancement() {
        taches = new HashMap<>();
    }

    public void ajouterTache(String descriptif, int priorite) {
        if (priorite > NIVEAU_PRIORITE_MAX || priorite < 1)
            throw new IllegalArgumentException();
        taches.putIfAbsent(priorite, new ArrayDeque<>());
        var deque = taches.get(priorite);
        deque.add(new Tache(descriptif, priorite));
        //O(1)
    }

    //renvoie la tache prioritaire
    //renvoie null si plus de tache presente
    public Tache attribuerTache() {
        for (int i = NIVEAU_PRIORITE_MAX; i >= 1; i--) {
            var deque = taches.get(i);
            if (deque != null && !deque.isEmpty())
                return deque.poll();
        }
        //O(1)
        return null;
    }
}
