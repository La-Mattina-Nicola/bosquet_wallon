package be.lamattina.jframe;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Categorie;
import be.lamattina.pojo.Client;
import be.lamattina.pojo.Commande;
import be.lamattina.pojo.Place;
import be.lamattina.pojo.Representation;
import be.lamattina.pojo.Spectacle;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class JCommande extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private double somme = 5;
	private Date date = null;
	
	DefaultListModel<Place> model= new DefaultListModel<>();
    private List<Place> lst_place;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConnexion frame = new JConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCommande(Client user, Representation representation, Spectacle spectacle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Commande ");
		
		JLabel lblNewLabel = new JLabel("Montant total \u00E0 payer:");
		lblNewLabel.setBounds(190, 155, 160, 13);
		contentPane.add(lblNewLabel);
		
		JLabel TxtMontant = new JLabel(String.valueOf(somme));
		TxtMontant.setBounds(349, 155, 80, 13);
		contentPane.add(TxtMontant);
		JLabel lblNewLabel_1 = new JLabel("Mode de livraison:");
		lblNewLabel_1.setBounds(10, 11, 160, 13);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton RdbSurPlace = new JRadioButton("Sur place");
		buttonGroup.add(RdbSurPlace);
		RdbSurPlace.setSelected(true);
		RdbSurPlace.setBounds(10, 31, 103, 21);
		contentPane.add(RdbSurPlace);
		
		JRadioButton RdbTimbrePrior = new JRadioButton("Par timbre Prior");
		buttonGroup.add(RdbTimbrePrior);
		RdbTimbrePrior.setBounds(10, 55, 118, 21);
		contentPane.add(RdbTimbrePrior);
		
		JRadioButton RdbEnvoiSecurise = new JRadioButton("Par envoi s\u00E9curis\u00E9 +10\u20AC");
		buttonGroup.add(RdbEnvoiSecurise);
		RdbEnvoiSecurise.setBounds(10, 79, 179, 21);
		contentPane.add(RdbEnvoiSecurise);
		
		JLabel lblNewLabel_2 = new JLabel("Mode de payement:");
		lblNewLabel_2.setBounds(10, 107, 114, 13);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton RdbVisa = new JRadioButton("Par Visa");
		buttonGroup_1.add(RdbVisa);
		RdbVisa.setSelected(true);
		RdbVisa.setBounds(10, 127, 103, 21);
		contentPane.add(RdbVisa);
		
		JRadioButton RdbPaypal = new JRadioButton("Par Paypal");
		buttonGroup_1.add(RdbPaypal);
		RdbPaypal.setBounds(10, 151, 103, 21);
		contentPane.add(RdbPaypal);
		
		JButton BtnMenu = new JButton("Menu");
		BtnMenu.setBounds(10, 10, 414, 243);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JChoixRepresentation frame = new JChoixRepresentation(user, spectacle);
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(609, 150, 115, 23);
		contentPane.add(btnCancel);
		
		JButton btnRemoveListe = new JButton("Supprimer la liste");
		btnRemoveListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				somme = 5;
			}
		});
		btnRemoveListe.setBounds(474, 126, 250, 23);
		contentPane.add(btnRemoveListe);
		
		JLabel lblNewLabel_3 = new JLabel("Place :");
		lblNewLabel_3.setBounds(190, 10, 60, 14);
		contentPane.add(lblNewLabel_3);

		//Place p = new Place();
		//model.addElement(p);
		
		JButton btnAdd1 = new JButton("Debout");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Place p = new Place(spectacle.getConfiguration().getCategories().get(0).getPrix(), representation);
				somme += spectacle.getConfiguration().getCategories().get(0).getPrix();
				TxtMontant.setText(String.valueOf(somme));
				model.addElement(p);
			}
		});
		btnAdd1.setBounds(474, 30, 89, 23);
		contentPane.add(btnAdd1);
		JLabel lbl_prix1 = new JLabel("prix : ");
		lbl_prix1.setBounds(200, 34, 115, 14);
		contentPane.add(lbl_prix1);
		
		JButton btnAdd2 = new JButton("Argent");
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Place p = new Place(spectacle.getConfiguration().getCategories().get(1).getPrix(), representation);
				somme += spectacle.getConfiguration().getCategories().get(1).getPrix();
				TxtMontant.setText(String.valueOf(somme));
				model.addElement(p);
			}
		});
		btnAdd2.setBounds(474, 54, 89, 23);
		contentPane.add(btnAdd2);
		JLabel lbl_prix2 = new JLabel("prix : ");
		lbl_prix2.setBounds(200, 58, 115, 14);
		contentPane.add(lbl_prix2);
		
		JButton btnAdd3 = new JButton("Or");
		btnAdd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Place p = new Place(spectacle.getConfiguration().getCategories().get(2).getPrix(), representation);
				somme += spectacle.getConfiguration().getCategories().get(2).getPrix();
				TxtMontant.setText(String.valueOf(somme));
				model.addElement(p);
			}
		});
		btnAdd3.setBounds(474, 78, 89, 23);
		contentPane.add(btnAdd3);
		JLabel lbl_prix3 = new JLabel("prix : ");
		lbl_prix3.setBounds(200, 82, 115, 14);
		contentPane.add(lbl_prix3);
		
		JButton btnAdd4 = new JButton("Diamant");
		btnAdd4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Place p = new Place(spectacle.getConfiguration().getCategories().get(3).getPrix(), representation);
				somme += spectacle.getConfiguration().getCategories().get(2).getPrix();
				TxtMontant.setText(String.valueOf(somme));
				model.addElement(p);
			}
		});
		btnAdd4.setBounds(474, 102, 89, 23);
		contentPane.add(btnAdd4);
		JLabel lbl_prix4 = new JLabel("prix : ");
		lbl_prix4.setBounds(200, 106, 115, 14);
		contentPane.add(lbl_prix4);
		
		JList<Place> list = new JList<Place>();
		list.setBounds(573, 23, 151, 97);
		list.setModel(model);
		contentPane.add(list);
		
		JLabel lblNewLabel_3_1 = new JLabel("Disponible");
		lblNewLabel_3_1.setBounds(349, 10, 60, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lbl_disponible1 = new JLabel("");
		lbl_disponible1.setBounds(349, 34, 115, 14);
		contentPane.add(lbl_disponible1);
		
		JLabel lbl_disponible2 = new JLabel("");
		lbl_disponible2.setBounds(349, 58, 115, 14);
		contentPane.add(lbl_disponible2);
		
		JLabel lbl_disponible3 = new JLabel("");
		lbl_disponible3.setBounds(349, 82, 115, 14);
		contentPane.add(lbl_disponible3);
		
		JLabel lbl_disponible4 = new JLabel("");
		lbl_disponible4.setBounds(349, 106, 115, 14);
		contentPane.add(lbl_disponible4);
		
		//Place p = new Place();
		//model.addElement(p);
		
		//Création des lignes
		
		// En fonction du type de categorie configurée - on charge les différentes lignes.
		int nbr_categorie = spectacle.getConfiguration().getCategories().size();
		switch(spectacle.getConfiguration().getCategories().size()) {
			// DEBOUT - debout
			case 1:
				lbl_prix2.setVisible(false);
				btnAdd2.setVisible(false);
				lbl_prix3.setVisible(false);
				btnAdd3.setVisible(false);
				lbl_prix4.setVisible(false);
				btnAdd4.setVisible(false);
				//Bronze
				lbl_prix1.setText("Debout : " + String.valueOf(spectacle.getConfiguration().getCategories().get(0).getPrix()));
				lbl_disponible1.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(0).getNbr_place_dispo()));
				break;
			// CONCERT - bronze - argent - or
			case 3:
				lbl_prix4.setVisible(false);
				btnAdd4.setVisible(false);
				//Bronze
				lbl_prix1.setText("Bronze : " + String.valueOf(spectacle.getConfiguration().getCategories().get(0).getPrix()));
				lbl_disponible1.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(0).getNbr_place_dispo()));
				//Argent
				lbl_prix2.setText("Argent : " + String.valueOf(spectacle.getConfiguration().getCategories().get(1).getPrix()));
				lbl_disponible2.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(1).getNbr_place_dispo()));
				//Or
				lbl_prix3.setText("Or : " + String.valueOf(spectacle.getConfiguration().getCategories().get(2).getPrix()));
				lbl_disponible3.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(2).getNbr_place_dispo()));
				
				break;
			// CIRQUE - bronze - argent - or - diamant
			case 4:
				//Bronze
				lbl_prix1.setText("Bronze : " + String.valueOf(spectacle.getConfiguration().getCategories().get(0).getPrix()));
				lbl_disponible1.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(0).getNbr_place_dispo()));
				//Argent
				lbl_prix2.setText("Argent : " + String.valueOf(spectacle.getConfiguration().getCategories().get(1).getPrix()));
				lbl_disponible2.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(1).getNbr_place_dispo()));
				//Or
				lbl_prix3.setText("Or : " + String.valueOf(spectacle.getConfiguration().getCategories().get(2).getPrix()));
				lbl_disponible3.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(2).getNbr_place_dispo()));
				//Diamant
				lbl_prix3.setText("Diamant : " + String.valueOf(spectacle.getConfiguration().getCategories().get(3).getPrix()));
				lbl_disponible3.setText(String.valueOf(spectacle.getConfiguration().getCategories().get(3).getNbr_place_dispo()));
				break;
		}

		JButton BtnValider = new JButton("Payer");		
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mode_livraison = "";
				String mode_payement = "";
				double cout_total = Double.parseDouble(TxtMontant.getText());
				
				if(RdbPaypal.isSelected())
					mode_payement = "Paypal";
				else
					mode_payement = "Visa";
				if (RdbSurPlace.isSelected()) 
					mode_livraison = "Sur place";
				else if (RdbTimbrePrior.isSelected())
					mode_livraison = "Prioritaire";
				else {
					mode_livraison = "Envoi sécurisé";
					cout_total += 10;
				}
				
				Commande c = new Commande(user, mode_livraison, mode_payement, cout_total);
				int taille_liste = model.getSize();
				System.out.println("PLACE :");
				List<Place> lst = new ArrayList<Place>();
				for(int i = 0; i < taille_liste; i++) {
					Place p = (Place) model.getElementAt(i);
					lst.add(p);
				}
				c.setLst_place(lst);
				JOptionPane.showMessageDialog(null, "Commande de : " + user.getNom() + " " + user.getPrenom() + " || prix : " + c.getCout_total() + " €");
				user.creerCommande(c);
				dispose();
			}
		});
		BtnValider.setBounds(474, 150, 125, 22);
		contentPane.add(BtnValider);
	}
}
