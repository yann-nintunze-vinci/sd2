import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

	private List<Integer> casiers;
	private LocalTime debut;
	
	public LocationPatins(int[] casiers) {
		this.casiers = new ArrayList<>();
		for (int i = 0; i < casiers.length; i++) {
			this.casiers.add(casiers[i]);
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		this.debut = LocalTime.now();

		return casiers.indexOf(pointure);
		
		//a completer

	}

	public double libererCasier(int numeroCasier) {
		if (numeroCasier < 0 || numeroCasier > casiers.size())
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();
		casiers.get(numeroCasier);
		return prix(debut, l);
	}

}
