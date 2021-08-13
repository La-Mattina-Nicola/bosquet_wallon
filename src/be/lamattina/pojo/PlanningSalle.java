package be.lamattina.pojo;

import java.util.Date;
import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class PlanningSalle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planningsalleDAO = adf.getPlanningSalleDAO();

	private int id_planning_salle;
	private Date date_debut;
	private Date date_fin;
	private List<Spectacle> lst_spectacle;

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


	public PlanningSalle() {
		// TODO Auto-generated constructor stub
	}
	public PlanningSalle(int id_planning_salle, Date date_debut, Date date_fin) {
		this.id_planning_salle = id_planning_salle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public PlanningSalle(Date date_debut, Date date_fin) {
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public void create() {		
		planningsalleDAO.create(this);
	}

	public boolean verifierdisponibilite() {
		// Recup la liste des salles
		boolean verif = false;
		Date date_debut_this = new Date(this.date_debut.getYear(), this.date_debut.getMonth(), this.date_debut.getDate());
		Date date_fin_this = new Date(this.date_fin.getYear(), this.date_fin.getYear(), this.date_fin.getDate());
		
		long date_debut_verif_this = date_debut.getTime();
		long date_fin_verif_this = date_fin.getTime();
		
		List<PlanningSalle> lst_planning = planningsalleDAO.findall();
		
		// Si la liste est vide
		if(lst_planning.size() == 0)
			return true;
		else {
			for (PlanningSalle ps : lst_planning) {
				Date date_debut = new Date(ps.date_debut.getYear(), ps.date_debut.getMonth(), ps.date_debut.getDate());
				Date date_fin = new Date(ps.date_fin.getYear(), ps.date_fin.getMonth(), ps.date_fin.getDate());
				long date_debut_verif = date_debut.getTime();
				long date_fin_verif = date_fin.getTime();
				
				if((date_debut_verif > date_debut_verif_this && date_debut_verif < date_fin_verif) ||
					(date_fin_verif_this > date_debut_verif && date_fin_verif_this < date_fin_verif) ||
					(date_debut_verif_this < date_debut_verif && date_fin_verif_this > date_fin_verif))
					return false;
				else {
					if(date_debut_verif_this == date_debut_verif && date_fin_verif_this == date_fin_verif)
						return false;
					else
						verif = true;
				}
			}
		}	
		return verif;
	}

	public PlanningSalle getlast() {
		return planningsalleDAO.findlast();
	}
}
