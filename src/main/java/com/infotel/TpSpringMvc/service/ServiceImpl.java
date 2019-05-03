package com.infotel.TpSpringMvc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.TpSpringMvc.dao.AdresseRepository;
import com.infotel.TpSpringMvc.dao.PersonneRepository;
import com.infotel.TpSpringMvc.metier.Adresse;
import com.infotel.TpSpringMvc.metier.Personne;

@Service
public class ServiceImpl implements Iservice {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private AdresseRepository addRep;

	@Override
	public Personne ajouterPersonne(Personne p) {
		return personneRepository.save(p);
	}

	@Override
	public Personne getPersonne(int id) {
		return personneRepository.findById(id).get();
	}

	@Override
	public void supprimerPersonne(int id) {
		personneRepository.deleteById(id);
	}

	@Override
	public void modifierPersonneParId(String prenom, String nom, int age, Integer id) {
		personneRepository.modifierPersonneParId(prenom, nom, age, id);
	}

	@Override
	public List<Personne> findAllPersonne() {
		return (List<Personne>) personneRepository.findAll();
	}

	@Override
	public Personne modifierPersonne(Personne p) {
		return personneRepository.save(p);
	}

	//+++++++++++++++++++Méthode ADRESSE+++++++++++++++++
	
	
	@Override
	public Adresse ajouterAdresse(Adresse a) {
		return addRep.save(a);
	}

	@Override
	public void supprimerAdresse(int idAdresse) {
		addRep.deleteById(idAdresse);
		
	}

	@Override
	public Adresse modifierAdresse(Adresse a) {
		return addRep.save(a);
	}

	@Override
	public List<Adresse> findAllAdresse() {
		return (List<Adresse>) addRep.findAll();
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		return addRep.findById(idAdresse).get();
	}
	
	

}
