package be.lamattina.pojo;

import java.util.Date;

import be.lamattina.dao.*;

public class Reservation {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Reservation> reservationDAO = adf.getReservationDAO();

	private int id_reservation;
	private double solde;
	private double paye;
	private String status;
	private Organisateur id_organisateur;
	private PlanningSalle id_salle;

	public Reservation() {
		// TODO Auto-generated constructor stub
		this.status = "Faux";
		this.paye = 0;
	}
	public Reservation(double solde, Organisateur id_organisateur, PlanningSalle id_salle) {
		this.solde = solde;
		this.paye = 0;
		this.status = "Faux";
		this.id_organisateur = id_organisateur;
		this.id_salle = id_salle;
	}

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

	public PlanningSalle getId_salle() {
		return id_salle;
	}

	public void setId_salle(PlanningSalle id_salle) {
		this.id_salle = id_salle;
	}

	public double getPaye() {
		return paye;
	}

	public void setPaye(double paye) {
		if (this.paye == this.solde)
			this.setStatus("Vrai");
		this.paye = paye;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public void create(Organisateur organisateur) {
		// SET ID_SALLE
		this.id_salle.create();
		reservationDAO.create(this);
	}

	public void calculerPrix() {
		double prix = 0;
		int compteur = 0;
		Date d = this.id_salle.getDate_debut();
		do {
			if(d.getDay() - 1 >= 0 && d.getDay()-1 < 5)
				prix += 3000;
			else
				prix += 4500;
			d.setDate(d.getDate()+1);
			compteur += 1;
		}while(d.before(this.id_salle.getDate_fin()));
		
		//Calcul du tarif dégressif.
		if(compteur == 2)
			prix *= 0.95;
		else if (compteur == 3 && compteur < 7)
			prix *= 0.9;
		else if (compteur >= 7 && compteur < 15)
			prix *= 0.8;
		else if (compteur >= 15)
			prix *= 0.7;
		
		this.solde = prix;
	}
	public void update(PlanningSalle ps) {
		// TODO Auto-generated method stub
		this.setId_salle(ps);
		reservationDAO.update(this);
	}

}
