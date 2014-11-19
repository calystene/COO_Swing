package data;

import java.util.ArrayList;

public class LigneCredit {
	int id, montant;
	String nomCredit, nomPersonne;
	ArrayList<Depense> lesDepenses;
	
	public LigneCredit(String nomPersonne, String nomCredit, int id, int montant) {
		this.nomCredit = nomCredit;
		this.nomPersonne = nomPersonne;
		this.id = id;
		this.montant = montant;
		lesDepenses = new ArrayList<Depense>();
	}
	
	public int getId() {
		return id;
	}
	
	public int getMontant() {
		return montant;
	}
	
	public String getNomCredit() {
		return nomCredit;
	}
	
	public String getNomPersonne() {
		return nomPersonne;
	}
	
	public void setMontant(int valeur) {
		montant += valeur;
	}
	
	public ArrayList<Depense> getDepenses () {
		return lesDepenses;
	}
	
	public void ajouterDepense(Depense d) {
		lesDepenses.add(d);
	}
	
	public void deleteDepense(Depense d) {
		lesDepenses.remove(d);
	}
}
