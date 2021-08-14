package be.lamattina.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.lamattina.dao.AbstractDAOFactory;
import be.lamattina.dao.DAO;

public class PlanningSalle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planningsalleDAO = adf.getPlanningSalleDAO();

	private int id_planning_salle;
	private Date date_debut;
	private Date date_fin;
	private List<Spectacle> spectacles;
	Spectacle s = new Spectacle();

	public int getId_planning_salle() {
		return id_planning_salle;
	}

	public void setId_planning_salle(int id_planning_salle) {
		this.id_planning_salle = id_planning_salle;
	}
	
	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<Spectacle> getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(List<Spectacle> spectacles) {
		this.spectacles = spectacles;
	}
	
	public void create() {		
		planningsalleDAO.create(this);
	}

	public PlanningSalle() {
		// TODO Auto-generated constructor stub
	}
	
	public PlanningSalle(int id_planning_salle) {
		this.id_planning_salle = id_planning_salle;
	}
	
	public PlanningSalle(int id_planning_salle, Date date_debut, Date date_fin) {
		this.id_planning_salle = id_planning_salle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public PlanningSalle(int id_planning_salle, Date date_debut, Date date_fin, List<Spectacle> spectacles) {
		this.id_planning_salle = id_planning_salle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.spectacles = spectacles;
	}
	public PlanningSalle(Date date_debut, Date date_fin) {
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	@SuppressWarnings("deprecation")
	public boolean verifierdisponibilite() {
		// Recup la liste des salles
		boolean verif = false;
		
		Date date_verif_debut = new Date(this.date_debut.getYear(), this.date_debut.getMonth(), this.date_debut.getDate());
		Date date_verif_fin = new Date(this.date_fin.getYear(), this.date_fin.getYear(), this.date_fin.getDate());
		long this_date_debut = date_verif_debut.getTime();
		long this_date_fin = date_verif_fin.getTime();
		
		List<PlanningSalle> lst_planning = planningsalleDAO.findall();
		
		// Si la liste est vide
		if(lst_planning.size() == 0)
			return true;
		else {
			for (PlanningSalle ps : lst_planning) {
				Date date_debut = new Date(ps.date_debut.getYear(), ps.date_debut.getMonth(), ps.date_debut.getDate());
				Date date_fin = new Date(ps.date_fin.getYear(), ps.date_fin.getMonth(), ps.date_fin.getDate());
				long ps_date_debut = date_debut.getTime();
				long ps_date_fin = date_fin.getTime();
				if(	(this_date_debut > ps_date_debut && this_date_debut < ps_date_fin) ||
					(this_date_fin > ps_date_debut && this_date_fin < ps_date_fin) ||
					(this_date_debut < ps_date_debut && this_date_fin > ps_date_fin) )
					return false;
				else {
					if(this_date_debut == ps_date_debut && this_date_debut == ps_date_fin)
						return false;
					else
						verif = true;
				}
			}
		}	
		return verif;
	}

	public PlanningSalle getlast() {
		return planningsalleDAO.findlast();
	}
	
	public PlanningSalle getId() {
		PlanningSalle ps = planningsalleDAO.find(this.id_planning_salle);
		if (ps == null) {
			return null;
		}
		else {
			List<Spectacle> lst_spectacle = new ArrayList<Spectacle>();
			this.spectacles = s.loadSpectacle(this.id_planning_salle);
			for(Spectacle spec : this.spectacles) {
				spec.setId_salle(this);
				lst_spectacle.add(spec);
			}
			ps.setSpectacles(lst_spectacle);
			return ps;
		}
	}

	public void addSpectacle(Spectacle s) {
		s.create();
	}

}
