package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.lamattina.pojo.Artiste;

public class ArtisteDAO extends DAO<Artiste> {
	public ArtisteDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Artiste obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Artiste find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artiste find(Artiste obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Artiste> findall() {
		List<Artiste> artistes = new ArrayList<Artiste>();
		try {
			String query = "SELECT * FROM Utilisateur WHERE type_utilisateur ='Artiste'";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Artiste artiste = new Artiste(
							result.getInt("id_utilisateur"),
							result.getString("nom"),
							result.getString("prenom"),
							result.getString("mot_de_passe"),
							result.getString("email"),
							result.getString("adresse"));
					artistes.add(artiste);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistes;
	}

	@Override
	public Artiste findlast() {
		// TODO Auto-generated method stub
		return null;
	}

}
