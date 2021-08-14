package be.lamattina.jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.lamattina.pojo.*;

@SuppressWarnings("serial")
public class JConnexion extends JFrame {

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
					JConnexion frame = new JConnexion();
					frame.setTitle("Connexion");
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
	public JConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.orange);

		JLabel lblTitre = new JLabel("Bosquet Wallon");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitre.setBounds(10, 11, 364, 30);
		contentPane.add(lblTitre);
		JLabel lbl_identify = new JLabel("Email : ");
		lbl_identify.setBounds(20, 52, 100, 14);
		contentPane.add(lbl_identify);
		JLabel lbl_password = new JLabel("Mot de passe :");
		lbl_password.setBounds(20, 80, 100, 14);
		contentPane.add(lbl_password);
		txt_id = new JTextField();
		txt_id.setBounds(174, 49, 200, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		JButton btn_connect = new JButton("Connexion");
		btn_connect.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String email = String.valueOf(txt_id.getText().toLowerCase());
				String mdp = String.valueOf(txt_password.getPassword());
				
				Utilisateur u = new Utilisateur();
				u.setEmail(email);
				u.setMot_de_passe(mdp);
				
				// Récupération des données de connexion
				if (email.isEmpty() && mdp.isEmpty()) {
					// Show ERROR
					JOptionPane.showMessageDialog(null, "Tout les champs doivent être complet !");
				}
				// Si les données sont remplies.
				else {
					// Verifier si l'utilisateur a rentrer les bonnes informations - (nom/mdp)
						// aver la méthode FIND
					Utilisateur user = u.find();
					if (user instanceof Artiste) {
					}
					// Si l'utilisateur est l'ORGANISATEUR - gérer le spectacle
					if (user instanceof Organisateur) {
						//Si l'utilisateur a déjà reserver une salle.
						Organisateur organisateur = (Organisateur) user;
						organisateur.chargerReservation();
						if (organisateur.getReservations().size() > 0) {
							dispose();
							JListeSpectacle creationSpectacle = new JListeSpectacle((Organisateur) user);
							creationSpectacle.setVisible(true);
						}
						else {
							JReservationSalle reservationSalle = new JReservationSalle((Organisateur) user);
							reservationSalle.setVisible(true);
							dispose();
						}
					}
					// Si l'utilisateur est un GESTIONNAIRE - jframe correspondant
					else if (user instanceof Gestionnaire) {
					}
					// Si l'utilisateur est un CLIENT OU un ARTISTE - jframe.RESERVATION
					else if (user instanceof Client){
					}
				}
			}
		});
		btn_connect.setBounds(10, 105, 364, 23);
		contentPane.add(btn_connect);
		JButton btn_inscription = new JButton("Inscription");
		btn_inscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fenetre.dispose();
				JInscription f = new JInscription();
				f.setVisible(true);
			}
		});
		btn_inscription.setBounds(10, 139, 364, 23);
		contentPane.add(btn_inscription);		
		txt_password = new JPasswordField();
		txt_password.setBounds(174, 77, 200, 20);
		contentPane.add(txt_password);
		

		///////////
		txt_id.setText("organisateur@hotmail.com");
		txt_password.setText("1234");
		///////////
	}
}
