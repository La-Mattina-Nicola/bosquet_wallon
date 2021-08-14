package be.lamattina.jframe;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Organisateur;
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
		setBounds(100, 100, 510, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Statut", "Titre","Date de début", "Date de fin"}));
		
		//Création des lignes
		
		// Orga.List<Reservation>
		user.chargerReservation();
		for (var i : user.getReservations()) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			// Reservation.PlanningSalle.List<Spectacle>
			for (var j : i.getId_salle().getSpectacles()) {
				Object[] row = new Object[] {
					i.getStatus(),
					j.getTitre(),
					i.getId_salle().getDate_debut(),
					i.getId_salle().getDate_fin()
				};
				model.addRow(row);
			}
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		// recherche liste spectacle
			// pour chaque spectacle - creer ligne
		// lier la row au table
		
		JButton btnNewSpectacle = new JButton("Nouveau Spectacle");
		btnNewSpectacle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lancer la frame - CREATION SPECTACLE
				JCreationSpectacle frame = new JCreationSpectacle(user);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewSpectacle.setBounds(10, 222, 150, 23);
		contentPane.add(btnNewSpectacle);
		
		JButton btnNewRepresentation = new JButton("Nouvelle Représentation");
		btnNewRepresentation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lancer la frame - CREATION REPRESENTATION
				// Si aucun spectacle n'est selectionner - on ne peux pas acceder au menu de création de représentation.
				int rowSelected = -1;
				rowSelected = table.getSelectedRow();
				if (rowSelected == -1) {
					JOptionPane.showMessageDialog(null, "Selectionner un spectacle pour pouvoir créer une représentation !");
				}
				else {
					
				}
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
		btnQuitter.setBounds(380, 222, 104, 23);
		contentPane.add(btnQuitter);
		
	}
}
