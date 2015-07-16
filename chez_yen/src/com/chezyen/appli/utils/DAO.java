package com.chezyen.appli.utils;

import java.util.ArrayList;

import com.chezyen.appli.beans.Client;
import com.chezyen.appli.beans.Conditionnement;
import com.chezyen.appli.beans.LigneCommande;
import com.chezyen.appli.beans.Produit;

public class DAO {

	//DECLARATIONS
	private ArrayList<Client> arrayClients = null;
	private ArrayList<Produit> arrayProduits = null;
	private ArrayList<Conditionnement> arrayCondi = null;
	private ArrayList<LigneCommande> arrayLignes = null;
	
	//CONSTRUCTEUR
	public DAO() {
		super();
		setClients();
		setProduits();
		setLignesCommande();
	}
	
	//SETTERS
	private void setLignesCommande() {
		arrayLignes = new ArrayList<LigneCommande>();
		
		LigneCommande ligneA = new LigneCommande(1, 1, 10);
	}
	
	private void setClients() {
		arrayClients= new ArrayList<Client>();
		
		Client clientA = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientB = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientC = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientD = new Client(1, "Arnold", "Schwartzeneger", "New York");
		
		arrayClients.add(clientA);
		arrayClients.add(clientB);
		arrayClients.add(clientC);
		arrayClients.add(clientD);
	}
	
	private void setProduits() {
		arrayProduits =  new ArrayList<Produit>();
		
		Produit produitA = new Produit(1, "nem");
		Produit produitB = new Produit(2, "samoussa");
		Produit produitC = new Produit(3, "crevettes sauce piquante");
		Produit produitD = new Produit(4, "poulet curry");
		
		arrayProduits.add(produitA);
		arrayProduits.add(produitB);
		arrayProduits.add(produitC);
		arrayProduits.add(produitD);
	}
	
	//GETTERS
	public ArrayList<Client> getClients() {
		return arrayClients;
	}
	

	public ArrayList<Produit> getProduits() {
		return arrayProduits;
	}
}
