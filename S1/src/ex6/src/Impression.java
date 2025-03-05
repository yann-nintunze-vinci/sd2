package ex6.src;

import java.util.Objects;

public class Impression {

	private String idUtilisateur;
	private String fichier;

	public Impression(String idUtilisateur, String fichier) {
		this.idUtilisateur = idUtilisateur;
		this.fichier = fichier;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public String getFichier() {
		return fichier;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Impression that = (Impression) o;
		return Objects.equals(idUtilisateur, that.idUtilisateur);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(idUtilisateur);
	}
}
