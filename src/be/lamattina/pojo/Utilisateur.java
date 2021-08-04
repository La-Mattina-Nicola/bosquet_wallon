package be.lamattina.pojo;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public abstract class Utilisateur {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Utilisateur> utilisateurdao = adf.getUtilisateurDAO();

	private int id_utilisateur;
	private String nom;
	private String prenom;
	private String mot_de_passe;
	private String email;
	private String adresse;
	private String discriminator;
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	

	public Utilisateur() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Utilisateur(int id_utilisateur, String nom, String prenom, String mot_de_passe, String email,
			String adresse) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.mot_de_passe = mot_de_passe;
		this.email = email;
		this.adresse = adresse;
	}

	public void create() {
		utilisateurdao.create(this);
	}
}
