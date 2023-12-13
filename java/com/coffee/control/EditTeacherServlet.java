package com.coffee.control;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entiter.Enseignant;
import Entiter.DatabaseManager;
import org.apache.log4j.Logger;


@WebServlet("/editTeacher")
public class EditTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(EditTeacherServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data from the request
if( request.getSession().getAttribute("username") != null) {
        String matricule = request.getParameter("matricule");
        logger.info("Matricule received: " + matricule);

        String situationFamille = request.getParameter("situationFamille");
        String conjoint = request.getParameter("conjoint");
        int enfants = Integer.parseInt(request.getParameter("enfants"));
        int departementAffectationId = Integer.parseInt(request.getParameter("departementAffectationId"));
        String etatActuel = request.getParameter("etatActuel");
        System.out.println("u are here dugging from the bus "+matricule );
       // Update teacher data in the database
        DatabaseManager.updateTeacherData(matricule, situationFamille, conjoint, enfants, departementAffectationId, etatActuel);
        
     
    response.sendRedirect(request.getContextPath() + "/listEns");}
else {
		  response.sendRedirect(request.getContextPath() + "/"); }

}

    }

    

   
  

