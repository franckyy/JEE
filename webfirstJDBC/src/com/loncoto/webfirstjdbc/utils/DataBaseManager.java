package com.loncoto.webfirstjdbc.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DataBaseManager
 *
 */
public class DataBaseManager implements ServletContextListener {

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
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // méthode d'initialisation
    	//On peut lui demander de se connecter à la base et de la charger
    	System.out.println("démarrage de databasemanager");
    	
    }
	
}
