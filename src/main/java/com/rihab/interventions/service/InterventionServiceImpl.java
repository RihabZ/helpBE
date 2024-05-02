package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Intervention;
import com.rihab.interventions.repos.InterventionRepository;
@Service
public class InterventionServiceImpl implements InterventionService {
	
	@Autowired
	InterventionRepository interventionRepository;



@Override
public Intervention saveIntervention(Intervention inter)
{
return interventionRepository.save(inter);

}

@Override
public Intervention updateIntervention(Intervention inter) {
return interventionRepository.save(inter);
}


@Override
public void deleteIntervention(Intervention inter) {
	interventionRepository.delete(inter);
}


@Override
public void deleteInterventionByCode(String code) {
	interventionRepository.deleteById(code);
}


@Override
public Intervention getIntervention(String code) {
return interventionRepository.findById(code).get();
}


@Override
public List<Intervention> getAllInterventions() {
return interventionRepository.findAll();
}



@Override
public List<Intervention> findByInterDesignation(String desing)
{
return interventionRepository.findByInterDesignation(desing);
}
@Override
public List<Intervention> findByInterDesignationContains(String desing)
{
return interventionRepository.findByInterDesignationContains(desing);
}




@Override
public List<Intervention> findByEquipementEqptCode(String eqptCode)
{
return interventionRepository.findByEquipementEqptCode( eqptCode);
	
}











}
