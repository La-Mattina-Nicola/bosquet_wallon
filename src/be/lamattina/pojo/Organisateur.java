package be.lamattina.pojo;

public class Organisateur extends Utilisateur {

	public Organisateur() {
		// TODO Auto-generated constructor stub
	}

	public Organisateur(int id_utilisateur, String nom, String prenom, String mot_de_passe, String email,
			String adresse) {
		super(id_utilisateur, nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String nom, String prenom, String mot_de_passe, String email,
			String adresse) {
		super(nom, prenom, mot_de_passe, email, adresse);
		// TODO Auto-generated constructor stub
	}

}
