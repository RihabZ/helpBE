package com.rihab.interventions.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Equipement {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "EQPT_CODE",columnDefinition = "VARCHAR(20) ", nullable = false)
private String eqptCode;
@Column(name = "EQPT_DESIGNATION",columnDefinition = "VARCHAR(50)", nullable = false)
private String eqptDesignation;
@Column(name = "EQPT_IDENTIFIANT",columnDefinition = "VARCHAR(50)" )
private String eqptId;


private double eqptPrix;
@Column(name = "EQPT_DT_ACHAT")
private Date eqptDtAchat;
@Column(name = "EQPT_GARANTIE",nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'O'")
private String eqptGarantie;


@Column(name = "EQPT_CRITIQUE",columnDefinition = "VARCHAR(1) DEFAULT 'N'")
private String eqptCritique;


@Column(name = "EQPT_LOCALISATION",columnDefinition = "VARCHAR(200)")
private String eqptLocalisation;


@Column(name = "EQPT_EN_SERVICE", nullable = false,columnDefinition = "VARCHAR(1) DEFAULT 'O'")
private String eqptEnService;


@Column(name = "EQPT_GAR_TYPE_DT_REF", nullable = false)
private String eqptGarTypeDtRef;


@Column(name = "EQPT_USER_CB1",columnDefinition = "VARCHAR(1)DEFAULT '0'"  )
private String eqptUserCB1; 


@Column(name ="EQPT_MACHINE" ,columnDefinition = "VARCHAR(1) DEFAULT 'N'" , nullable = false) 
private String eqptMachine;

private Date eqptDtCreation;

@Column(name ="LOGIN_CRE" ,columnDefinition ="VARCHAR(20)")
private String eqptLoginCreation;

private Date eqptDtMaj;

@Column(name ="LOGIN_MAJ" ,columnDefinition ="VARCHAR(30)")
private String eqptLoginMaj;



private double eqptDureeGarantie;

@Column(name = "EQPT_DT_FIN_GARANTIE")
private Date dateFinGarantie;

@Column(name = "EQPT_SITE_CODE",columnDefinition ="VARCHAR(10)")
private String siteCode;

@Column(name = "EQPT_CENT_CODE",columnDefinition ="VARCHAR(10)")
private String centreCode;


@Column(name = "EQPT_ARTI_CODE",columnDefinition ="VARCHAR(16)")
private String articleCode;

@Column(name = "EQPT_DT_FABRICATION")
private Date dateFabrication;

@Column(name = "EQPT_DT_INSTALLATION")
private Date dateInstallation;

@Column(name = "EQPT_DT_MISE_EN_SERVICE")
private Date dateMiseEnService;

@Column(name = "EQPT_POST_CODE",columnDefinition ="VARCHAR(10)")
private String postCode;

@Column(name = "EQPT_RESS_CODE",columnDefinition ="VARCHAR(10)")
private String ressCode;

@Column(name = "EQPT_DT_DEMONTAGE")
private Date dateDemontage;

@Column(name = "EQPT_DT_REMPLACEMENT")
private Date dateRemplacement;

@Column(name = "EQPT_DT_LIVRAISON")
private Date dateLivraison;





public double getEqptDureeGarantie() {
	return eqptDureeGarantie;
}

public void setEqptDureeGarantie(double eqptDureeGarantie) {
	this.eqptDureeGarantie = eqptDureeGarantie;
}

public Date getDateFinGarantie() {
	return dateFinGarantie;
}

public void setDateFinGarantie(Date dateFinGarantie) {
	this.dateFinGarantie = dateFinGarantie;
}

public String getSiteCode() {
	return siteCode;
}

public void setSiteCode(String siteCode) {
	this.siteCode = siteCode;
}

public String getCentreCode() {
	return centreCode;
}

public void setCentreCode(String centreCode) {
	this.centreCode = centreCode;
}

public String getArticleCode() {
	return articleCode;
}

public void setArticleCode(String articleCode) {
	this.articleCode = articleCode;
}

public Date getDateFabrication() {
	return dateFabrication;
}

public void setDateFabrication(Date dateFabrication) {
	this.dateFabrication = dateFabrication;
}

public Date getDateInstallation() {
	return dateInstallation;
}

public void setDateInstallation(Date dateInstallation) {
	this.dateInstallation = dateInstallation;
}

public Date getDateMiseEnService() {
	return dateMiseEnService;
}

public void setDateMiseEnService(Date dateMiseEnService) {
	this.dateMiseEnService = dateMiseEnService;
}

public String getPostCode() {
	return postCode;
}

public void setPostCode(String postCode) {
	this.postCode = postCode;
}

public String getRessCode() {
	return ressCode;
}

public void setRessCode(String ressCode) {
	this.ressCode = ressCode;
}

public Date getDateDemontage() {
	return dateDemontage;
}

public void setDateDemontage(Date dateDemontage) {
	this.dateDemontage = dateDemontage;
}

public Date getDateRemplacement() {
	return dateRemplacement;
}

public void setDateRemplacement(Date dateRemplacement) {
	this.dateRemplacement = dateRemplacement;
}

public Date getDateLivraison() {
	return dateLivraison;
}

public void setDateLivraison(Date dateLivraison) {
	this.dateLivraison = dateLivraison;
}

@ManyToOne
private Type type;

@JsonIgnore
@OneToMany(mappedBy = "equipement")
private List<Intervention> interventions;


public List<Intervention> getInterventions() {
	return interventions;
}

public void setInterventions(List<Intervention> interventions) {
	this.interventions = interventions;
}

@ManyToOne
private Famille famille;


public Type getType() {
	return type;
}

public void setType(Type type) {
	this.type = type;
}

public Famille getFamille() {
	return famille;
}

public void setFamille(Famille famille) {
	this.famille = famille;
}

public String getEqptCode() {
	return eqptCode;
}

public void setEqptCode(String eqptCode) {
	this.eqptCode = eqptCode;
}

public String getEqptDesignation() {
	return eqptDesignation;
}

public void setEqptDesignation(String eqptDesignation) {
	this.eqptDesignation = eqptDesignation;
}

public String getEqptId() {
	return eqptId;
}

public void setEqptId(String eqptId) {
	this.eqptId = eqptId;
}


public double getEqptPrix() {
	return eqptPrix;
}

public void setEqptPrix(double eqptPrix) {
	this.eqptPrix = eqptPrix;
}

public Date getEqptDtAchat() {
	return eqptDtAchat;
}

public void setEqptDtAchat(Date eqptDtAchat) {
	this.eqptDtAchat = eqptDtAchat;
}

public String getEqptGarantie() {
	return eqptGarantie;
}

public void setEqptGarantie(String eqptGarantie) {
	this.eqptGarantie = eqptGarantie;
}

public String getEqptCritique() {
	return eqptCritique;
}

public void setEqptCritique(String eqptCritique) {
	this.eqptCritique = eqptCritique;
}

public String getEqptLocalisation() {
	return eqptLocalisation;
}

public void setEqptLocalisation(String eqptLocalisation) {
	this.eqptLocalisation = eqptLocalisation;
}


public String getEqptEnService() {
	return eqptEnService;
}

public void setEqptEnService(String eqptEnService) {
	this.eqptEnService = eqptEnService;
}

public String getEqptGarTypeDtRef() {
	return eqptGarTypeDtRef;
}

public void setEqptGarTypeDtRef(String eqptGarTypeDtRef) {
	this.eqptGarTypeDtRef = eqptGarTypeDtRef;
}

public Equipement() {
	super();
	// TODO Auto-generated constructor stub
}





public String getEqptUserCB1() {
	return eqptUserCB1;
}

public void setEqptUserCB1(String eqptUserCB1) {
	this.eqptUserCB1 = eqptUserCB1;
}

public String getEqptMachine() {
	return eqptMachine;
}

public void setEqptMachine(String eqptMachine) {
	this.eqptMachine = eqptMachine;
}

public Date getEqptDtCreation() {
	return eqptDtCreation;
}

public void setEqptDtCreation(Date eqptDtCreation) {
	this.eqptDtCreation = eqptDtCreation;
}

public String getEqptLoginCreation() {
	return eqptLoginCreation;
}

public void setEqptLoginCreation(String eqptLoginCreation) {
	this.eqptLoginCreation = eqptLoginCreation;
}

public Date getEqptDtMaj() {
	return eqptDtMaj;
}

public void setEqptDtMaj(Date eqptDtMaj) {
	this.eqptDtMaj = eqptDtMaj;
}

public String getEqptLoginMaj() {
	return eqptLoginMaj;
}

public void setEqptLoginMaj(String eqptLoginMaj) {
	this.eqptLoginMaj = eqptLoginMaj;
}






public Equipement(String eqptCode, String eqptDesignation, String eqptId, double eqptPrix, Date eqptDtAchat,
		String eqptGarantie, String eqptCritique, String eqptLocalisation, String eqptEnService,
		String eqptGarTypeDtRef, String eqptUserCB1, String eqptMachine, Date eqptDtCreation, String eqptLoginCreation,
		Date eqptDtMaj, String eqptLoginMaj, double eqptDureeGarantie, Date dateFinGarantie, String siteCode,
		String centreCode, String articleCode, Date dateFabrication, Date dateInstallation, Date dateMiseEnService,
		String postCode, String ressCode, Date dateDemontage, Date dateRemplacement, Date dateLivraison, Type type,
		Famille famille) {
	super();
	this.eqptCode = eqptCode;
	this.eqptDesignation = eqptDesignation;
	this.eqptId = eqptId;
	this.eqptPrix = eqptPrix;
	this.eqptDtAchat = eqptDtAchat;
	this.eqptGarantie = eqptGarantie;
	this.eqptCritique = eqptCritique;
	this.eqptLocalisation = eqptLocalisation;
	this.eqptEnService = eqptEnService;
	this.eqptGarTypeDtRef = eqptGarTypeDtRef;
	this.eqptUserCB1 = eqptUserCB1;
	this.eqptMachine = eqptMachine;
	this.eqptDtCreation = eqptDtCreation;
	this.eqptLoginCreation = eqptLoginCreation;
	this.eqptDtMaj = eqptDtMaj;
	this.eqptLoginMaj = eqptLoginMaj;
	this.eqptDureeGarantie = eqptDureeGarantie;
	this.dateFinGarantie = dateFinGarantie;
	this.siteCode = siteCode;
	this.centreCode = centreCode;
	this.articleCode = articleCode;
	this.dateFabrication = dateFabrication;
	this.dateInstallation = dateInstallation;
	this.dateMiseEnService = dateMiseEnService;
	this.postCode = postCode;
	this.ressCode = ressCode;
	this.dateDemontage = dateDemontage;
	this.dateRemplacement = dateRemplacement;
	this.dateLivraison = dateLivraison;
	this.type = type;
	this.famille = famille;
}

public Equipement(String eqptCode, String eqptDesignation, String eqptId, double eqptPrix, Date eqptDtAchat,
		String eqptGarantie, String eqptCritique, String eqptLocalisation, String eqptEnService,
		String eqptGarTypeDtRef, String eqptUserCB1, String eqptMachine, Date eqptDtCreation, String eqptLoginCreation,
		Date eqptDtMaj, String eqptLoginMaj) {
	super();
	this.eqptCode = eqptCode;
	this.eqptDesignation = eqptDesignation;
	this.eqptId = eqptId;
	this.eqptPrix = eqptPrix;
	this.eqptDtAchat = eqptDtAchat;
	this.eqptGarantie = eqptGarantie;
	this.eqptCritique = eqptCritique;
	this.eqptLocalisation = eqptLocalisation;
	this.eqptEnService = eqptEnService;
	this.eqptGarTypeDtRef = eqptGarTypeDtRef;
	this.eqptUserCB1 = eqptUserCB1;
	this.eqptMachine = eqptMachine;
	this.eqptDtCreation = eqptDtCreation;
	this.eqptLoginCreation = eqptLoginCreation;
	this.eqptDtMaj = eqptDtMaj;
	this.eqptLoginMaj = eqptLoginMaj;
}

public Equipement(String eqptCode, String eqptDesignation, String eqptId, String eqptGarantie, String eqptCritique,
		Date eqptDtCreation) {
	super();
	this.eqptCode = eqptCode;
	this.eqptDesignation = eqptDesignation;
	this.eqptId = eqptId;
	this.eqptGarantie = eqptGarantie;
	this.eqptCritique = eqptCritique;
	this.eqptDtCreation = eqptDtCreation;
}













}
