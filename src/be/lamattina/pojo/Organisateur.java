package be.lamattina.pojo;

import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Utilisateur {
	
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private Reservation r = new Reservation();

	public Organisateur() {
		// TODO Auto-generated constructor stub
	}

	public Organisateur(int id_utilisateur, String nom, String prenom, String mot_de_passe, String email,
			String adresse) {
		super(id_utilisateur, nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String nom, String prenom, String mot_de_passe, String email,
			String adresse) {
		super(nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}

	public void addSpectacle(Spectacle s) {
		s.create();
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void creerReservation(Reservation r) {
		r.create(this);
		PlanningSalle ps = r.getId_salle().getlast();
		r.setId_salle(ps);
		r.update(ps);
	}

	public boolean chargerReservation() {
		this.reservations = r.reservationDAO.findall();
		if(this.reservations == null)
			return false;
		else
			return true;
	}
}
