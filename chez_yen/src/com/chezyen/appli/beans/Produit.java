package com.chezyen.appli.beans;

public class Produit {

	//DECLARATIONS
	private int idProduit;
	private String designation;
	
	//CONSTRUCTEUR
	public Produit(int idProduit, String designation) {
		setIdProduit(idProduit);
		setDesignation(designation);
	}
	
	//GETTERS & SETTERS
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
