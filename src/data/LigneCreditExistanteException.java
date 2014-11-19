package data;

public class LigneCreditExistanteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LigneCreditExistanteException () {
		System.out.println(returnLigneCreditExistanteException());
	}
	
	public String returnLigneCreditExistanteException() {
		return "id de ligne existant pour cette personne";
	}
}
