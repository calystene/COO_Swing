package metier;

import data.Depense;
import data.FactoryLigneCredit;
import data.LigneCredit;

public class CreerDepense {
	public CreerDepense(String nomUser, int idLigneCredit, int montant) {
		LigneCredit lc = FactoryLigneCredit.getInstance().rechercheLigneCredit(nomUser, idLigneCredit);
		
		if (lc.getMontant() >= montant) {
			lc.ajouterDepense(new Depense(idLigneCredit, montant));
		}
	}
}
