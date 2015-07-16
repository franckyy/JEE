package com.chezyen.appli.beans;

public class Client {

	//DECLARATIONS
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	
	//CONSTRUCTEURS
	public Client(int idClient, String nom, String prenom, String adresse) {
		setIdClient(idClient);
		setNom(nom);
		setPrenom(prenom);
		setAdresse(adresse);
	}

	//GETTERS & SETTERS
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
