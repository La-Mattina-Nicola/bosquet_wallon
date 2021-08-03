package be.lamattina.pojo;

public class Commande {

	private int id_commande;
	private String mode_livraison;
	private String mode_payement;
	private double cout_total;
	private Client id_utilisateur;
	
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

	
	public Commande() {
		// TODO Auto-generated constructor stub
	}
}
