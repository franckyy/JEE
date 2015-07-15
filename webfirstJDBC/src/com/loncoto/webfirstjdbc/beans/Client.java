package com.loncoto.webfirstjdbc.beans;

public class Client {
	//ATTRIBUTS
	private int id;
	private String nom;
	private String email;
	private double solde;
	
	//CONSTRUCTEURS
	public Client(int id, String nom, String email, double solde) {
		super();
		setId(id);
		setNom(nom);
		setEmail(email);
		setSolde(solde);		
	}
	
	public Client() {
		this(0, "", "", 0.0);
	}
	
	//GETTERS & SETTERS
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
