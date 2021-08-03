package be.lamattina.dao;

import java.sql.*;
import be.lamattina.pojo.*;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = Bosquet_connexion.getInstance();
	
}