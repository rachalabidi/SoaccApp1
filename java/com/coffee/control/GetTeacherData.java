package com.coffee.control;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entiter.DatabaseManager;
import Entiter.Enseignant;

/**
 * Servlet implementation class GetTeacherData
 */
@WebServlet("/getTeacherData")
public class GetTeacherData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseManager.getConnection()) {
            // Assuming you have a method to get teacher data by matricule
        	String matricule = request.getParameter("matricule");

            // Log or print the matricule for debugging purposes
            System.out.println("Matricule received in servlet: " + matricule);
            Enseignant teacher = DatabaseManager.getTeacherByMatricule(matricule);

            // Set the teacher object as an attribute in the request
            request.setAttribute("teacherData", teacher);
            // Convert the teacher object to JSON
           
			/*
			 * Gson gson = new Gson(); String jsonTeacher = gson.toJson(teacher);
			 * 
			 * // Set content type to JSON response.setContentType("application/json");
			 * 
			 * // Write the JSON response
			 * 
			 * try (PrintWriter out = response.getWriter()) {
			 * 
			 * out.print(jsonTeacher); out.flush(); }
			 */
            // Forward the request to the JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editTeacher.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données: " + e.getMessage());
        }
    }
}

