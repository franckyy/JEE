package com.chezyen.appli.utils;

import java.util.ArrayList;
import java.util.List;

import com.chezyen.appli.beans.Client;

public class DAO {

	//DECLARATIONS
	ArrayList<Client> arrayClients = null;
	
	//CONSTRUCTEUR
	public DAO() {
		super();
		setClients();
	}
	
	//METHODES
	private List<Client> setClients() {
		arrayClients= new ArrayList<Client>();
		
		Client clientA = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientB = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientC = new Client(1, "Arnold", "Schwartzeneger", "New York");
		Client clientD = new Client(1, "Arnold", "Schwartzeneger", "New York");
		
		arrayClients.add(clientA);
		arrayClients.add(clientB);
		arrayClients.add(clientC);
		arrayClients.add(clientD);
		
		return arrayClients;
	}
}
