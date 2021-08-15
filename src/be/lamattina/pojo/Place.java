package be.lamattina.pojo;

import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Place {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placeDAO = adf.getPlaceDAO();

	private int id_place;
	private float prix;
	private Representation id_representation;
	private Commande id_commande;
	
	public int getId_place() {
		return id_place;
	}

	public void setId_place(int id_place) {
		this.id_place = id_place;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Representation getId_representation() {
		return id_representation;
	}

	public void setId_representation(Representation id_representation) {
		this.id_representation = id_representation;
	}

	public Commande getId_commande() {
		return id_commande;
	}

	public void setId_commande(Commande id_commande) {
		this.id_commande = id_commande;
	}

	public Place() {
		// TODO Auto-generated constructor stub
	}
	public Place(float prix, Representation id_representation) {
		this.prix = prix;
		this.id_representation = id_representation;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Prix : " + prix + " €";
	}

	public void create() {
		placeDAO.create(this);
		List<Categorie> lst_c = this.getId_representation().getId_spectacle().getConfiguration().getCategories();
		for(Categorie c : lst_c) {
			if(c.getPrix() == this.getPrix()) {
				c.setNbr_place_dispo(c.getNbr_place_dispo() - 1);
				c.update(c.getId_categorie());
				break;
			}
		}
		
	}
	
	
}
