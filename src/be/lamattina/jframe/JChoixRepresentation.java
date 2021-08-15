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

import be.lamattina.pojo.Spectacle;

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
					JChoixRepresentation frame = new JChoixRepresentation();
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
	public JChoixRepresentation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		// Orga.List<Reservation>
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy", Locale.FRENCH);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(0));
		scrollPane.setViewportView(table);
		
		BtnChoisir = new JButton("Choisir");
		BtnChoisir.setBounds(10, 230, 200, 21);
		contentPane.add(BtnChoisir);
		
		btnCancel = new JButton("Annuler");
		btnCancel.setBounds(224, 229, 200, 23);
		contentPane.add(btnCancel);
		
		JButton BtnMenu = new JButton("Menu");
		BtnMenu.setBounds(10, 10, 414, 243);
	}

}
