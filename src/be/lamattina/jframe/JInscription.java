package be.lamattina.jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import be.lamattina.pojo.*;

public class JInscription extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtmail;
	private JTextField txtadresse;

	private JFrame inscription = this;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInscription frame = new JInscription();
					frame.setTitle("Inscription");
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JInscription() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 310);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.orange);
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setBounds(10, 11, 280, 38);
		contentPane.add(lblInscription);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 60, 55, 14);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(10, 85, 55, 14);
		contentPane.add(lblPrenom);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 135, 55, 14);
		contentPane.add(lblEmail);

		JLabel lbltype = new JLabel("Type :");
		lbltype.setBounds(10, 160, 55, 14);
		contentPane.add(lbltype);

		JLabel lblRue = new JLabel("Adresse :");
		lblRue.setBounds(10, 185, 55, 14);
		contentPane.add(lblRue);

		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(10, 110, 78, 14);
		contentPane.add(lblPassword);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Artiste", "Client", "Organisateur" }));
		comboBox.setBounds(144, 156, 200, 22);
		contentPane.add(comboBox);

		txtnom = new JTextField();
		txtnom.setBounds(144, 57, 200, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);

		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(144, 82, 200, 20);
		contentPane.add(txtprenom);

		txtmail = new JTextField();
		txtmail.setColumns(10);
		txtmail.setBounds(144, 132, 200, 20);
		contentPane.add(txtmail);

		txtadresse = new JTextField();
		txtadresse.setColumns(10);
		txtadresse.setBounds(144, 181, 200, 22);
		contentPane.add(txtadresse);
		txtpassword=new JPasswordField();
		txtpassword.setBounds(144,107,200,20);
		contentPane.add(txtpassword);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				inscription.dispose();
				// Afficher la fenetre de connexion
				JConnexion f = new JConnexion();
				f.setVisible(true);
			}
		});
		btnAnnuler.setBounds(10,244,334,23);
		contentPane.add(btnAnnuler);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (txtprenom.getText().isEmpty() && txtnom.getText().isEmpty() && String.valueOf(txtpassword.getPassword()).isEmpty()
						&& txtmail.getText().isEmpty() && txtadresse.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tout les champs doivent être complet !");
				} else {
					
					String discriminator = comboBox.getSelectedItem().toString();
					Utilisateur user = null;
					// Impossible de créer un gestionnaire. Il n'en existe qu'un seul et il est créer manuellement
					switch (discriminator){
					case "Artiste":
						user = new Artiste();
						break;
					case "Organisateur":
						user = new Organisateur();
						break;
					case "Client":
						user = new Client();
						break;
					}
					user.setNom(txtnom.getText().toLowerCase());
					user.setPrenom(txtprenom.getText().toLowerCase());
					user.setMot_de_passe(String.valueOf(txtpassword.getPassword()));
					user.setEmail(txtmail.getText().toLowerCase());
					user.setAdresse(txtadresse.getText().toLowerCase());
					user.setDiscriminator(discriminator);
					
					String message = user.getNom() + " " + user.getPrenom() + " " + user.getMot_de_passe() + " " + user.getAdresse() + " " + user.getDiscriminator();
					JOptionPane.showMessageDialog(null, message);
					boolean test = user.create();					
					if (test) {
						JOptionPane.showMessageDialog(null, "Vous êtes inscrit !");
						inscription.dispose();
						JConnexion f = new JConnexion();
						f.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Ereur lors de l'inscription !");
					}
				}

			}
		});
		btnInscription.setBounds(10,210,334,23);
		contentPane.add(btnInscription);
	}
}
