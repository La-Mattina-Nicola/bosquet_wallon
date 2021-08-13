package be.lamattina.pojo;

import java.util.ArrayList;
import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Spectacle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artistedao = adf.getArtisteDAO();


	DAO<Spectacle> spectacledao = adf.getSpectacleDAO();
	
	private int id_spectacle;
	private String titre;
	private int nbr_place_max;
	private List<Artiste> liste_artistes;
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
	
	//Method 
	
	public List<Artiste> findArtiste(){
		List<Artiste> artistes = new ArrayList<Artiste>();
		return artistedao.findall();
	}
	
	public void create() {
		//On crée d'abord le spectacle - ensuite on crée les sous-objets
		spectacledao.create(this);
		this.addConfiguration();
	}

	public void addConfiguration() {
		this.getConfiguration().create();
	}
}
