package com.coffee.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entiter.DatabaseManager;

/**
 * Servlet implementation class GetPromoData
 */
@WebServlet("/getPromoData")

public class GetPromoData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try (Connection connection = DatabaseManager.getConnection()) {
			 System.out.print("you are in getPromoData");
	            // Assuming you have a method to get teacher data by matricule
	        	String matricule = request.getParameter("matricule");
	        	System.out.println("Received matricule: " + matricule);

	        	Integer nombreechelon = DatabaseManager.getNombreEchelonByMatricule(matricule);
	        	request.setAttribute("nombreechelon", (nombreechelon != null) ? nombreechelon : 0);
				 System.out.print("you are in getPromoData and here is "+nombreechelon);
				 String jsonResponse = "{ \"nombreechelon\": " + ((nombreechelon != null) ? nombreechelon : 0) + " }";
		            response.setContentType("application/json");
		            response.getWriter().write(jsonResponse);

	            

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
