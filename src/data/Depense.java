package data;

public class Depense {
	private int montant;
	private int idLigneCred;
	
	public Depense(int idLigneCred, int montant) {
		this.idLigneCred = idLigneCred;
		this.montant = montant;
	}
	
	public int getMontant() {
		return montant;
	}
	
	public int getIdLigneCred () {
		return idLigneCred;
	}
}
