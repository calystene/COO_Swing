package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.LigneCreditExistanteException;
import metier.CreerLigneCredit;

public class CreerCreditLignePanel extends JPanel implements ActionListener {
	JFrame frame;
	JPanel panel;
	CreerLigneCredit metier;

	// Création des JTextField
	JTextField textUser;
	JTextField textNomCredit;
	JTextField textIdLigne;
	JTextField textMontant;

	// Création des labels
	JLabel labelUser;
	JLabel labelNomCredit;
	JLabel labelIdLigne;
	JLabel labelMontant;

	// Bouton de validation
	JButton btnCreer = new JButton("Créer Crédit");

	public CreerCreditLignePanel(JFrame frame, CreerLigneCredit metier) {
		super(true);
		this.frame = frame;
		this.metier = metier;

		// Panel conteneur
		panel = new JPanel();

		// Création des JTextField
		textUser = new JTextField(10);
		textNomCredit = new JTextField(10);
		textIdLigne = new JTextField(10);
		textMontant = new JTextField(10);

		// Création des labels
		labelUser = new JLabel("Nom utilisateur");
		labelNomCredit = new JLabel("Nom crédit");
		labelIdLigne = new JLabel("id ligne");
		labelMontant = new JLabel("Montant");

		// Bouton de validation
		btnCreer.addActionListener(this);

		this.setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(2, 4));

		panel.add(labelUser);
		panel.add(labelNomCredit);
		panel.add(labelIdLigne);
		panel.add(labelMontant);
		panel.add(textUser);
		panel.add(textNomCredit);
		panel.add(textIdLigne);
		panel.add(textMontant);

		add(panel);
		add(btnCreer, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnCreer
				&& textUser.getText()!=""
				&& textNomCredit.getText()!=""
				&& textIdLigne.getText()!=""
				&& textMontant.getText()!="") {
			String nomUser = textUser.getText();
			String nomCredit = textNomCredit.getText();
			int idLigne = Integer.parseInt(textIdLigne.getText());
			int montant = Integer.parseInt(textMontant.getText());

			try {
				metier.creer(nomUser, nomCredit, idLigne, montant);
			} catch (Exception e1) {
				
				// Création d'un JDialog pour afficher message d'erreur
				JDialog error = new JDialog(frame, "Erreur création crédit", true);
				JLabel msgError = new JLabel("Une erreur c'est produite lors de la création du crédit");
				msgError.setForeground(Color.RED);
				error.setLocationRelativeTo(frame);
				error.getContentPane().add(msgError, BorderLayout.CENTER);
				error.pack();
				error.setVisible(true);
			}
		}

	}
}
