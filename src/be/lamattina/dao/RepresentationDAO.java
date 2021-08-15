package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import be.lamattina.pojo.Representation;

public class RepresentationDAO extends DAO<Representation> {

	public RepresentationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Representation obj) {
		// TODO Auto-generated method stub
		Timestamp d_b = new Timestamp(obj.getDate_debut().getYear(),obj.getDate_debut().getMonth(), obj.getDate_debut().getDate(), obj.getDate_debut().getHours(), obj.getDate_debut().getMinutes(), 0, 0);
		Timestamp d_f = new Timestamp(obj.getDate_fin().getYear(),obj.getDate_fin().getMonth(), obj.getDate_fin().getDate(), obj.getDate_fin().getHours(), obj.getDate_fin().getMinutes(), 0, 0);
		Timestamp d_o = new Timestamp(obj.getHeure_ouverture().getYear(),obj.getHeure_ouverture().getMonth(), obj.getHeure_ouverture().getDate(), obj.getHeure_ouverture().getHours(), obj.getHeure_ouverture().getMinutes(), 0, 0);
		
		String query = "INSERT INTO Representation (date_debut, date_fin, heure_ouverture, id_spectacle) " +
				"VALUES ('"
					+ d_b + "', '"
					+ d_f + "', '"
					+ d_o + "', '"
					+ obj.getId_spectacle() + "')";
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representation find(Representation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Representation> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Representation> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representation findlast() {
		// TODO Auto-generated method stub
		return null;
	}

}
