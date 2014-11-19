package presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import data.LigneCreditExistanteException;
import metier.CreerLigneCredit;
import metier.CreerUtilisateur;

public class ProgrammeSwing {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Application CreditLigne");
		
		// Metier
		CreerUtilisateur createUser = new CreerUtilisateur();
		CreerLigneCredit createLigne = new CreerLigneCredit();
		
		
		//Ajout des Panel
		frame.getContentPane().add(new CreateUserPanel(frame, createUser),BorderLayout.NORTH);
		frame.getContentPane().add(new CreerCreditLignePanel(frame, createLigne), BorderLayout.SOUTH);
		
		// Config fenêtre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
