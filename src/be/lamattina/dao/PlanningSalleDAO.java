package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import be.lamattina.pojo.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle> {

	public PlanningSalleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean create(PlanningSalle obj) {
		// TODO Auto-generated method stub
		try {
			Timestamp db = new Timestamp(obj.getDate_debut().getYear(),obj.getDate_debut().getMonth(), obj.getDate_debut().getDate(), 12, 0, 0, 0);
			Timestamp df = new Timestamp(obj.getDate_fin().getYear(), obj.getDate_fin().getMonth(), obj.getDate_fin().getDate(), 12, 0, 0, 0);
			String query = "INSERT INTO Planning_salle (date_debut, date_fin) Values('" + db + "','" + df + "')";
			
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(int id) {
		PlanningSalle ps = new PlanningSalle();
		try {
			String query = "SELECT * from Planning_salle WHERE id_planning_salle=" + id;
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.first()) {
					ps = new PlanningSalle(result.getInt("id_planning_salle"), result.getDate("date_debut"),result.getDate("date_fin"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public List<PlanningSalle> findall() {
		List<PlanningSalle> lst_planning = new ArrayList<PlanningSalle>();
		try {
			String query = "SELECT * from Planning_salle";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					PlanningSalle ps = new PlanningSalle(result.getInt("id_planning_salle"), result.getDate("date_debut"),result.getDate("date_fin"));
					lst_planning.add(ps);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst_planning;
	}

	@Override
	public PlanningSalle findlast() {
		// TODO Auto-generated method stub
		PlanningSalle ps = new PlanningSalle();
		try {
			String query = "SELECT * FROM Planning_salle ORDER BY id_planning_salle DESC";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.first()) {
					ps = new PlanningSalle(result.getInt("id_planning_salle"), result.getDate("date_debut"), result.getDate("date_fin"));
					break;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PlanningSalle find(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanningSalle> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
