package com.infotel.TpSpringMvc.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresse;
	private String nomRue;
	private int numRue;
	private String ville;
	private int cp;
	
	@OneToMany(mappedBy = "adresse")
	private List<Personne> personnes = new ArrayList<Personne>();
	
	
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", nomRue=" + nomRue + ", numRue=" + numRue + ", ville=" + ville
				+ ", cp=" + cp + "]";
	}
	@PreRemove
	public void deleteNull() {
		for (Personne p : personnes) {
			p.setAdresse(null);
		}
	}
	
	

}
