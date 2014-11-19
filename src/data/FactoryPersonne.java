package data;

import java.util.HashMap;

public class FactoryPersonne {
	private static FactoryPersonne singleton;
	private HashMap<String,Personne> lesPersonnes;
	
	private FactoryPersonne() {
		lesPersonnes = new HashMap<String,Personne>();
	}
	
	public static FactoryPersonne getInstance() {
		if (singleton!=null)
				return singleton; 
		singleton = new FactoryPersonne();
		return singleton;
	}
	
	public Personne creerPersonne(String nom) throws PersonneExistanteException {
		if(lesPersonnes.containsKey(nom)) 
			throw new PersonneExistanteException();
		
		Personne p = new Personne(nom);
		lesPersonnes.put(nom, p);
		return p;
	}
	
	public Personne chercherPersonne(String nom) {
		return lesPersonnes.get(nom);
	}
	
	public HashMap<String, Personne> lister () {
		return lesPersonnes;
	}
}
