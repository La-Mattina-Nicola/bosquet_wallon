package be.lamattina.pojo;

import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Commande {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Commande> commandeDAO = adf.getCommandeDAO();

	private int id_commande;
	private String mode_livraison;
	private String mode_payement;
	private double cout_total;
	private Client id_utilisateur;
	private List<Place> lst_place;
	
	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public String getMode_livraison() {
		return mode_livraison;
	}

	public void setMode_livraison(String mode_livraison) {
		this.mode_livraison = mode_livraison;
	}

	public String getMode_payement() {
		return mode_payement;
	}

	public void setMode_payement(String mode_payement) {
		this.mode_payement = mode_payement;
	}

	public double getCout_total() {
		return cout_total;
	}

	public void setCout_total(double cout_total) {
		this.cout_total = cout_total;
	}

	public Client getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(Client id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public List<Place> getLst_place() {
		return lst_place;
	}

	public void setLst_place(List<Place> lst_place) {
		this.lst_place = lst_place;
	}

	public Commande() {
		// TODO Auto-generated constructor stub
	}
	public Commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	public Commande(Client u, String mode_livraison, String mode_payement, double cout_total) {
		this.id_utilisateur = u;
		this.mode_livraison = mode_livraison;
		this.mode_payement = mode_payement;
		this.cout_total = cout_total;
	}

	public void create() {
		commandeDAO.create(this);
		int x = commandeDAO.findlast().getId_commande();
		this.setId_commande(x);
		for(Place p : this.getLst_place()) {
			p.setId_commande(this);
			p.create();
		}
		
	}
}
