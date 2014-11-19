package data;

public class PersonneExistanteException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PersonneExistanteException () {
		System.out.println(returnPersonneExistanteException());
	}
	
	public String returnPersonneExistanteException() {
		return "Personne existante";
	}
}
