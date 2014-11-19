package data;

import java.util.HashMap;

public class Personne {
	String nom;
	HashMap<Integer,LigneCredit> lesCredits;
	
	public Personne(String nom) {
		this.nom = nom;
		lesCredits = new HashMap<Integer,LigneCredit>();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterCredit (LigneCredit lc) {
		lesCredits.put(lc.getId(), lc);
	}
	
	public void retirerCredit (LigneCredit lc) {
		lesCredits.remove(lc);
	}
	
	public String toString() {
		return nom;
	}
}
