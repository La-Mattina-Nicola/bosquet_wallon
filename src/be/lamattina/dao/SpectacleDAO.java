package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.lamattina.pojo.Organisateur;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Reservation;
import be.lamattina.pojo.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Spectacle (titre, nbr_place_max, id_salle) " +
				"VALUES ('"
					+ obj.getTitre() + "', '"
					+ obj.getNbr_place_max() + "', '"
					+ obj.getId_salle().getId_planning_salle() + "')";
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spectacle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spectacle find(Spectacle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spectacle> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spectacle findlast() {
		Spectacle s = new Spectacle();
		try {
			String query = "SELECT * FROM Spectacle ORDER BY id_spectacle DESC;";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					s = new Spectacle(result.getInt("id_spectacle"), result.getString("titre"), result.getInt("nbr_place_max"));
				}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Spectacle> findall(int id) {
		List<Spectacle> lst_spectacle = new ArrayList<Spectacle>();
		try {
			String query = "SELECT * from Spectacle WHERE id_salle = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Spectacle s = new Spectacle(result.getInt("id_spectacle"), result.getString("titre"), result.getInt("nbr_place_max"));
					lst_spectacle.add(s);
				}
			return lst_spectacle;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
