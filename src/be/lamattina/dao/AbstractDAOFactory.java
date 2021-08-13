package be.lamattina.dao;

import be.lamattina.pojo.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAO<Utilisateur> getUtilisateurDAO();
	public abstract DAO<Artiste> getArtisteDAO();
	public abstract DAO<Spectacle> getSpectacleDAO();
	public abstract DAO<Configuration> getConfigurationDAO();
	public abstract DAO<Categorie> getCategorieDAO();
	public abstract DAO<Reservation> getReservationDAO();
	public abstract DAO<PlanningSalle> getPlanningSalleDAO();
	

	public static AbstractDAOFactory getFactory(int type) {
		switch (type) {
		case DAO_FACTORY:
			return new DAOFactory();
		default:
			return null;
		}
	}
}