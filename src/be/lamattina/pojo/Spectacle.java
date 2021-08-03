package be.lamattina.pojo;

import java.util.List;

public class Spectacle {

	private int id_spectacle;
	private String titre;
	private int nbr_place_max;
	private List<Artiste> liste_artistes;
	private Planning_salle id_salle;
	
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
	

	public Planning_salle getId_salle() {
		return id_salle;
	}


	public void setId_salle(Planning_salle id_salle) {
		this.id_salle = id_salle;
	}


	public Spectacle() {
		// TODO Auto-generated constructor stub
	}
}
