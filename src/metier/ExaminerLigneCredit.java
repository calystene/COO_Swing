package metier;

import java.util.ArrayList;
import java.util.HashMap;

import data.Depense;
import data.FactoryLigneCredit;
import data.LigneCredit;

public class ExaminerLigneCredit{
	private String nomUser;
	private int idLigneCredit;

	public ExaminerLigneCredit(String nomUser,int idLigneCredit) {
		this.nomUser = nomUser;
		this.idLigneCredit = idLigneCredit;
	}
	
	public LigneCredit getLigneCredit() {
		return FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit);
	}
	
	public ArrayList<LigneCredit> rechercherListe (String user) {
		return FactoryLigneCredit.getInstance().rechercherListeCredit(nomUser);
	}
	
	public int getMInitialLigneCredit() {
		return FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getMontant();
	}
	
	public int getMReelLigneCredit() {
		LigneCredit lc = getLigneCredit();
		int montant = FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getMontant();
		
		for(Depense d : lc.getDepenses()) {
			montant -= d.getMontant();
		}
		return montant;
	}
	
	public ArrayList<Depense> getListeDepense() {
		return FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getDepenses();
	}
}
