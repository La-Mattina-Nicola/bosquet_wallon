package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import be.lamattina.pojo.Commande;
import be.lamattina.pojo.PlanningSalle;

public class CommandeDAO extends DAO<Commande> {

	public CommandeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Commande obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Commande (id_utilisateur, mode_livraison, mode_payement, cout_total)"
				+ "Values('"
					+ obj.getId_utilisateur().getId_utilisateur() + "','"
					+ obj.getMode_livraison() + "','"
					+ obj.getMode_payement() + "','"
					+ obj.getCout_total() + "');";
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(Commande obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande findlast() {
		// TODO Auto-generated method stub
		Commande commande = new Commande();
		try {
			String query = "SELECT * FROM Commande ORDER BY id_commande DESC";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.first()) {
					commande = new Commande(result.getInt("id_commande"));
					break;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commande;
	}

}
