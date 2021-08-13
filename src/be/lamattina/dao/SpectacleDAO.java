package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO Spectacle (titre, nbr_place_max, id_salle)"
							+ "Values('"
								+ obj.getTitre() + "','"
								+ obj.getNbr_place_max() + "','"
								+ obj.getId_salle() + "','"
								+ "')");
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
		// TODO Auto-generated method stub
		return null;
	}

}
