package com.loncoto.webfirstjdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.webfirstjdbc.beans.Client;
import com.loncoto.webfirstjdbc.utils.ClientDAO;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDAO clientDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//on récupère le clientDAO qui se trouve dans le contexte. Il y a été créé par le DatBaseManager 
		//qui est exécuté au lancement par le serveur
		clientDAO = (ClientDAO)getServletContext().getAttribute("clientDAO");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientDAO.findAll();
		request.setAttribute("clients", clients);
		
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action){
		case "editer":
			int id = Integer.parseInt(request.getParameter("id"));
			Client c = clientDAO.findById(id);
			request.setAttribute("client", c);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
			break;
		}
	}

}
