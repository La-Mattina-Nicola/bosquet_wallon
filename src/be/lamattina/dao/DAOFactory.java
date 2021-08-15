package be.lamattina.dao;

import java.sql.*;
import be.lamattina.pojo.*;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = Bosquet_connexion.getInstance();

	@Override
	public DAO<Utilisateur> getUtilisateurDAO() {
		return new UtilisateurDAO(conn);
	}
	@Override
	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}
	@Override
	public DAO<Spectacle> getSpectacleDAO() {
		return new SpectacleDAO(conn);
	}
	@Override
	public DAO<Configuration> getConfigurationDAO() {
		return new ConfigurationDAO(conn);
	}
	@Override
	public DAO<Categorie> getCategorieDAO() {
		return new CategorieDAO(conn);
	}
	@Override
	public DAO<Reservation> getReservationDAO() {
		return new ReservationDAO(conn);
	}
	@Override
	public DAO<PlanningSalle> getPlanningSalleDAO() {
		return new PlanningSalleDAO(conn);
	}
	@Override
	public DAO<Representation> getRepresentationDAO() {
		return new RepresentationDAO(conn);
	}
	@Override
	public DAO<Place> getPlaceDAO() {
		return new PlaceDAO(conn);
	}
	@Override
	public DAO<Commande> getCommandeDAO() {
		return new CommandeDAO(conn);
	}
}