package com.coffee.control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entiter.DatabaseManager;
import Entiter.PromotionEchelon;
import Entiter.PromotionGrade;

/**
 * Servlet implementation class EditTeacerPromotion
 */

@WebServlet("/editTeacherPromotion")

public class EditTeacerPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getSession().getAttribute("username") != null) {
		        System.out.println("from /editTeacherPromotion " );
		        String matricule = request.getParameter("matricule");
		        // Assuming you have appropriate HTML form parameters
		        String promotionId = request.getParameter("promotionId");
		        System.out.println("ARE WE HERE? INSIDE THE SERVLET" + promotionId );


		        // Check the selected promotion type
		        if ("grade".equals(promotionId)) {
		            // Grade promotion selected, retrieve grade-related parameters
		        	String todaysDate = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
		            String gradePromotionId = "G" + todaysDate + matricule;		            
		            String gradePromotionName = request.getParameter("gradenId");
		            String nomDeDiplome = request.getParameter("diplomeName");
		            
		            String[] parts = nomDeDiplome.split("_");
		            int DiplomeId = Integer.parseInt(parts[0]);
		            String nomDiplome = parts[1];

		            // Create a PromotionGrade object
		            PromotionGrade promotionGrade = new PromotionGrade(gradePromotionName, gradePromotionId, DiplomeId,
		                    matricule);

		            // Call the method to insert into both tables
		            try {
						DatabaseManager.AjouterLaPromoGrade(promotionGrade, DiplomeId, nomDiplome, matricule);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		        } else if ("echlon".equals(promotionId)) {
		            // Echlon promotion selected, retrieve echlon-related parameters
		        	String todaysDate = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
		            String EchelonPromotionId = "E" + todaysDate + matricule;	
		            int nbrEchlon = Integer.parseInt(request.getParameter("nbrEchlon"));

		            // Call the method to insert into the echlon-related table
		            // Adjust the method parameters as needed
		            PromotionEchelon PromotionEchelon = new PromotionEchelon(EchelonPromotionId ,nbrEchlon , matricule);
		            DatabaseManager.insertEchlon(PromotionEchelon);

		        } 


		        // Redirect back to the teachers list page
		        response.sendRedirect(request.getContextPath() + "/listEns");
		        }else {
		     		  response.sendRedirect(request.getContextPath() + "/"); }

		        }
		    
	}


