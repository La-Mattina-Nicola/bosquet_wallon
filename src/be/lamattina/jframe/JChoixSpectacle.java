package be.lamattina.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.lamattina.pojo.Client;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Spectacle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JChoixSpectacle extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	@SuppressWarnings("serial")
	public JChoixSpectacle(Client user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		setTitle("Choix spectacle");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 216);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Objet",
						"Objet",
						"Statut",
						"id_spectacle",
						"Titre",
						"Date de début",
						"Date de fin"
					}
				)
			);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Objet",
					"Objet",
					"id_spectacle",
					"Titre"
				}
			) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		user.chargerSpectacle();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(user.getSpectacles().size() > 0) {
			for (var i : user.getSpectacles()) {
				Object[] row = new Object[] {
						i,
						i.getId_salle(),
						i.getId_spectacle(),
						i.getTitre()
				};
				model.addRow(row);
			}
		}
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
		
		JButton BtnReserver = new JButton("Reserver");
		BtnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = -1;
				x = table.getSelectedRow();
				if (x == -1) {
					JOptionPane.showMessageDialog(null, "Selectionner un spectacle pour choisir une representation");
				}
				else {
					// Recuperer le spectacle - lancer la fenetre.
					Spectacle s = (Spectacle) table.getModel().getValueAt(x, 0);
					PlanningSalle ps = (PlanningSalle) table.getModel().getValueAt(x, 1);
					s.chargerRepresentation();
					JChoixRepresentation frame = new JChoixRepresentation(user, s);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		BtnReserver.setBounds(10, 229, 200, 21);
		contentPane.add(BtnReserver);
		
		JButton BtnDeco = new JButton("Quitter");
		BtnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JConnexion frame = new JConnexion();
				frame.setVisible(true);
			}
		});
		BtnDeco.setBounds(474, 229, 200, 21);
		contentPane.add(BtnDeco);
	}

}
