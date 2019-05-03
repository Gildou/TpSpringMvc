package com.infotel.TpSpringMvc.service;

import java.util.List;

import com.infotel.TpSpringMvc.metier.Adresse;
import com.infotel.TpSpringMvc.metier.Personne;

public interface Iservice {

	public Personne ajouterPersonne(Personne p);
	
	public void supprimerPersonne(int id);
	public void modifierPersonneParId(String prenom, String nom, int age, Integer id);
	public List<Personne> findAllPersonne();
	public Personne getPersonne(int id);
	public Personne modifierPersonne(Personne p);
	
	public Adresse ajouterAdresse(Adresse a);
	public void supprimerAdresse(int idAdresse);
	public Adresse modifierAdresse(Adresse a);
	public List<Adresse> findAllAdresse();
	public Adresse getAdresse(int idAdresse);
	

}
