package ex6.src;

import java.util.ArrayDeque;
import java.util.Deque;

public class GestionImpression {
	Deque<Impression> dequeImpression = new ArrayDeque<>();


    public void ajouterImpression(Impression impr) {
		if (!dequeImpression.isEmpty() && dequeImpression.getLast().equals(impr))
			return;
		dequeImpression.add(impr);
    }

    public Impression selectionnerImpression() {
		return dequeImpression.poll();
    }


}
