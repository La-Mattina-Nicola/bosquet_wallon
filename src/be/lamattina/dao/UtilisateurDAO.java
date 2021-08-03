package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.lamattina.pojo.Utilisateur;
import be.lamattina.pojo.Artiste;
import be.lamattina.pojo.Client;
import be.lamattina.pojo.Gestionnaire;
import be.lamattina.pojo.Organisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO User (nom, prenom, adresse, email, password, discriminator)"
							+ "Values('" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','" + obj.getEmail() + "','"
							+ obj.getMot_de_passe() + "','" + obj.getDiscriminator() + "')");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur find(int id) {
		Utilisateur u = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM User WHERE id = " + id);
			if (result.first()) {
				// Recupérer utilisateur en fonction de son discriminator : Artiste / Client / Gestionnaire / Organisateur
				if (result.getString("discriminator").equals("Artiste")) {
					u = new Artiste(
							result.getInt("id_utilisateur"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("mot_de_passe"),
							result.getString("email"),
							result.getString("adresse")
						);
				} else if (result.getString("discriminator").equals("Client")) {
					u = new Client(
							result.getInt("id_utilisateur"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("mot_de_passe"),
							result.getString("email"),
							result.getString("adresse")
						);
				} else if (result.getString("discriminator").equals("Gestionnaire")) {
					u = new Gestionnaire(
							result.getInt("id_utilisateur"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("mot_de_passe"),
							result.getString("email"),
							result.getString("adresse")
						);
				} else if (result.getString("discriminator").equals("Organisateur")) {
					u = new Organisateur(
							result.getInt("id_utilisateur"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("mot_de_passe"),
							result.getString("email"),
							result.getString("adresse")
						);
				}
				else {
					return null;
				}
			}
		} catch (SQLException e) {
			return null;
		}
		return u;
	}

}
