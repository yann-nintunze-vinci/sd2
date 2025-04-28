package ex2.src;

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
        //O(1)
    }

    // met a jour les employés présents dans le batiment
    public void entrerBatiment(Badge b) {
        Employe employe = attribution.get(b);
        if (employe == null) throw new IllegalArgumentException();
        presences.add(employe);
        //O(1)
    }

    // met � jour les employ�s pr�sents dans le batiment
    public void sortirBatiment(Badge b) {
        Employe employe = attribution.get(b);
        if (employe == null) throw new IllegalArgumentException();
        if (!presences.remove(employe)) throw new IllegalArgumentException();
        //O(1)
    }

    // renvoie vrai si l'employ� est dans le batiment, faux sinon
    public boolean estDansBatiment(Employe e) {
        return presences.contains(e);
        //O(1)
    }

}
