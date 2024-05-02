package com.rihab.interventions.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Intervention {
	@Id
    @Column(name = "INTE_CODE",columnDefinition = "VARCHAR(10) ", nullable = false)
    	private String interCode;
	
	@Column(name = "INTE_DESIGNATION",columnDefinition = "VARCHAR(50)", nullable = false)
    private String interDesignation;
	
	 @Column(name = "INTE_DECL_NUMERO_ORIG")
	    private Long declNumeroOrig;
	@Column(name = "INTE_INTS_CODE",columnDefinition = "VARCHAR(10) ", nullable = false)
    private String interStatut;
	
	 @Column(name = "INTE_DT_CREATION", nullable = false)
	    private Date dateCreation;

	    @Column(name = "INTE_DT_CLOTURE")
	    private Date dateCloture;

	    @Column(name = "INTE_DESCRIPTION_PANNE")
	    private String descriptionPanne;

	    @Column(name = "INTE_DESCRIPTION")
	    private String description;

	    @Column(name = "INTE_DATE_PREVUE")
	    private Date datePrevue;

	    @Column(name = "INTE_HEURE_PREVUE",columnDefinition = "VARCHAR(5) ")
	    private String heurePrevue;
	    
	    @Column(name = "INTE_DUREE_PREVUE")
	    private Integer dureePrevue;
	    
	    @Column(name = "INTE_UNIT_CODE_DUREE")
	    private String unitCodeDuree;
	    
	    @Column(name = "INTE_LOCALISATION",columnDefinition = "VARCHAR(200) ")
	    private String intervLocalisation;
	    
	    @Column(name = "INTE_SOUS_GARANTIE",columnDefinition = "DEFAULT 'N'", nullable = false)
	    private String SousGarantie;

	    @Column(name = "INTE_SOUS_CONTRAT",columnDefinition = "DEFAULT 'N'", nullable = false)
	    private String sousContrat;
 //zedthom 5atr mwjoudin fl capturet 
	    private String demandeur;
	    private String postDemandeur;
	    
	    
	    @Column(name = "INTE_DT_REALISATION")
	    private Date dtRealisation;

	    @Column(name = "INTE_HEURE_REALISATION",columnDefinition = "VARCHAR(5)")
	    private String heureRealisation;

	    @Column(name = "INTE_DUREE_REALISATION")
	    private Long dureeRealisation;

	    @Column(name = "INTE_COMPTE_RENDU", length = 4000)
	    private String compteRendu;
// mawjouda fl cpat ka urgence 
	    @Column(name = "INTE_PRIORITE", nullable = false,  columnDefinition = "VARCHAR(10)")
	    private String interventionPriorité;
// mawjoudin fl capt
	    @Column(name = "INTE_CAUSE", nullable = false,  columnDefinition = "VARCHAR(30)")
	    private String interventionCause;
	    
	    @Column(name = "INTE_OBSERVATION", nullable = false,  columnDefinition = "VARCHAR(30)")
	    private String interventionObservation;
	    
	    
	    
	    @Column(name = "INTE_MACHINE_ARRET",columnDefinition = "DEFAULT 'Non'", nullable = false)
	    private String machineArret;

	    @Column(name = "INTE_DUREE_ARRET")
	    private Long dureeArret;
	    
	    @Column(name = "INTE_HEURE_Arret",columnDefinition = "VARCHAR(5)")
	    private String heureArret;

	    
	    private double interMtHebergement;
	    private double interMtDeplacement;
	    
	    private String interDomaine;
	    
	    private Long difficulté;
	    
	    @ManyToOne
	    private Equipement equipement;



		public Intervention() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Intervention(String interCode, String interDesignation, Long declNumeroOrig, String interStatut,
				Date dateCreation, Date dateCloture, String descriptionPanne, String description, Date datePrevue,
				String heurePrevue, Integer dureePrevue, String unitCodeDuree, String intervLocalisation,
				String sousGarantie, String sousContrat, String demandeur, String postDemandeur, Date dtRealisation,
				String heureRealisation, Long dureeRealisation, String compteRendu, String interventionPriorité,
				String interventionCause, String interventionObservation, String machineArret, Long dureeArret,
				double interMtHebergement, double interMtDeplacement, String interDomaine, Long difficulté,  Equipement equipement) {
			super();
			this.interCode = interCode;
			this.interDesignation = interDesignation;
			this.declNumeroOrig = declNumeroOrig;
			this.interStatut = interStatut;
			this.dateCreation = dateCreation;
			this.dateCloture = dateCloture;
			this.descriptionPanne = descriptionPanne;
			this.description = description;
			this.datePrevue = datePrevue;
			this.heurePrevue = heurePrevue;
			this.dureePrevue = dureePrevue;
			this.unitCodeDuree = unitCodeDuree;
			this.intervLocalisation = intervLocalisation;
			SousGarantie = sousGarantie;
			this.sousContrat = sousContrat;
			this.demandeur = demandeur;
			this.postDemandeur = postDemandeur;
			this.dtRealisation = dtRealisation;
			this.heureRealisation = heureRealisation;
			this.dureeRealisation = dureeRealisation;
			this.compteRendu = compteRendu;
			this.interventionPriorité = interventionPriorité;
			this.interventionCause = interventionCause;
			this.interventionObservation = interventionObservation;
			this.machineArret = machineArret;
			this.dureeArret = dureeArret;
			this.interMtHebergement = interMtHebergement;
			this.interMtDeplacement = interMtDeplacement;
			this.interDomaine = interDomaine;
			this.difficulté = difficulté;
			this.equipement=equipement;
		}

		@Override
		public String toString() {
			return "Intervention [interCode=" + interCode + ", interDesignation=" + interDesignation
					+ ", declNumeroOrig=" + declNumeroOrig + ", interStatut=" + interStatut + ", dateCreation="
					+ dateCreation + ", dateCloture=" + dateCloture + ", descriptionPanne=" + descriptionPanne
					+ ", description=" + description + ", datePrevue=" + datePrevue + ", heurePrevue=" + heurePrevue
					+ ", dureePrevue=" + dureePrevue + ", unitCodeDuree=" + unitCodeDuree + ", intervLocalisation="
					+ intervLocalisation + ", SousGarantie=" + SousGarantie + ", sousContrat=" + sousContrat
					+ ", demandeur=" + demandeur + ", postDemandeur=" + postDemandeur + ", dtRealisation="
					+ dtRealisation + ", heureRealisation=" + heureRealisation + ", dureeRealisation="
					+ dureeRealisation + ", compteRendu=" + compteRendu + ", interventionPriorité="
					+ interventionPriorité + ", interventionCause=" + interventionCause + ", interventionObservation="
					+ interventionObservation + ", machineArret=" + machineArret + ", dureeArret=" + dureeArret
					+ ", interMtHebergement=" + interMtHebergement + ", interMtDeplacement=" + interMtDeplacement
					+ ", interDomaine=" + interDomaine + ", difficulté=" + difficulté + "]";
		}

		public Intervention(String interCode, String interDesignation, Long declNumeroOrig, String interStatut,
				Date dateCreation, String descriptionPanne, String description, Date datePrevue, String heurePrevue,
				Integer dureePrevue, String unitCodeDuree, String intervLocalisation, String sousGarantie,
				String sousContrat, String demandeur, String postDemandeur, String interventionPriorité,
				String machineArret,String heureArret, Long dureeArret, Equipement equipement) {
			super();
			this.interCode = interCode;
			this.interDesignation = interDesignation;
			this.declNumeroOrig = declNumeroOrig;
			this.interStatut = interStatut;
			this.dateCreation = dateCreation;
			this.descriptionPanne = descriptionPanne;
			this.description = description;
			this.datePrevue = datePrevue;
			this.heurePrevue = heurePrevue;
		this.dureePrevue = dureePrevue;
			this.unitCodeDuree = unitCodeDuree;
			this.intervLocalisation = intervLocalisation;
			this.SousGarantie = sousGarantie;
			this.sousContrat = sousContrat;
			this.demandeur = demandeur;
			this.postDemandeur = postDemandeur;
			this.interventionPriorité = interventionPriorité;
			this.machineArret = machineArret;
			this.heureArret=heureArret;
			this.dureeArret = dureeArret;
			this.equipement=equipement;
		}

		public String getInterCode() {
			return interCode;
		}

		public void setInterCode(String interCode) {
			this.interCode = interCode;
		}

		public String getInterDesignation() {
			return interDesignation;
		}

		public void setInterDesignation(String interDesignation) {
			this.interDesignation = interDesignation;
		}

		public Long getDeclNumeroOrig() {
			return declNumeroOrig;
		}

		public void setDeclNumeroOrig(Long declNumeroOrig) {
			this.declNumeroOrig = declNumeroOrig;
		}

		public String getInterStatut() {
			return interStatut;
		}

		public void setInterStatut(String interStatut) {
			this.interStatut = interStatut;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Date getDateCloture() {
			return dateCloture;
		}

		public void setDateCloture(Date dateCloture) {
			this.dateCloture = dateCloture;
		}

		public String getDescriptionPanne() {
			return descriptionPanne;
		}

		public void setDescriptionPanne(String descriptionPanne) {
			this.descriptionPanne = descriptionPanne;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDatePrevue() {
			return datePrevue;
		}

		public void setDatePrevue(Date datePrevue) {
			this.datePrevue = datePrevue;
		}

		public String getHeurePrevue() {
			return heurePrevue;
		}

		public void setHeurePrevue(String heurePrevue) {
			this.heurePrevue = heurePrevue;
		}

		public Integer getDureePrevue() {
			return dureePrevue;
		}

		public void setDureePrevue(Integer dureePrevue) {
			this.dureePrevue = dureePrevue;
		}

		public String getUnitCodeDuree() {
			return unitCodeDuree;
		}

		public void setUnitCodeDuree(String unitCodeDuree) {
			this.unitCodeDuree = unitCodeDuree;
		}

		public String getIntervLocalisation() {
			return intervLocalisation;
		}

		public void setIntervLocalisation(String intervLocalisation) {
			this.intervLocalisation = intervLocalisation;
		}

		public String getSousGarantie() {
			return SousGarantie;
		}

		public void setSousGarantie(String sousGarantie) {
			SousGarantie = sousGarantie;
		}

		public String getSousContrat() {
			return sousContrat;
		}

		public void setSousContrat(String sousContrat) {
			this.sousContrat = sousContrat;
		}

		public String getDemandeur() {
			return demandeur;
		}

		public void setDemandeur(String demandeur) {
			this.demandeur = demandeur;
		}

		public String getPostDemandeur() {
			return postDemandeur;
		}

		public void setPostDemandeur(String postDemandeur) {
			this.postDemandeur = postDemandeur;
		}

		public Date getDtRealisation() {
			return dtRealisation;
		}

		public void setDtRealisation(Date dtRealisation) {
			this.dtRealisation = dtRealisation;
		}

		public String getHeureRealisation() {
			return heureRealisation;
		}

		public void setHeureRealisation(String heureRealisation) {
			this.heureRealisation = heureRealisation;
		}

		public Long getDureeRealisation() {
			return dureeRealisation;
		}

		public void setDureeRealisation(Long dureeRealisation) {
			this.dureeRealisation = dureeRealisation;
		}

		public String getCompteRendu() {
			return compteRendu;
		}

		public void setCompteRendu(String compteRendu) {
			this.compteRendu = compteRendu;
		}

		public String getInterventionPriorité() {
			return interventionPriorité;
		}

		public void setInterventionPriorité(String interventionPriorité) {
			this.interventionPriorité = interventionPriorité;
		}

		public String getInterventionCause() {
			return interventionCause;
		}

		public void setInterventionCause(String interventionCause) {
			this.interventionCause = interventionCause;
		}

		public String getInterventionObservation() {
			return interventionObservation;
		}

		public void setInterventionObservation(String interventionObservation) {
			this.interventionObservation = interventionObservation;
		}

		public String getMachineArret() {
			return machineArret;
		}

		public void setMachineArret(String machineArret) {
			this.machineArret = machineArret;
		}

		public Long getDureeArret() {
			return dureeArret;
		}

		public void setDureeArret(Long dureeArret) {
			this.dureeArret = dureeArret;
		}

		public String getHeureArret() {
			return heureArret;
		}

		public void setHeureArret(String heureArret) {
			this.heureArret = heureArret;
		}

		public double getInterMtHebergement() {
			return interMtHebergement;
		}

		public void setInterMtHebergement(double interMtHebergement) {
			this.interMtHebergement = interMtHebergement;
		}

		public double getInterMtDeplacement() {
			return interMtDeplacement;
		}

		public void setInterMtDeplacement(double interMtDeplacement) {
			this.interMtDeplacement = interMtDeplacement;
		}

		public String getInterDomaine() {
			return interDomaine;
		}

		public void setInterDomaine(String interDomaine) {
			this.interDomaine = interDomaine;
		}

		public Long getDifficulté() {
			return difficulté;
		}

		public void setDifficulté(Long difficulté) {
			this.difficulté = difficulté;
		}

		public Equipement getEquipement() {
			return equipement;
		}

		public void setEquipement(Equipement equipement) {
			this.equipement = equipement;
		}
	    

	    
}

