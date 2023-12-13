package com.coffee.control;
import Entiter.Enseignant;
import Entiter.DatabaseManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTeacher")
public class AddTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 if (  request.getSession().getAttribute("usermane") != null ) {
        // Retrieve form parameters
    	 String matricule = request.getParameter("matricule");
         String nom = request.getParameter("nom");
         String prenom = request.getParameter("prenom");
         char sexe = request.getParameter("sexe").charAt(0);
         String dateNaissanceStr = request.getParameter("dateNaissance");
         String lieuNaissance = request.getParameter("lieuNaissance");
         char situationFamille = request.getParameter("situationFamille").charAt(0);
         String conjoint = request.getParameter("conjoint");
         int enfants = Integer.parseInt(request.getParameter("enfants"));
         String dateRecrutementStr = request.getParameter("dateRecrutement");
         String diplomeRecrutementId = request.getParameter("diplomeRecrutementId");
         int departementAffectationId = Integer.parseInt(request.getParameter("departementAffectationId"));
         String etatActuel = request.getParameter("etatActuel");

         // Parse date strings into java.sql.Date
         Date dateNaissance = parseDate(dateNaissanceStr);
         Date dateRecrutement = parseDate(dateRecrutementStr);

         // Create an Enseignant object with the form data
         Enseignant newTeacher = new Enseignant();
         newTeacher.setMatricule(matricule);
         newTeacher.setNom(nom);
         newTeacher.setPrenom(prenom);
         newTeacher.setSexe(sexe);
         newTeacher.setDateNaissance(new java.sql.Date(dateNaissance.getTime()));
         newTeacher.setLieuNaissance(lieuNaissance);
         newTeacher.setSituationFamille(situationFamille);
         newTeacher.setConjoint(conjoint);
         newTeacher.setEnfants(enfants);
         newTeacher.setDateRecrutement(new java.sql.Date(dateRecrutement.getTime()));
         
         
         
         String[] parts = diplomeRecrutementId.split("_");
         int existingDiplomeId = Integer.parseInt(parts[0]);
         String nomDeDiplome = parts[1];
         newTeacher.getDiplome().setDiplomeId(existingDiplomeId);
         newTeacher.getDiplome().setNom(nomDeDiplome);

         newTeacher.getDepartement().setDepartementId(departementAffectationId);
         newTeacher.setEtatActuel(etatActuel);

        // Insert the new teacher into the database
        insertNewTeacher(newTeacher);
        System.out.println("New teacher inserted: " + newTeacher.getNom());

        // Redirect back to the teachers list page
        response.sendRedirect(request.getContextPath() + "/listEns");
    	 } else { // User is not logged in, redirect to the login page
   		  response.sendRedirect(request.getContextPath() + "/"); }
   		 
    }
    
  
    private void insertNewTeacher(Enseignant enseignant) {
    	  try (Connection connection = DatabaseManager.getConnection()) {
    	        System.out.println("Connexion r�ussie � la base de donn�es PostgreSQL FROM INSERT TEACHER .");
    	        DatabaseManager.insertEnseignant(enseignant);

    	          	 } catch (SQLException e) {
    	         System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
    	     }
    	    
    }
    
    
    

    private Date parseDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
