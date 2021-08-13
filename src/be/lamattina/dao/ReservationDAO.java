package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Reservation;

public class ReservationDAO extends DAO<Reservation> {

	public ReservationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Reservation obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO Reservation (solde, paye, status, id_salle, id_organisateur)"
							+ "Values('"
								+ obj.getSolde() + "','"
								+ obj.getPaye() + "','"
								+ obj.getStatus() + "','"
								+ obj.getId_salle().getId_planning_salle() + "','"
								+ obj.getId_organisateur().getId_utilisateur()
								+ "')");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		String query = "UPDATE Reservation SET "
				+ "id_salle = " + obj.getId_salle().getId_planning_salle()
				+ ", paye =" + obj.getPaye()
				+ ", status = '" + obj.getStatus()
				+ "' WHERE "
				+ "(id_organisateur='" + obj.getId_organisateur().getId_utilisateur() + "' AND solde = '" + obj.getSolde() + "');";
		System.out.println(query);
		try {
			
			connect.createStatement()
					.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(Reservation obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findlast() {
		// TODO Auto-generated method stub
		return null;
	}

}
