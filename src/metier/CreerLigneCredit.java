package metier;

import data.FactoryLigneCredit;
import data.FactoryPersonne;
import data.LigneCredit;
import data.LigneCreditExistanteException;

public class CreerLigneCredit {
	public CreerLigneCredit() {
		
	}
	
	public LigneCredit creer(String nomUser, String nomCredit, int id, int montant) throws LigneCreditExistanteException {
		LigneCredit lc = FactoryLigneCredit.getInstance().ajouterLigneCredit(nomUser, nomCredit, id, montant);
		FactoryPersonne.getInstance().chercherPersonne(nomUser).ajouterCredit(lc);
		return lc;
	}
}
