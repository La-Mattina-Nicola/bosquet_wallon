package be.lamattina.pojo;

public class Configuration {

	private int id_configuration;
	private String type;
	private String description;
	private Spectacle id_spectacle;
	
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

	public Spectacle getId_spectacle() {
		return id_spectacle;
	}


	public void setId_spectacle(Spectacle id_spectacle) {
		this.id_spectacle = id_spectacle;
	}


	public Configuration() {
		// TODO Auto-generated constructor stub
	}
}
