package be.lamattina.jframe;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import be.lamattina.pojo.*;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class JCreationSpectacle extends JFrame {
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	boolean visible = false;
	private JTextField txt_titre;
	private JList<Artiste> LstArtiste;
	private List<Artiste> artistes = new ArrayList<Artiste>();
	
	private Spectacle s = new Spectacle();
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
	public JCreationSpectacle(Organisateur organisateur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titre du spectacle:");
		lblNewLabel.setBounds(10, 10, 155, 13);
		contentPane.add(lblNewLabel);
		
		txt_titre = new JTextField();
		txt_titre.setBounds(175, 6, 250, 20);
		contentPane.add(txt_titre);
		txt_titre.setColumns(10);

		DefaultListModel<Artiste> model = new DefaultListModel<>();
		model.addAll(s.findArtiste());
		LstArtiste = new JList<>(model);
		LstArtiste.setBounds(10, 201, 155, 101);
		contentPane.add(LstArtiste);

		DefaultListModel<Artiste> modelSelected = new DefaultListModel<>();
		JList<Artiste> LstArtisteSelected = new JList<>(modelSelected);
		LstArtisteSelected.setBounds(238, 201, 187, 101);
		contentPane.add(LstArtisteSelected);

		JButton BtnToLeft = new JButton("<--");
		BtnToLeft.addMouseListener(new MouseAdapter() {
			@Override
			// Supprimer l'artiste selectionner de la liste - et le rajouter dans la liste de GAUCHE.
			public void mouseClicked(MouseEvent e) {
				Artiste a = LstArtisteSelected.getSelectedValue();
				modelSelected.removeElement(LstArtisteSelected.getSelectedValue());
				artistes.remove(a);
				model.addElement(a);
			}
		});
		BtnToLeft.setBounds(174, 255, 54, 21);
		contentPane.add(BtnToLeft);

		JButton BtnToRight = new JButton("-->");
		BtnToRight.addMouseListener(new MouseAdapter() {
			@Override
			// Supprimer l'artiste selectionner de la liste - et le rajouter dans la liste de DROITE.
			public void mouseClicked(MouseEvent e) {
				//Si un utilisateur est selectionner a gauche
				Artiste a = LstArtiste.getSelectedValue();
				model.removeElement(LstArtiste.getSelectedValue());
				modelSelected.addElement(a);
				artistes.add(a);
			}
		});
		BtnToRight.setBounds(175, 223, 54, 21);
		contentPane.add(BtnToRight);
		
		JLabel lblNewLabel_2 = new JLabel("Liste de tout les artistes");
		lblNewLabel_2.setBounds(10, 176, 155, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Liste des artistes du spectacle");
		lblNewLabel_2_1.setBounds(238, 176, 187, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lbl_debout = new JLabel("Debout :");
		lbl_debout.setBounds(175, 58, 85, 14);
		contentPane.add(lbl_debout);
		
		JTextField txt_debout = new JTextField();
		txt_debout.setBounds(270, 55, 90, 20);
		contentPane.add(txt_debout);

		lbl_debout.setVisible(false);
		txt_debout.setVisible(false);
		

		JLabel lbl_bronze = new JLabel("Bronze :");
		lbl_bronze.setBounds(175, 58, 46, 14);
		contentPane.add(lbl_bronze);
		
		JTextField txt_bronze = new JTextField();
		txt_bronze.setBounds(270, 55, 90, 20);
		contentPane.add(txt_bronze);
		
		JLabel lbl_argent = new JLabel("Argent :");
		lbl_argent.setBounds(175, 89, 85, 14);
		contentPane.add(lbl_argent);
		
		JTextField txt_argent = new JTextField();
		txt_argent.setBounds(270, 86, 90, 20);
		contentPane.add(txt_argent);

		JLabel lbl_or = new JLabel("Or :");
		lbl_or.setBounds(175, 120, 85, 14);
		contentPane.add(lbl_or);
		
		JTextField txt_or = new JTextField();
		txt_or.setBounds(270, 117, 90, 20);
		contentPane.add(txt_or);

		JLabel lbl_diamant = new JLabel("Diamant :");
		lbl_diamant.setBounds(175, 151, 85, 14);
		contentPane.add(lbl_diamant);
		
		JTextField txt_diamant = new JTextField();
		txt_diamant.setBounds(270, 148, 90, 20);
		contentPane.add(txt_diamant);	
		
		JLabel lblNewLabel_1 = new JLabel("Categorie");
		lblNewLabel_1.setBounds(10, 34, 100, 14);
		contentPane.add(lblNewLabel_1);		

		JRadioButton RadioDebout = new JRadioButton("Debout");
		RadioDebout.setSelected(true);
		RadioDebout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == RadioDebout) {
					//Affichage - libre - txt_libre
					lbl_debout.setVisible(true);
					txt_debout.setVisible(true);
					lbl_bronze.setVisible(false);
					txt_bronze.setVisible(false);
					lbl_argent.setVisible(false);
					txt_argent.setVisible(false);
					lbl_or.setVisible(false);
					txt_or.setVisible(false);
					lbl_diamant.setVisible(false);
					txt_diamant.setVisible(false);
				}
			}
		});
		buttonGroup.add(RadioDebout);
		RadioDebout.setBounds(10, 55, 100, 21);
		contentPane.add(RadioDebout);

		JRadioButton RadioConcert = new JRadioButton("Concert");
		RadioConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == RadioConcert) {
					// Affichage - bronze - argent - or
					lbl_debout.setVisible(false);
					txt_debout.setVisible(false);
					lbl_bronze.setVisible(true);
					txt_bronze.setVisible(true);
					lbl_argent.setVisible(true);
					txt_argent.setVisible(true);
					lbl_or.setVisible(true);
					txt_or.setVisible(true);
					lbl_diamant.setVisible(false);
					txt_diamant.setVisible(false);
				}
			}
		});
		buttonGroup.add(RadioConcert);
		RadioConcert.setBounds(10, 86, 100, 21);
		contentPane.add(RadioConcert);

		JRadioButton RadioCirque = new JRadioButton("Cirque");
		RadioCirque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == RadioCirque) {
					// Affichage - bronze - argent - or - diamant
					lbl_debout.setVisible(false);
					txt_debout.setVisible(false);
					lbl_bronze.setVisible(true);
					txt_bronze.setVisible(true);
					lbl_argent.setVisible(true);
					txt_argent.setVisible(true);
					lbl_or.setVisible(true);
					txt_or.setVisible(true);
					lbl_diamant.setVisible(true);
					txt_diamant.setVisible(true);					
				}
			}
		});
		buttonGroup.add(RadioCirque);
		RadioCirque.setBounds(10, 117, 100, 21);
		contentPane.add(RadioCirque);
		
		JButton btnNewButton = new JButton("Cr\u00E9ation du spectacle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_titre.getText() != null && LstArtisteSelected != null) {
					// En fonction de la configuration selectionnée
					s.setTitre(txt_titre.getText());
					s.setListe_artistes(artistes);
					Configuration configuration = new Configuration();
					List<Categorie> lst_categories = new ArrayList<Categorie>();
					if(RadioDebout.isSelected()) {
						lst_categories.add(new Categorie("Debout", Float.valueOf(txt_debout.getText()), 8000, 8000));
						configuration = new Configuration("Debout", "Tout le monde est debout !", lst_categories);
					}
					else if (RadioConcert.isSelected()) {
						lst_categories.add(new Categorie("Bronze", 	Float.valueOf(txt_bronze.getText()), 3000, 3000));
						lst_categories.add(new Categorie("Argent", 	Float.valueOf(txt_argent.getText()), 1500, 1500));
						lst_categories.add(new Categorie("Or", 		Float.valueOf(txt_or.getText()),  	  500,  500));
						configuration = new Configuration("Concert", "Idéal pour un concert", lst_categories);						
					}
					else if (RadioCirque.isSelected()) {
						lst_categories.add(new Categorie("Bronze", 	Float.valueOf(txt_bronze.getText()), 1500, 1500));
						lst_categories.add(new Categorie("Argent", 	Float.valueOf(txt_argent.getText()), 1500, 1500));
						lst_categories.add(new Categorie("Or", 		Float.valueOf(txt_or.getText()),  	 2000, 2000));
						lst_categories.add(new Categorie("Diamant",	Float.valueOf(txt_or.getText()),  	 1000, 1000));
						configuration = new Configuration("Cirque", "Les clowns sont de sorties", lst_categories);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selectionner une configuration !");
					}
					s.setConfiguration(configuration);
					JOptionPane.showMessageDialog(null, "Création du spectacle");
					// orga -> salle -> planing -> spectacle
					organisateur.addSpectacle(s);
				}
				else {
					JOptionPane.showMessageDialog(null, "Veuillez renseigner les différents champs !");					
				}
			}
		});
		btnNewButton.setBounds(10, 313, 415, 32);
		contentPane.add(btnNewButton);
		lbl_debout.setVisible(true);
		txt_debout.setVisible(true);
		lbl_bronze.setVisible(false);
		txt_bronze.setVisible(false);
		lbl_argent.setVisible(false);
		txt_argent.setVisible(false);
		lbl_or.setVisible(false);
		txt_or.setVisible(false);
		lbl_diamant.setVisible(false);
		txt_diamant.setVisible(false);
	}
}
