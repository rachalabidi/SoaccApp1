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
import Entiter.PromotionGrade;


/**
 * Servlet implementation class GetGradeData
 */
@WebServlet("/GetGradeData")

public class GetGradeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("you are in getPromoData");

            // Assuming you have a method to get promotion data by matricule
            String matricule = request.getParameter("matricule");
            System.out.println("Received matricule: " + matricule);

            // Get promotion data (modify this method according to your database schema)
            PromotionGrade promotionData = DatabaseManager.getPromotionGradeDataByMatricule(matricule);

            // Set promotion data as request attributes
            request.setAttribute("gradepromotion", (promotionData.getGradePromotion() != null) ? promotionData.getGradePromotion() : "/");
          //  request.setAttribute("diplomepromotionId", (promotionData.getDiplomePromotionId() != null) ? promotionData.getDiplomePromotionId() : "/");
            request.setAttribute("date", (promotionData.getDate() != null) ? promotionData.getDate() : "/");

            // Convert promotion data to JSON and send it in the response
            String jsonResponse = "{ " +
                    "\"gradepromotion\": \"" + ((promotionData.getGradePromotion() != null) ? promotionData.getGradePromotion() : "/") + "\", " +
                    "\"date\": \"" + ((promotionData.getDate() != null) ? promotionData.getDate() : "/") + "\"" +
                    " }";

            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);

            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	}

	


