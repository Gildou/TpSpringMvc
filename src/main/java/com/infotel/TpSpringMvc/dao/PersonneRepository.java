package com.infotel.TpSpringMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TpSpringMvc.metier.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

	@Transactional
	@Modifying
	@Query("update Personne p set p.prenom = ?1, p.nom = ?2, p.age =?3 where p.id = ?4")
	public void modifierPersonneParId(String prenom, String nom, int age, Integer id);

}
