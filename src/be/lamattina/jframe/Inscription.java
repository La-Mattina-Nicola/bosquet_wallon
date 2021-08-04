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

public class Inscription extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtmail;
	private JTextField txtrue;
	private JTextField txtnumero;
	private JTextField txtville;

	private JFrame inscription = this;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription frame = new Inscription();
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
	public Inscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.orange);
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setBounds(97, 3, 253, 38);
		contentPane.add(lblInscription);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(97, 52, 55, 14);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(97, 77, 55, 14);
		contentPane.add(lblPrenom);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(97, 127, 55, 14);
		contentPane.add(lblEmail);

		JLabel lbltype = new JLabel("Type :");
		lbltype.setBounds(97, 152, 55, 14);
		contentPane.add(lbltype);

		JLabel lblRue = new JLabel("Rue :");
		lblRue.setBounds(97, 177, 55, 14);
		contentPane.add(lblRue);

		JLabel lblN = new JLabel("N\u00B0 :");
		lblN.setBounds(288, 180, 31, 14);
		contentPane.add(lblN);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(97, 202, 46, 14);
		contentPane.add(lblVille);

		JLabel lblPassword = new JLabel("Mot de passe :");
		lblPassword.setBounds(97, 102, 78, 14);
		contentPane.add(lblPassword);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Artiste", "Client", "Gestionnaire" }));
		comboBox.setBounds(185, 151, 165, 22);
		contentPane.add(comboBox);

		txtnom = new JTextField();
		txtnom.setBounds(185, 49, 165, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);

		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(185, 74, 165, 20);
		contentPane.add(txtprenom);

		txtmail = new JTextField();
		txtmail.setColumns(10);
		txtmail.setBounds(185, 127, 165, 20);
		contentPane.add(txtmail);

		txtrue = new JTextField();
		txtrue.setColumns(10);
		txtrue.setBounds(185, 177, 102, 20);
		contentPane.add(txtrue);

		txtnumero = new JTextField();
		txtnumero.setColumns(10);
		txtnumero.setBounds(309, 177, 41, 20);
		contentPane.add(txtnumero);

		txtville = new JTextField();
		txtville.setColumns(10);
		txtville.setBounds(185, 202, 165, 20);
		contentPane.add(txtville);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				inscription.dispose();
				// Afficher la fenetre de connexion
				Connexion f = new Connexion();
				f.setVisible(true);
			}
		});
		btnAnnuler.setBounds(97,255,253,23);
		contentPane.add(btnAnnuler);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addMouseListener(new MouseAdapter() {
			@Override
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent e) {
				if (txtprenom.getText().isEmpty() && txtnom.getText().isEmpty() && txtpassword.getText().isEmpty()
						&& txtmail.getText().isEmpty() && txtrue.getText().isEmpty() && txtnumero.getText().isEmpty()
						&& txtville.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tout les champs doivent être complet !");
				} else {
					Utilisateur u = null;
					if (comboBox.getSelectedItem() == "Artiste") {
						u = new Artiste();
						u.setDiscriminator("Artiste");
					} else if (comboBox.getSelectedItem() == "Client") {
						u = new Client();
						u.setDiscriminator("Client");
					} else if (comboBox.getSelectedItem() == "Organisateur") {
						u = new Organisateur();
						u.setDiscriminator("Organisateur");
					}
					u.setPrenom(txtprenom.getText().toLowerCase());
					u.setNom(txtnom.getText().toLowerCase());
					u.setMot_de_passe(txtpassword.getText());
					u.setEmail(txtmail.getText().toLowerCase());
					String adresse = txtrue.getText().toLowerCase() + " " + txtnumero.getText() + " " + txtville.getText().toLowerCase();
					u.setAdresse(adresse);
					u.create();

					JOptionPane.showMessageDialog(null, "Vous êtes inscrit !");

					inscription.dispose();
					// Afficher la fenetre de connexion
					Connexion f = new Connexion();
					f.setVisible(true);
				}

			}
		});
		btnInscription.setBounds(97,227,253,23);
		contentPane.add(btnInscription);

	txtpassword=new JPasswordField();txtpassword.setBounds(185,99,165,20);contentPane.add(txtpassword);

}}
