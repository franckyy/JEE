package com.loncoto.exercice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataBaseManager implements ServletContextListener{

	private Connection base;
	
	public DataBaseManager() {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		try {
			base.close();
			System.out.println("Fermeture de connexion");
		} catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
    	System.out.println("initialisation de baseurl");
    	String baseurl = "http://locahost:8080/exerciceJEE_1";
		
		System.out.println("démarrage de databasemanager");
    	
    	String driverClass = evt.getServletContext().getInitParameter("driverClass");
    	String dataBaseURL = evt.getServletContext().getInitParameter("dataBaseURL");
    	String login = evt.getServletContext().getInitParameter("login");
    	String password = evt.getServletContext().getInitParameter("password");
    	
    	try {
    		//chargement du driver mysql
			Class.forName(driverClass);
			
			//connexion à la base
			base = DriverManager.getConnection(dataBaseURL, login, password);
			
			System.out.println("connecté à la base");
			
			//création DAO
			DAOarticle dao = new DAOarticle(base);
			//mise à disposition du DAO pour les servlets
			evt.getServletContext().setAttribute("DAOarticle", dao);
		} 
    	catch (ClassNotFoundException e) {e.printStackTrace();}
    	catch (SQLException e) {e.printStackTrace();}
	}
	
}
