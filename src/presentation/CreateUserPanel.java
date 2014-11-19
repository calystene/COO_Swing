package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.FactoryPersonne;
import data.Personne;
import data.PersonneExistanteException;
import metier.CreerUtilisateur;

@SuppressWarnings("serial")
public class CreateUserPanel extends JPanel implements ActionListener{
	private JFrame frame;
	private CreerUtilisateur createUser;
	
	
	
	// Le label et le champs pour récupérer le nom de l'utilisateur à créer
	private JLabel labelCreation = new JLabel("Créer utilisateur ");
	private JTextField fieldCreation = new JTextField(10);
	
	//Création bouton créer
	private JButton btnCreation = new JButton("Créer");
	
	//Création liste User
	@SuppressWarnings("rawtypes")
	private JComboBox listeUser = new JComboBox();
	
	public CreateUserPanel(JFrame frame, CreerUtilisateur createUser) {
		super(true);
		this.frame = frame;
		this.createUser = createUser;
		
		this.setLayout(new BorderLayout());
		
		btnCreation.addActionListener(this);
		listeUser.addActionListener(this);
		
		add(labelCreation, BorderLayout.WEST);
		add(fieldCreation, BorderLayout.CENTER);
		add(btnCreation, BorderLayout.EAST);
		add(listeUser, BorderLayout.SOUTH);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnCreation && fieldCreation.getText()!="") {
			creation();
			fieldCreation.setText(null);
			majListeUser();
		}
		
	}
	
	private void creation() {
		try {
			createUser.creer(fieldCreation.getText());
		} catch (PersonneExistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void majListeUser() {
		HashMap<String,Personne> collect = FactoryPersonne.getInstance().lister();
		Iterator it = collect.keySet().iterator();
		
		while(it.hasNext()) {
			listeUser.addItem(it.next());
		}
	}
	
}
