package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Configuration;
import be.lamattina.pojo.Spectacle;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Configuration obj) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Configuration (type, description, id_spectacle)"
				+ "Values('"
					+ obj.getType() + "','"
					+ obj.getDescription() + "','"
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
	public boolean delete(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Configuration obj) {
		return false;
	}

	@Override
	public Configuration find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration find(Configuration obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Configuration> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration findlast() {
		Configuration c = new Configuration();
		try {
			String query = "SELECT * FROM Configuration ORDER BY id_configuration DESC;";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					c = new Configuration(
							result.getInt("id_configuration"),
							result.getString("type"),
							result.getString("description"),
							result.getInt("id_spectacle")
						);
				}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Configuration> findall(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
