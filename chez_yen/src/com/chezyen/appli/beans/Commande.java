package com.chezyen.appli.beans;

import java.util.List;

public class Commande {

	//DECLARATIONS
	private int id;
	private Client client;
	private List<LigneCommande> lignes;
	
	//CONSTRUCTEUR
	public Commande(int id, Client client, List<LigneCommande> lignes) {
		setId(id);
		setClient(client);
		setLignes(lignes);
	}
	
	//GETTERS & SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
	}
}
