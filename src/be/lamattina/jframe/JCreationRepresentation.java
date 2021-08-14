package be.lamattina.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class JCreationRepresentation extends JFrame {
	private JPanel contentPane;
	private JTextField TxtHeureOuverture;
	private JTextField TxtMinuteOuverture;
	private JTextField TxtHeureDebut;
	private JTextField TxtMinuteDebut;
	private JTextField TxtHeureFin;
	private JTextField TxtMinuteFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCreationRepresentation frame = new JCreationRepresentation();
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
	public JCreationRepresentation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Création de représentation");

		JDateChooser DateRepresentation = new JDateChooser();
		DateRepresentation.setBounds(199, 59, 146, 19);
		contentPane.add(DateRepresentation);

		JLabel lblNewLabel = new JLabel("Date de la repr\u00E9senation");
		lblNewLabel.setBounds(10, 65, 146, 13);
		contentPane.add(lblNewLabel);

		TxtHeureOuverture = new JTextField();
		TxtHeureOuverture.setBounds(273, 89, 26, 19);
		contentPane.add(TxtHeureOuverture);
		TxtHeureOuverture.setColumns(10);

		TxtMinuteOuverture = new JTextField();
		TxtMinuteOuverture.setColumns(10);
		TxtMinuteOuverture.setBounds(319, 89, 26, 19);
		contentPane.add(TxtMinuteOuverture);

		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setBounds(309, 93, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Heure d'ouverture des portes");
		lblNewLabel_2.setBounds(10, 93, 242, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Heure du d\u00E9but de la repr\u00E9sentation");
		lblNewLabel_2_1.setBounds(10, 119, 264, 13);
		contentPane.add(lblNewLabel_2_1);

		TxtHeureDebut = new JTextField();
		TxtHeureDebut.setColumns(10);
		TxtHeureDebut.setBounds(273, 115, 26, 19);
		contentPane.add(TxtHeureDebut);

		TxtMinuteDebut = new JTextField();
		TxtMinuteDebut.setColumns(10);
		TxtMinuteDebut.setBounds(320, 115, 26, 19);
		contentPane.add(TxtMinuteDebut);

		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setBounds(309, 119, 45, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Heure de fin de la repr\u00E9sentation");
		lblNewLabel_2_2.setBounds(10, 143, 242, 13);
		contentPane.add(lblNewLabel_2_2);

		TxtHeureFin = new JTextField();
		TxtHeureFin.setColumns(10);
		TxtHeureFin.setBounds(273, 139, 26, 19);
		contentPane.add(TxtHeureFin);

		TxtMinuteFin = new JTextField();
		TxtMinuteFin.setColumns(10);
		TxtMinuteFin.setBounds(320, 139, 26, 19);
		contentPane.add(TxtMinuteFin);

		JLabel lblNewLabel_1_2 = new JLabel(":");
		lblNewLabel_1_2.setBounds(309, 143, 45, 13);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_3 = new JLabel("Titre du Spectacle");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 11, 336, 37);
		contentPane.add(lblNewLabel_3);

		JLabel TxtTitre = new JLabel("");
		TxtTitre.setBounds(273, 73, 122, 13);
		TxtTitre.setText("");
		contentPane.add(TxtTitre);
		
		JButton BtnMenu = new JButton("Menu");
		BtnMenu.setBounds(10, 10, 414, 243);
		
		JButton BtnValider = new JButton("Valider");
		BtnValider.setBounds(10, 169, 200, 21);
		contentPane.add(BtnValider);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(220, 168, 125, 23);
		contentPane.add(btnCancel);
	}
}
