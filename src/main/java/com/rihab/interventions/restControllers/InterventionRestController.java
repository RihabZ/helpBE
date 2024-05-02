package com.rihab.interventions.restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.Intervention;

import com.rihab.interventions.service.InterventionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InterventionRestController {

	@Autowired
	InterventionService interventionService;

@RequestMapping(path="allInterventions",method = RequestMethod.GET)
public List<Intervention> getAllInterventions() {
	return interventionService.getAllInterventions();
}


@RequestMapping(value="/getByCode/{interCode}",method = RequestMethod.GET)
public Intervention getInterventionById(@PathVariable("interCode") String interCode) {
	return interventionService.getIntervention(interCode);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addInter",method = RequestMethod.POST)

public Intervention createInter(@RequestBody Intervention intervention) {
	return interventionService.saveIntervention(intervention);
}


@RequestMapping(path="/updateInter",method = RequestMethod.PUT)

public Intervention updateIntervention(@RequestBody Intervention intervention) {
		return interventionService.updateIntervention(intervention);
}


@RequestMapping(value="/deleteInter/{interCode}",method = RequestMethod.DELETE)

public void deleteIntervention(@PathVariable("interCode") String interCode)
{
	interventionService.deleteInterventionByCode(interCode);
}


@RequestMapping(value="/intersEqpt/{eqtyCode}",method = RequestMethod.GET)
public List<Intervention> getInterventionsByEquipementCodeEquipement(@PathVariable("eqptCode") String eqptCode) {
		return interventionService.findByEquipementEqptCode(eqptCode);
}


@RequestMapping(value="/searchByDesignation/{eqptDesignation}",method = RequestMethod.GET)
 public List<Intervention>getInterventionByDesignation(@PathVariable("interDesignation") String interDesignation) {
    return interventionService.findByInterDesignation(interDesignation);
}


@RequestMapping(value="/searchByDesignationContains/{interDesignation}",method = RequestMethod.GET)
public List<Intervention> getInterventionByInterDesignationContains(@PathVariable("interDesignation") String interDesignation) {
    return interventionService.findByInterDesignationContains(interDesignation);
}


}
