import java.util.HashMap;
import java.util.HashSet;

public class ControleDAcces {

    private HashMap<Badge, Employe> controle;
    private HashSet<Employe> presences;

    public ControleDAcces() {
        controle = new HashMap<>();
        presences = new HashSet<>();
    }

    // associe le badge a un employé
    public void donnerBadge(Badge b, Employe e) {
        controle.put(b, e);
    }

    // met a jour les employés présents dans le batiment
    public void entrerBatiment(Badge b) {
        Employe employe = controle.get(b);
        if (employe == null) throw new IllegalArgumentException();
        presences.add(employe);
    }

    // met � jour les employ�s pr�sents dans le batiment
    public void sortirBatiment(Badge b) {
        Employe employe = controle.get(b);
        if (employe == null) throw new IllegalArgumentException();
        if (!estDansBatiment(employe)) throw new IllegalArgumentException();
        presences.remove(employe);
    }

    // renvoie vrai si l'employ� est dans le batiment, faux sinon
    public boolean estDansBatiment(Employe e) {
        return presences.contains(e);
    }

}
