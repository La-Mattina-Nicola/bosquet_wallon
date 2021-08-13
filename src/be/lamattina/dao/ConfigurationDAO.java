package be.lamattina.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.lamattina.pojo.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Configuration obj) {
		// TODO Auto-generated method stub
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO Configuraiton (type, description)"
							+ "Values('"
								+ obj.getType() + "','"
								+ obj.getDescription() + "','"
								+ "')");
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

}
