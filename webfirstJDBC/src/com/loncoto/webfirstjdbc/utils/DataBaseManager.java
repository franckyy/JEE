package com.loncoto.webfirstjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DataBaseManager
 *
 */
public class DataBaseManager implements ServletContextListener {

	//déclaration d'un attribut INTERFACE. c'est le serveur qui se charge d'attribuer cette interface 
	//à une classe en rapport avec la base de données.
	private Connection base;
	
    /**
     * Default constructor. 
     */
    public DataBaseManager() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         try {
			base.close();
			
			System.out.println("connexion close");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent evt)  { 
         // méthode d'initialisation
    	//On peut lui demander de se connecter à la base et de la charger
    	System.out.println("démarrage de databasemanager");
    	
    	String driverclass = evt.getServletContext().getInitParameter("driverclass");
    	String databaseURL = evt.getServletContext().getInitParameter("databaseURL");
    	String login = evt.getServletContext().getInitParameter("login");
    	String password = evt.getServletContext().getInitParameter("password");
    	
    	try {
    		//chargement du driver mysql
    		Class.forName(driverclass);
			
    		//connexion à la base
			base = DriverManager.getConnection(databaseURL, login, password);
			
			System.out.println("connecté à la base");
			
			//Création du clientDAO
			ClientDAO clientDAO = new ClientDAO(base);
			
			//je met le clientDAO à disposition des servlets (c'est le serveur d'application qui initialise le contexte
			// donc le clientDAO est visible par les servlets et les jsp mais pas par les beans)
			evt.getServletContext().setAttribute("clientDAO", clientDAO);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
