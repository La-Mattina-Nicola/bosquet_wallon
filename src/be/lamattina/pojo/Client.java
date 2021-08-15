package be.lamattina.pojo;

import java.util.ArrayList;
import java.util.List;

public class Client extends Utilisateur {

	private List<Spectacle> spectacles = new ArrayList<Spectacle>();
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(int id_utilisateur, String nom, String prenom, String mot_de_passe, String email, String adresse) {
		super(id_utilisateur, nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom, String mot_de_passe, String email, String adresse) {
		super(nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}
	
	public List<Spectacle> chargerSpectacle() {
		Spectacle s = new Spectacle();
		this.setSpectacles(s.getAll());
		return this.getSpectacles();
	}

	public List<Spectacle> getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(List<Spectacle> spectacles) {
		this.spectacles = spectacles;
	}

	public void creerCommande(Commande c) {
		c.create();		
	}

	
}
