package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Intervention;

public interface InterventionRepository extends JpaRepository<Intervention, String> {

	List<Intervention> findByInterDesignation(String desing);
	 List<Intervention> findByInterDesignationContains(String desing); 
	 
	 
	 
	 List<Intervention> findByEquipementEqptCode(String eqtyCode);

}
