package be.lamattina.jframe;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;

public class JCommande extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private double somme = 5;
	private Date date = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCommande frame = new JCommande();
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
	public JCommande() {
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
		
		JLabel TxtMontant = new JLabel("somme");
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
		
		JButton BtnValider = new JButton("Payer");		
		BtnValider.setBounds(474, 150, 125, 22);
		contentPane.add(BtnValider);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(609, 150, 115, 23);
		contentPane.add(btnCancel);
		
		JButton btnRemoveListe = new JButton("Supprimer la liste");
		btnRemoveListe.setBounds(474, 126, 250, 23);
		contentPane.add(btnRemoveListe);
		
		JLabel lblNewLabel_3 = new JLabel("Place :");
		lblNewLabel_3.setBounds(190, 10, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAdd1 = new JButton("Debout");
		btnAdd1.setBounds(349, 30, 89, 23);
		contentPane.add(btnAdd1);
		JLabel lbl_prix1 = new JLabel("prix : ");
		lbl_prix1.setBounds(200, 34, 115, 14);
		contentPane.add(lbl_prix1);
		
		JButton btnAdd2 = new JButton("Argent");
		btnAdd2.setBounds(349, 54, 89, 23);
		contentPane.add(btnAdd2);
		JLabel lbl_prix2 = new JLabel("prix : ");
		lbl_prix2.setBounds(200, 58, 115, 14);
		contentPane.add(lbl_prix2);
		
		JButton btnAdd3 = new JButton("Or");
		btnAdd3.setBounds(349, 78, 89, 23);
		contentPane.add(btnAdd3);
		JLabel lbl_prix3 = new JLabel("prix : ");
		lbl_prix3.setBounds(200, 82, 115, 14);
		contentPane.add(lbl_prix3);
		
		JButton btnAdd4 = new JButton("Diamant");
		btnAdd4.setBounds(349, 102, 89, 23);
		contentPane.add(btnAdd4);
		JLabel lbl_prix4 = new JLabel("prix : ");
		lbl_prix4.setBounds(200, 106, 115, 14);
		contentPane.add(lbl_prix4);
		
		JList list = new JList();
		list.setBounds(474, 23, 250, 97);
		contentPane.add(list);
		
		//Création des lignes
		
	}
}
