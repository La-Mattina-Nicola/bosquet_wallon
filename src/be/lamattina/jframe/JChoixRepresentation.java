package be.lamattina.jframe;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Client;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Representation;
import be.lamattina.pojo.Spectacle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JChoixRepresentation extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JButton BtnChoisir;
	private JButton btnCancel;

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
	public JChoixRepresentation(Client user, Spectacle spectacle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Titre : " + spectacle.getTitre());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Objet",
						"Objet",
						"Heure ouverture",
						"Date de début",
						"Date de fin"
					}
				)
			);
		
		//Création des lignes

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd-MM-yy", Locale.FRENCH);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(spectacle.getListe_representation().size() > 0) {
			for (var i : spectacle.getListe_representation()) {
				Object[] row = new Object[] {
						spectacle,
						i,
						format.format(i.getHeure_ouverture()),
						format.format(i.getDate_debut()),
						format.format(i.getDate_fin()),
				};
				model.addRow(row);
			}
		}
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
		
		BtnChoisir = new JButton("Choisir");
		BtnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = -1;
				x = table.getSelectedRow();
				if (x == -1) {
					JOptionPane.showMessageDialog(null, "Selectionner une representation pour lancer la réservation");
				}
				else {
					// Recuperer le spectacle - lancer la fenetre.
					Representation r = (Representation) table.getModel().getValueAt(x, 1);
					r.setId_spectacle(spectacle);
					JCommande frame = new JCommande(user, r, spectacle);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		BtnChoisir.setBounds(10, 230, 200, 21);
		contentPane.add(BtnChoisir);
		
		btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JChoixSpectacle frame = new JChoixSpectacle(user);
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(224, 229, 200, 23);
		contentPane.add(btnCancel);
		
		JButton BtnMenu = new JButton("Menu");
		BtnMenu.setBounds(10, 10, 414, 243);
	}

}
