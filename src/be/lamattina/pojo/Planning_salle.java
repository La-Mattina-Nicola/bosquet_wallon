package be.lamattina.pojo;

import java.util.Date;

public class Planning_salle {

	private int id_planning_salle;
	private Date date_debut;
	private Date date_fin;

	public int getId_planning_salle() {
		return id_planning_salle;
	}

	public void setId_planning_salle(int id_planning_salle) {
		this.id_planning_salle = id_planning_salle;
	}
	
	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	
	public Planning_salle() {
		// TODO Auto-generated constructor stub
	}
}
