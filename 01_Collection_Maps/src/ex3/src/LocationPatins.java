package ex3.src;

import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

    private Map<Integer, Deque<Integer>> pointureToCasiers;
    private Map<Integer, Integer> casierToPointure;
    private Map<Integer, LocalTime> casierToDate;

    public LocationPatins(int[] casiers) {
        this.pointureToCasiers = new HashMap<>();
        this.casierToPointure = new HashMap<>();
        this.casierToDate = new HashMap<>();

        for (int i = 0; i < casiers.length; i++) {
            int pointure = casiers[i];
            this.pointureToCasiers.putIfAbsent(pointure, new ArrayDeque<>());
            this.pointureToCasiers.get(pointure).add(i);
        }
        //O(N)
    }

    // date1 < date2
    private static double prix(LocalTime date1, LocalTime date2) {
        // 1 euro par milliseconde (c'est assez cher en effet)
        return MILLIS.between(date1, date2);
    }

    public int attribuerCasierAvecPatins(int pointure) {
        if (pointure < 33 || pointure > 48)
            throw new IllegalArgumentException();

        var deque = pointureToCasiers.get(pointure);

        if (deque == null || deque.isEmpty()) return -1;

        int casier = deque.poll();

        casierToPointure.put(casier, pointure);
        casierToDate.put(casier, LocalTime.now());

        return casier;
        //O(1)
    }

    public double libererCasier(int numeroCasier) {
        if (!casierToPointure.containsKey(numeroCasier)) {
            throw new IllegalArgumentException("Ce casier n'est pas actuellement loué !");
        }

        int pointure = casierToPointure.remove(numeroCasier);
        LocalTime date1 = casierToDate.remove(numeroCasier);

        pointureToCasiers.get(pointure).add(numeroCasier);

        return prix(date1, LocalTime.now());
        //O(1)
    }

}
