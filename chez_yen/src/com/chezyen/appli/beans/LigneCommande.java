package com.chezyen.appli.beans;

public class LigneCommande {

	//DECLARATIONS
	private int idLigne;
	private int idCond;
	private int quantiteCommandee;
	
	//CONSTRUCTEUR
	public LigneCommande(int idLigne, int idCond, int quantiteCommandee) {
		setIdLigne(idLigne);
		setIdCond(idCond);
		setQuantiteCommandee(quantiteCommandee);
	}
	
	public int getIdLigne() {
		return idLigne;
	}
	public void setIdLigne(int idLigne) {
		this.idLigne = idLigne;
	}
	public int getIdCond() {
		return idCond;
	}
	public void setIdCond(int idCond) {
		this.idCond = idCond;
	}
	public int getQuantiteCommandee() {
		return quantiteCommandee;
	}
	public void setQuantiteCommandee(int quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}
	
	
}
