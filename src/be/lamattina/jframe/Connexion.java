package be.lamattina.jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;
import be.lamattina.pojo.*;

@SuppressWarnings("serial")
public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JFrame fenetre = this;
	private JPasswordField txt_password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Utilisateur> userdao = adf.getUtilisateurDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.orange);
		JLabel lbl_identify = new JLabel("Nom : ");
		lbl_identify.setBounds(50, 96, 200, 14);
		contentPane.add(lbl_identify);
		JLabel lbl_password = new JLabel("Mot de passe :");
		lbl_password.setBounds(50, 121, 200, 14);
		contentPane.add(lbl_password);
		txt_id = new JTextField();
		txt_id.setBounds(192, 93, 152, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		JButton btn_connect = new JButton("Connexion");
		btn_connect.addMouseListener(new MouseAdapter() {
			@Override
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent e) {
				String pass = String.valueOf(txt_password.getText());
				// Récupération des données de connexion
				if (txt_id.getText().isEmpty() && pass.isEmpty()) {
					// Show ERROR
					JOptionPane.showMessageDialog(null, "Connection error ! Field can't be empty !");
				}
				// Si les données sont remplies.
				else {
					// Verifier si l'utilisateur a rentrer les bonnes informations - (nom/mdp)
						// aver la méthode FIND
					//Utilisateur u = ((UtilisateurDAO)userdao).find(txt_id.getText().toLowerCase(), txt_password.getText());
					Utilisateur u = new Artiste();
					
					// Vérification du type d'utilisateur connecter
					// Si l'utilisateur est l'ORGANISATEUR - gérer le spectacle.
					if (u instanceof Organisateur) {
						
					}
					// Si l'utilisateur est un GESTIONNAIRE - jframe correspondant.
					else if (u instanceof Gestionnaire) {
						
					}					
					// Si l'utilisateur est un CLIENT OU un ARTISTE - jframe.RESERVATION
					else{
						
					}					
				}
			}
		});
		btn_connect.setBounds(126, 169, 188, 23);
		contentPane.add(btn_connect);
		JLabel lblTitre = new JLabel("Bosquet Wallon");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitre.setBounds(126, 30, 188, 30);
		contentPane.add(lblTitre);
		JButton btn_inscription = new JButton("Inscription");
		btn_inscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				fenetre.dispose();
				Inscription f = new Inscription();
				f.setVisible(true);
			}
		});
		btn_inscription.setBounds(126, 210, 188, 23);
		contentPane.add(btn_inscription);		
		txt_password = new JPasswordField();
		txt_password.setBounds(192, 118, 152, 20);
		contentPane.add(txt_password);
	}
}
