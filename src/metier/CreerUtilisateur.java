package metier;

import data.FactoryPersonne;
import data.PersonneExistanteException;

public class CreerUtilisateur {
	public CreerUtilisateur() {
		
	}
	
	public void creer(String nom) throws PersonneExistanteException {
		FactoryPersonne.getInstance().creerPersonne(nom);
	}
}
