package be.lamattina.jframe;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Organisateur;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JListeSpectacle extends JFrame {
	private JTable table;
	private JButton BtnCreerReservation;
	private JButton BtnCreerRepresentation;
	private JButton BtnPayer;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Organisateur user = null;
					JListeSpectacle frame = new JListeSpectacle(user);
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Statut", "Titre","Date de d�but", "Date de fin"}));
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
			}
		});
		btnNewSpectacle.setBounds(10, 222, 150, 23);
		contentPane.add(btnNewSpectacle);
		
		JButton btnNewRepresentation = new JButton("Nouvelle Repr�sentation");
		btnNewRepresentation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Lancer la frame - CREATION REPRESENTATION
				// Si aucun spectacle n'est selectionner - on ne peux pas acceder au menu de cr�ation de repr�sentation.
				int rowSelected = -1;
				rowSelected = table.getSelectedRow();
				if (rowSelected == -1) {
					JOptionPane.showMessageDialog(null, "Selectionner un spectacle pour pouvoir cr�er une repr�sentation !");
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