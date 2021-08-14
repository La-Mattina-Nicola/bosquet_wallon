package be.lamattina.pojo;

import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class Configuration {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Configuration> configurationdao = adf.getConfigurationDAO();

	private int id_configuration;
	private String type;
	private String description;
	private List<Categorie> categories;
	private int id_spectacle;
	
	public int getId_configuration() {
		return id_configuration;
	}


	public void setId_configuration(int id_configuration) {
		this.id_configuration = id_configuration;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	
	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	public Configuration(String type, String description) {
		this.type = type;
		this.description = description;
	}
	public Configuration(int id_configuration, String type, String description, int id_spectacle) {
		this.id_configuration = id_configuration;
		this.type = type;
		this.description = description;
		this.id_spectacle = id_spectacle;
	}
	public Configuration(String type, String description, List<Categorie> categories) {
		this.type = type;
		this.description = description;
		this.categories = categories;
	}


	public void create() {
		configurationdao.create(this);
		//Recup l'id
		Configuration c = configurationdao.findlast();
		this.setId_configuration(c.getId_configuration());
		for (Categorie cat : this.getCategories()) {
			cat.setId_configuration(this);
			cat.getId_configuration().setId_configuration(c.getId_configuration());
			cat.create();
		}
	}


	public void update(PlanningSalle id_salle) {
		// TODO Auto-generated method stub
		configurationdao.update(this);
	}


	public int getId_spectacle() {
		return id_spectacle;
	}


	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
}
