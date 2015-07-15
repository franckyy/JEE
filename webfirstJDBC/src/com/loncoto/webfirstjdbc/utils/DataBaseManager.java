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
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         try {
			base.close();
			
			System.out.println("connexion close");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
