package be.lamattina.jframe;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Organisateur;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Reservation;
import be.lamattina.pojo.Spectacle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class JListeSpectacle extends JFrame {
	private JTable table;
	private JPanel contentPane;

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
	@SuppressWarnings("serial")
	public JListeSpectacle(Organisateur user) {
		//List<Spectacle> lst_spectacle = user.getListSpectacle();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String titre = "Liste de spectacle de " + user.getNom() + " " + user.getPrenom();
		this.setTitle(titre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 864, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Objet",
						"Statut",
						"id_spectacle",
						"Titre",
						"Date de début",
						"Date de fin"
					}
				)
			);
		
		//Création des lignes
		
		// Orga.List<Reservation>
		user.chargerReservation();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy", Locale.FRENCH);
		if(user.getReservations().size() > 0) {
			for (var i : user.getReservations()) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String debut = format.format(i.getId_salle().getDate_debut());
				String fin = format.format(i.getId_salle().getDate_fin());
				// Reservation.PlanningSalle.List<Spectacle>
				List<Spectacle> lst_spectacle = i.getId_salle().getSpectacles();
				for (var j : lst_spectacle) {
					Object[] row = new Object[] {
						j,
						i.getStatus(),
						j.getId_spectacle(),
						j.getTitre(),
						debut,
						fin
					};
					model.addRow(row);
				}
			}
		}
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(5);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		// recherche liste spectacle
			// pour chaque spectacle - creer ligne
		// lier la row au table
		
		JButton btnNewSpectacle = new JButton("Nouveau Spectacle");
		btnNewSpectacle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lancer la frame - CREATION SPECTACLE
				Reservation r = new Reservation();
				for(Reservation reserv : user.getReservations()) {
					r = reserv;
				}
				JCreationSpectacle frame = new JCreationSpectacle(user.getReservation());
				dispose();
				frame.setVisible(true);
			}
		});
		btnNewSpectacle.setBounds(10, 222, 150, 23);
		contentPane.add(btnNewSpectacle);
		
		JButton btnNewRepresentation = new JButton("Nouvelle Représentation");
		btnNewRepresentation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lancer frame de creation de representation.
			}
		});
		btnNewRepresentation.setBounds(170, 222, 200, 23);
		contentPane.add(btnNewRepresentation);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JConnexion frame = new JConnexion();
				frame.setVisible(true);
			}
		});
		btnQuitter.setBounds(770, 222, 104, 23);
		contentPane.add(btnQuitter);
		
	}
}
