package be.lamattina.jframe;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import be.lamattina.pojo.Organisateur;
import be.lamattina.pojo.Representation;
import be.lamattina.pojo.Spectacle;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Date;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

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
	@SuppressWarnings("deprecation")
	public JCreationRepresentation(Organisateur user, Spectacle s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Création de représentation");

		Date debut = s.getId_salle().getDate_debut();
		debut.setDate(debut.getDate()-1);
		Date fin = s.getId_salle().getDate_fin();
		fin.setDate(fin.getDate()+1);
		
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

		JLabel lblNewLabel_3 = new JLabel(s.getTitre());
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
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recuperer la date choisie
				Date recup_date = DateRepresentation.getDate();
				SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yy");
				String d_debut = fm.format(debut);
				String d_fin = fm.format(fin);
				String message = "Choisissez une date entre : " + d_debut + " et " + d_fin;
				if(recup_date.after(debut) && recup_date.before(fin))
					JOptionPane.showMessageDialog(null, "AVANT " + message);
				else {
					//debut - fin - ouverture
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
					SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					String s_debut = sdf.format(recup_date) + " " + TxtHeureDebut.getText() + ":" + TxtMinuteDebut.getText() + ":00";
					String s_fin = sdf.format(recup_date) + " " + TxtHeureFin.getText() + ":" + TxtMinuteFin.getText() + ":00";
					String s_ouv = sdf.format(recup_date) + " " + TxtHeureOuverture.getText() + ":" + TxtMinuteOuverture.getText() + ":00";
					try {
						Date r_debut, r_fin, r_ouv = new Date();
						r_debut = form.parse(s_debut);
						r_fin = form.parse(s_fin);
						r_ouv = form.parse(s_ouv);
						Representation r = new Representation(r_debut, r_fin, r_ouv);
						s.addRepresentation(r);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}
			}
		});
		BtnValider.setBounds(10, 169, 200, 21);
		contentPane.add(BtnValider);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBounds(220, 168, 125, 23);
		contentPane.add(btnCancel);
	}
}
