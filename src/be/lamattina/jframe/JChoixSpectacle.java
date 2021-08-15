package be.lamattina.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
					JChoixSpectacle frame = new JChoixSpectacle();
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
	public JChoixSpectacle() {

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
					"Statut",
					"id_spectacle",
					"Titre",
					"Date de début",
					"Date de fin"
				}
			) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
		});
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton BtnReserver = new JButton("Reserver");
		BtnReserver.setBounds(10, 229, 200, 21);
		contentPane.add(BtnReserver);
		
		JButton BtnDeco = new JButton("Quitter");
		BtnDeco.setBounds(474, 229, 200, 21);
		contentPane.add(BtnDeco);
	}

}
