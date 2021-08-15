package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Place;

public class PlaceDAO extends DAO<Place> {

	public PlaceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Place obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Place (prix, id_representation, id_commande)"
				+ "Values('"
					+ obj.getPrix() + "','"
					+ obj.getId_representation().getId_representation() + "','"
					+ obj.getId_commande().getId_commande() + "');";
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place find(Place obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place findlast() {
		// TODO Auto-generated method stub
		return null;
	}

}
