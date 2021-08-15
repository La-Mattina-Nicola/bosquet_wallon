package be.lamattina.pojo;

import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Spectacle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artistedao = adf.getArtisteDAO();

	DAO<Spectacle> spectacleDAO = adf.getSpectacleDAO();
	
	private int id_spectacle;
	private String titre;
	private int nbr_place_max;
	private List<Artiste> liste_artistes;
	private List<Representation> liste_representation;
	private Configuration configuration;
	private PlanningSalle id_salle;
	
	public int getId_spectacle() {
		return id_spectacle;
	}


	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getNbr_place_max() {
		return nbr_place_max;
	}


	public void setNbr_place_max(int nbr_place_max) {
		this.nbr_place_max = nbr_place_max;
	}


	public List<Artiste> getListe_artistes() {
		return liste_artistes;
	}


	public void setListe_artistes(List<Artiste> liste_artistes) {
		this.liste_artistes = liste_artistes;
	}
	

	public PlanningSalle getId_salle() {
		return id_salle;
	}


	public void setId_salle(PlanningSalle id_salle) {
		this.id_salle = id_salle;
	}


	public Configuration getConfiguration() {
		return configuration;
	}


	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}


	public Spectacle() {
		// TODO Auto-generated constructor stub
	}

	public Spectacle(int id_spectacle, String titre, int nbr_place_max, List<Artiste> liste_artistes,
			Configuration configuration, PlanningSalle id_salle) {
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
		this.liste_artistes = liste_artistes;
		this.configuration = configuration;
		this.id_salle = id_salle;
	}
	public Spectacle(int id_spectacle, String titre, int nbr_place_max, Configuration configuration, PlanningSalle id_salle) {
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
		this.configuration = configuration;
		this.id_salle = id_salle;
	}
	public Spectacle(int id_spectacle, String titre, int nbr_place_max, PlanningSalle id_salle) {
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
		this.id_salle = id_salle;
	}
	public Spectacle(int id_spectacle, String titre, int nbr_place_max) {
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
	}

	public Spectacle(String titre, int nbr_place_max, List<Artiste> liste_artistes,
			Configuration configuration, PlanningSalle id_salle) {
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
		this.liste_artistes = liste_artistes;
		this.configuration = configuration;
		this.id_salle = id_salle;
	}
	public Spectacle(String titre, int nbr_place_max, List<Artiste> liste_artistes) {
		this.titre = titre;
		this.nbr_place_max = nbr_place_max;
		this.liste_artistes = liste_artistes;
	}
	public Spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}

	//Method 
	
	public List<Artiste> findArtiste(){
		return artistedao.findall();
	}
	
	public void create() {
		//On crée d'abord le spectacle - ensuite on crée les sous-objets
		spectacleDAO.create(this);
		Spectacle s = spectacleDAO.findlast();
		System.out.println();
		this.setId_spectacle(s.getId_spectacle());
		this.getConfiguration().setId_spectacle(this.getId_spectacle());
		
		this.getConfiguration().create();
		this.getConfiguration().update(this.getId_salle());
		
		for (Artiste a : this.getListe_artistes()) {
			
		}
	}

	public List<Spectacle> loadSpectacle(int id_salle) {
		return spectacleDAO.findall(id_salle);
	}

	public List<Representation> getListe_representation() {
		return liste_representation;
	}

	public void setListe_representation(List<Representation> liste_representation) {
		this.liste_representation = liste_representation;
	}

	public void addRepresentation(Representation r) {
		// TODO Auto-generated method stub
		r.setId_spectacle(this);
		r.create();
	}
	
	public List<Spectacle> getAll() {
		List<Spectacle> lst_spectacle = spectacleDAO.findall();
		//Charger les configurations - categories
		for(Spectacle s : lst_spectacle) {
			s.getConfiguration().chargerCategories();
		}
		return lst_spectacle;
	}
	
	public void chargerRepresentation(){
		Representation r = new Representation();
		this.setListe_representation(r.chargerListe(this.id_spectacle));
	}
}
