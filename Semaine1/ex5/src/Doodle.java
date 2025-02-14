import java.util.*;

public class Doodle {
    private PlageHoraire[] plages;
    private HashMap<String, Set<PlageHoraire>> participantToPlages;
    private TreeSet<PlageHoraire> treePlage;

    public Doodle(PlageHoraire... plages) {
        this.plages = plages;
        participantToPlages = new HashMap<>();
        treePlage = new TreeSet<>(Comparator.comparing(PlageHoraire::getNbParticipantPresent).reversed());
        treePlage.addAll(Arrays.asList(plages));
    }

    // ajoute les disponibilit�s d'un participant sous forme d'un tableau de booleen.
    // les indices du tableau correspondent aux indices du tableau plages
    // true � l'indice i veut dire que le participant est disponible pour la plage � l'indice i du tableau plages
    // false � l'indice i veut dire que le participant n'est pas disponible pour la plage � l'indice i du tableau plages
    public void ajouterDisponibilites(String participant, boolean[] disponibilites) {
        if (disponibilites.length != plages.length) throw new IllegalArgumentException();
        var set = participantToPlages.computeIfAbsent(participant, k -> new HashSet<>());
        for (int i = 0; i < disponibilites.length; i++) {
            PlageHoraire plage = plages[i];
            if (!disponibilites[i]) continue;

            treePlage.remove(plage);
            plage.setNbParticipantPresent(plage.getNbParticipantPresent() + 1);
            treePlage.add(plage);

            set.add(plage);
        }
    }

    // Hypoth�se: la PlageHoraire plage en param�tre fait bien partie du tableau plages
    // renvoie vrai si le participant est disponible pour cette plage horaire
    // renvoie faux si le participant n'est pas disponible ou s'il n'a pas rempli le
    // sondage doodle
    public boolean estDisponible(String participant, PlageHoraire plage) {
        return participantToPlages.containsKey(participant) && participantToPlages.get(participant).contains(plage);
    }

    // renvoie une des plages horaires qui a le maximum de participants pr�vus
    // cette m�thode est appel�e apr�s que les participants aient rempli leurs disponibilit�s
    public PlageHoraire trouverPlageQuiConvientLeMieux() {
        return treePlage.first();
    }

}
