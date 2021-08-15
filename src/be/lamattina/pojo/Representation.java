package be.lamattina.pojo;

import java.util.Date;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Representation {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> representationDAO = adf.getRepresentationDAO();

	private int id_representation;
	private Date date_debut;
	private Date date_fin;
	private Date heure_ouverture;
	private int id_spectacle;
	
	public int getId_representation() {
		return id_representation;
	}

	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
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

	public Date getHeure_ouverture() {
		return heure_ouverture;
	}

	public void setHeure_ouverture(Date heure_ouverture) {
		this.heure_ouverture = heure_ouverture;
	}

	
	public Representation() {
		// TODO Auto-generated constructor stub
	}

	public Representation(Date date_debut, Date date_fin, Date heure_ouverture) {
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_ouverture = heure_ouverture;
	}

	public int getId_spectacle() {
		return id_spectacle;
	}

	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}

	public void create() {
		// TODO Auto-generated method stub
		representationDAO.create(this);
	}
}
