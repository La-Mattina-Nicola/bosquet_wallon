package be.lamattina.dao;

import java.sql.Connection;
import java.util.List;

import be.lamattina.pojo.Utilisateur;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);

	// Methode utiliser pour pouvoir faire des recherches sur plusieurs champs de l'objet -> cf : Connexion (email/mdp)
	public abstract T find(T obj);

	public abstract List<T> findall();
	
	public abstract T findlast();

}
