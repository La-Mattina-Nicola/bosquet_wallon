package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Categorie;

public class CategorieDAO extends DAO<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Categorie (type, prix, nbr_place_dispo, nbr_place_max, id_configuration)"
				+ "Values('"
					+ obj.getType() + "',"
					+ obj.getPrix() + ",'"
					+ obj.getNbr_place_dispo() + "','"
					+ obj.getNbr_place_max() + "','"
					+ obj.getId_configuration().getId_configuration() + "')";
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie find(Categorie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie findlast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
