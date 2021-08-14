package be.lamattina.jframe;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import be.lamattina.pojo.Organisateur;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Reservation;

@SuppressWarnings("serial")
public class JReservationSalle extends JFrame {
	private JPanel contentPane;
	Date dateDebut = null;
	Date dateFin = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	JLabel LblConfirmer;
	JButton BtnOui;
	JButton BtnNon;
	PlanningSalle planning = new PlanningSalle();
	Reservation r = new Reservation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Organisateur o = new Organisateur();
					//JReservationSalle frame = new JReservationSalle(o);
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
	public JReservationSalle(Organisateur o) {
		r.setId_salle(planning);
		r.setId_organisateur(o);
		o.setReservation(r);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 206, 152);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    List<PlanningSalle> planningSalle = new ArrayList<PlanningSalle>();
	    // BLOQUER LES DATES DEJA RESERVER
	    // pour chaque planning prevu.
	    for(var ps : planningSalle) {
	    	RangeEvaluator evaluator = new RangeEvaluator();
	    	int jour_debut = ps.getDate_debut().getDate()+1;
	    	int jour_fin = ps.getDate_fin().getDate()-1;
	    	Date dateDebut = new Date(ps.getDate_debut().getYear(), ps.getDate_debut().getMonth(), jour_debut);
	    	Date dateFin = new Date(ps.getDate_fin().getYear(), ps.getDate_fin().getMonth(), jour_fin);
			evaluator.setStartDate(dateDebut);
		    evaluator.setEndDate(dateFin);
		    calendar.getDayChooser().addDateEvaluator(evaluator);
		    SwingUtilities.updateComponentTreeUI(calendar);
		}
		contentPane.add(calendar);

		JLabel LblDateDebut = new JLabel("");
		LblDateDebut.setBounds(10, 197, 85, 13);
		contentPane.add(LblDateDebut);

		JLabel LblDateFin = new JLabel("");
		LblDateFin.setBounds(125, 197, 91, 13);
		contentPane.add(LblDateFin);

		LblConfirmer = new JLabel("Confirmez-vous ces deux dates?");
		LblConfirmer.setBounds(10, 221, 206, 13);
		contentPane.add(LblConfirmer);
		LblConfirmer.setVisible(false);
		
		JLabel LblDateDeDebut = new JLabel("Date de début:");
		LblDateDeDebut.setBounds(10, 173, 105, 13);
		contentPane.add(LblDateDeDebut);

		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setBounds(125, 173, 91, 13);
		contentPane.add(lblDateDeFin);
		
		JLabel lblNewLabel = new JLabel("Prix de la salle :");
		lblNewLabel.setBounds(10, 277, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrix = new JLabel("0 €");
		lblPrix.setBounds(141, 277, 75, 14);
		contentPane.add(lblPrix);

		BtnOui = new JButton("Oui");
		BtnOui.setBounds(10, 245, 85, 21);
		contentPane.add(BtnOui);
		BtnOui.setVisible(false);

		BtnNon = new JButton("Non");
		BtnNon.setBounds(131, 245, 85, 21);
		contentPane.add(BtnNon);
		BtnNon.setVisible(false);

		JButton BtnValider_datedebut = new JButton("Valider la date de début");
		JButton BtnValider_datefin = new JButton("Valider la date de fin");
		
		BtnValider_datedebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateDebut == null) {
					dateDebut = new java.sql.Date(calendar.getDate().getTime());
					java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					if(dateDebut.before(now))
					{
						dateDebut = null;
					}
					else
					{
						LblDateDebut.setText(dateFormat.format(dateDebut));
						o.getReservation().getId_salle().setDate_debut(dateDebut);
						BtnValider_datedebut.setVisible(false);
						BtnValider_datefin.setVisible(true);
					}
				}
			}

		});
		BtnValider_datedebut.setBounds(10, 245, 206, 21);
		contentPane.add(BtnValider_datedebut);
		
		
		BtnValider_datefin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateFin == null) 
				{
					dateFin = new java.sql.Date(calendar.getDate().getTime());
					if(dateDebut.after(dateFin) || dateFin.equals(dateDebut))
					{
						dateFin = null;
					}
					else
					{
						o.getReservation().getId_salle().setDate_fin(dateFin);
						LblDateFin.setText(dateFormat.format(dateFin));
						BtnValider_datedebut.setVisible(false);
						BtnValider_datefin.setVisible(false);
						LblConfirmer.setVisible(true);
						BtnOui.setVisible(true);
						BtnNon.setVisible(true);
						o.getReservation().calculerPrix();
						String paye = String.valueOf(o.getReservation().getSolde()) + " €";
						lblPrix.setText(paye);
					}
				}
			}

		});
		BtnValider_datefin.setBounds(10, 245, 206, 21);
		contentPane.add(BtnValider_datefin);
		BtnValider_datefin.setVisible(false);

		BtnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateDebut=null;
				dateFin=null;
				LblDateDebut.setText("");
				LblDateFin.setText("");
				BtnValider_datedebut.setVisible(true);
				BtnValider_datefin.setVisible(false);
				LblConfirmer.setVisible(false);
				BtnOui.setVisible(false);
				BtnNon.setVisible(false);
			}
		});

		BtnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set date selectionnée
				if(o.getReservation().getId_salle().verifierdisponibilite()) {
					r.setId_organisateur(o);					
					// CREATION DE LA RESERVATION
					o.creerReservation(r);
					//Afficher la liste des spectacle
					JListeSpectacle frame = new JListeSpectacle(o);
					frame.setVisible(true);
					dispose();
				}
				else {
					String message = "La salle est déjà réserver aux dates selectionnées !";
					JOptionPane.showMessageDialog(null, message);
					//reset frame
					dateDebut = null;
					dateFin = null;
					LblDateDebut.setText("");
					LblDateFin.setText("");
					BtnValider_datedebut.setVisible(true);
					LblConfirmer.setVisible(false);
					BtnOui.setVisible(false);
					BtnNon.setVisible(false);					
				}
			}
		});

	}
}
