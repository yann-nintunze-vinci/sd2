import java.util.HashMap;
import java.util.HashSet;

public class ControleDAcces {

    private HashMap<Badge, Employe> attribution;
    private HashSet<Employe> presences;

    public ControleDAcces() {
        attribution = new HashMap<>();
        presences = new HashSet<>();
    }

    // associe le badge a un employé
    public void donnerBadge(Badge b, Employe e) {
        attribution.put(b, e);
    }

    // met a jour les employés présents dans le batiment
    public void entrerBatiment(Badge b) {
        Employe employe = attribution.get(b);
        if (employe == null) throw new IllegalArgumentException();
        presences.add(employe);
    }

    // met � jour les employ�s pr�sents dans le batiment
    public void sortirBatiment(Badge b) {
        Employe employe = attribution.get(b);
        if (employe == null) throw new IllegalArgumentException();
        if (!presences.remove(employe)) throw new IllegalArgumentException();
    }

    // renvoie vrai si l'employ� est dans le batiment, faux sinon
    public boolean estDansBatiment(Employe e) {
        return presences.contains(e);
    }

}
