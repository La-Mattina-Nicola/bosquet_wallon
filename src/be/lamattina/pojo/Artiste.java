package be.lamattina.pojo;

public class Artiste extends Utilisateur {

	public Artiste() {
		// TODO Auto-generated constructor stub
	}

	public Artiste(int id_utilisateur, String nom, String prenom, String mot_de_passe, String email, String adresse) {
		super(id_utilisateur, nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}
	public Artiste(String nom, String prenom, String mot_de_passe, String email, String adresse) {
		super(nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}

}
