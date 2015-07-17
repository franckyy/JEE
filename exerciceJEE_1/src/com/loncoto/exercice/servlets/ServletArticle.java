package com.loncoto.exercice.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.exercice.beans.Article;
import com.loncoto.exercice.utils.DAOarticle;

/**
 * Servlet implementation class ServletArticle
 */
public class ServletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAOarticle dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = (DAOarticle)getServletContext().getAttribute("DAOarticle");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = dao.findAll();
		
		request.setAttribute("articles", articles);
		
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "editer":
			int idArticle = Integer.parseInt(request.getParameter("id"));
			Article article = dao.findById(idArticle);
			
			request.setAttribute("article", article);
			getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
			break;
		case "supprimer":
			break;
		case "creer":
			break;
		}
	}

}
