package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
					.executeUpdate(
							"INSERT INTO Utilisateur (nom, prenom, adresse, email, mot_de_passe, type_utilisateur)"
							+ "Values('"
								+ obj.getNom() + "','"
								+ obj.getPrenom() + "','"
								+ obj.getAdresse() + "','"
								+ obj.getEmail() + "','"
								+ obj.getMot_de_passe() + "','"
								+ obj.getDiscriminator()
								+ "')");
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
					.executeQuery("SELECT * FROM Utilisateur WHERE id = " + id);
			if (result.first()) {
				// Recup?rer utilisateur en fonction de son discriminator : Artiste / Client / Gestionnaire / Organisateur
				switch (result.getString("discriminator")) {
				case "Artiste": 
					u = new Artiste(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				case "Gestionnaire":
					u = new Gestionnaire(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				case "Organisateur":
					u = new Organisateur(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				default:
					u = new Client(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				}
			}
		} catch (SQLException e) {
			return null;
		}
		return u;
	}
	
	@Override
	public Utilisateur find(Utilisateur u) {
		Utilisateur user = null;
		try {
			String query = "SELECT * FROM Utilisateur WHERE email='" + u.getEmail() + "' and mot_de_passe='" + u.getMot_de_passe() + "'";
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			if (result.first()) {
				// Recup?rer utilisateur en fonction de son discriminator : Artiste / Client / Gestionnaire / Organisateur
				String discriminator = result.getString("type_utilisateur");
				switch (discriminator) {
				case "Artiste": 
					user = new Artiste(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				case "Gestionnaire":
					user = new Gestionnaire(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				case "Organisateur":
					user = new Organisateur(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				default:
					user = new Client(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("mot_de_passe"), result.getString("email"), result.getString("adresse"));
					break;
				}
			}
		} catch (SQLException e) {
			return null;
		}
		return user;
	}

	@Override
	public List<Utilisateur> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findlast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
