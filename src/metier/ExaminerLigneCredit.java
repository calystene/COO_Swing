package metier;

import java.util.ArrayList;

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
	
	public int getMInitialLigneCredit() {
		return FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getMontant();
	}
	
	public int getMReelLigneCredit() {
		LigneCredit lc = getLigneCredit();
		int montant = FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getMontant();
		try {
			createUser.creer("pierard");
			createLigne.creer("pierard","test", 1, 300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Depense d : lc.getDepenses()) {
			montant -= d.getMontant();
		}
		return montant;
	}
	
	public ArrayList<Depense> getListeDepense() {
		return FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit).getDepenses();
	}
}
