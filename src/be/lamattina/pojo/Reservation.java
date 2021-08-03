package be.lamattina.pojo;

public class Reservation {

	private int id_reservation;
	private double solde;
	private Organisateur id_organisateur;
	private Planning_salle id_salle;
	
	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Organisateur getId_organisateur() {
		return id_organisateur;
	}

	public void setId_organisateur(Organisateur id_organisateur) {
		this.id_organisateur = id_organisateur;
	}

	public Planning_salle getId_salle() {
		return id_salle;
	}

	public void setId_salle(Planning_salle id_salle) {
		this.id_salle = id_salle;
	}


	public Reservation() {
		// TODO Auto-generated constructor stub
	}
}
