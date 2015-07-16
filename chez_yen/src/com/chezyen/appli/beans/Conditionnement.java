package com.chezyen.appli.beans;

public class Conditionnement {

	//DECLARATIONS
	private int idCondi;
	private int idProduit;
	private int quantite;
	private String designationCondi;
	
	//CONSTRUCTEUR
	public Conditionnement(int idCondi, int idProduit, int quantite, String designationCondi) {
		setIdCondi(idCondi);
		setIdProduit(idProduit);
		setQuantite(quantite);
		setDesignationCondi(designationCondi);
	}
	
	//GETTERS & SETTERS
	public int getIdCondi() {
		return idCondi;
	}
	public void setIdCondi(int idCondi) {
		this.idCondi = idCondi;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDesignationCondi() {
		return designationCondi;
	}

	public void setDesignationCondi(String designationCondi) {
		this.designationCondi = designationCondi;
	}
	
}
