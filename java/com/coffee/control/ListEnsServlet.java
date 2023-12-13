package com.coffee.control;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entiter.Enseignant;
import Entiter.DatabaseManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/listEns")
public class ListEnsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
		

        // Your logic here
     if ( request.getSession().getAttribute("username") != null) {
    	try (Connection connection = DatabaseManager.getConnection()) {
              	 } catch (SQLException e) {
             System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
         }
    	
    	List<Enseignant> enseignants  = DatabaseManager.getAllEnseignants();
    	//System.out.println("Retrieved " + enseignants.size() + " teachers from the database");
        request.setAttribute("enseignants", enseignants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ListEns.jsp");
        dispatcher.forward(request, response);
        System.out.println("This is a protected servlet. Welcome, " + request.getSession().getAttribute("username"));
		
		  } else { // User is not logged in, redirect to the login page
		  response.sendRedirect(request.getContextPath() + "/"); }
		 
    }
}

