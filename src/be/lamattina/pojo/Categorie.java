package be.lamattina.pojo;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Categorie {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Categorie> categoriedao = adf.getCategorieDAO();

	private int id_categorie;
	private String type;
	private float prix;
	private int nbr_place_dispo;
	private int nbr_place_max;
	private Configuration id_configuration;
	
	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getNbr_place_dispo() {
		return nbr_place_dispo;
	}

	public void setNbr_place_dispo(int nbr_place_dispo) {
		this.nbr_place_dispo = nbr_place_dispo;
	}

	public int getNbr_place_max() {
		return nbr_place_max;
	}

	public void setNbr_place_max(int nbr_place_max) {
		this.nbr_place_max = nbr_place_max;
	}

	public Configuration getId_configuration() {
		return id_configuration;
	}

	public void setId_configuration(Configuration id_configuration) {
		this.id_configuration = id_configuration;
	}

	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(String type, float prix, int nbr_place_dispo, int nbr_place_max) {
		this.type = type;
		this.prix = prix;
		this.nbr_place_dispo = nbr_place_dispo;
		this.nbr_place_max = nbr_place_max;
	}

	public boolean create() {
		return categoriedao.create(this);
	}
}
