package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.lamattina.pojo.Categorie;
import be.lamattina.pojo.Configuration;
import be.lamattina.pojo.PlanningSalle;
import be.lamattina.pojo.Spectacle;

public class CategorieDAO extends DAO<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Categorie (cat_type, prix, nbr_place_dispo, nbr_place_max, id_configuration)"
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
		String query = "UPDATE Categorie SET "
				+ "nbr_place_dispo = '" + obj.getNbr_place_dispo()
				+ "' WHERE "
				+ "(id_categorie='" + obj.getId_categorie()
				+ "' AND cat_type = '" + obj.getType()
				+ "' AND nbr_place_max = '" + obj.getNbr_place_max()
				+ "' AND id_configuration = '" + obj.getId_configuration().getId_configuration()
				+ "');";
		System.out.println(query);
		try {
			connect.createStatement()
					.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
		List<Categorie> lst_categorie = new ArrayList<Categorie>();
		try {
			String query = "SELECT * FROM Categorie WHERE id_configuration = " + id + ";";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Categorie cat = new Categorie(
						result.getInt("id_categorie"),
						result.getString("cat_type"),
						result.getFloat("prix"),
						result.getInt("nbr_place_dispo"),
						result.getInt("nbr_place_max")
					);
					lst_categorie.add(cat);
				}
			return lst_categorie;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
