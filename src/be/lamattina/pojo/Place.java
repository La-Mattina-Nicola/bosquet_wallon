package be.lamattina.pojo;

public class Place {

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
}
