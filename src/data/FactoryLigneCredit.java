package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FactoryLigneCredit {
	private HashMap<String,LigneCredit> lesCredits;
	public static FactoryLigneCredit singleton;

	
	private FactoryLigneCredit() {
		lesCredits = new HashMap<String,LigneCredit>();
	}
	
	public static FactoryLigneCredit getInstance() {
		if (singleton!=null)
			return singleton;
		
		singleton = new FactoryLigneCredit();
		return singleton;
	}
	
	public LigneCredit ajouterLigneCredit (String nomUser, String nomCredit, int id, int montant) throws LigneCreditExistanteException {
		if(lesCredits.containsKey(nomUser+id)) 
			throw new LigneCreditExistanteException();
		
		LigneCredit lc = new LigneCredit(nomCredit, nomUser, id, montant);
		lesCredits.put(nomUser+id, lc);
		return lc;
	}
	
	public LigneCredit rechercheLigneCredit(String nomUser, int id) {
		return lesCredits.get(nomUser+id);
	}
	
	public ArrayList<LigneCredit> rechercherListeCredit (String nomUser) {
		ArrayList<LigneCredit> result = new ArrayList<LigneCredit>();
		Iterator it = lesCredits.keySet().iterator();
		
		while(it.hasNext()) {
			LigneCredit lc = (LigneCredit) it.next();
			if(lc.getNomPersonne().equals(nomUser))
				result.add(lc);
		}
		
		return result;
	}
}