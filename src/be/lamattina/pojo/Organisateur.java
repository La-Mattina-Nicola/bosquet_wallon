package be.lamattina.pojo;

import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Utilisateur {
	
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private Reservation reservation;

	public Organisateur() {
		// TODO Auto-generated constructor stub
	}
	public Organisateur(int id) {
		// TODO Auto-generated constructor stub
		super(id);
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
		Reservation r = new Reservation();
		
		if(this.reservations.size() == 0)
			return false;
		else {
			this.reservations = r.getAll(this);
			return true;
		}
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
