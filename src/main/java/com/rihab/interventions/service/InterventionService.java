package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Intervention;

public interface InterventionService {
	
	
	Intervention saveIntervention(Intervention inter) ;
	Intervention updateIntervention(Intervention inter);
void deleteIntervention(Intervention inter);
 void deleteInterventionByCode(String code);
 Intervention getIntervention(String code);
List<Intervention> getAllInterventions();


List<Intervention> findByInterDesignation(String desing);
List<Intervention> findByInterDesignationContains(String desing); 






List<Intervention> findByEquipementEqptCode(String eqptCode);


}
