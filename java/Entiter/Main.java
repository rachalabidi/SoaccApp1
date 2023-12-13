package Entiter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        // Test de la connexion � la base de donn�es
      /*  try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connexion r�ussie � la base de donn�es PostgreSQL.");

            // Exemple d'insertion dans la table Promotion
            Promotion newPromotion = new Promotion();
            newPromotion.setDate(new java.sql.Date(System.currentTimeMillis()));
            newPromotion.setPromotionId(1);
            DatabaseManager.insertPromotion(newPromotion);
            System.out.println("Insertion r�ussie dans la table Promotion.");


        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
        }
       
    	
    	
        
        try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connexion r�ussie � la base de donn�es PostgreSQL.");

            // Exemple de cr�ation d'un nouvel enseignant
            Enseignant newEnseignant = new Enseignant();
            newEnseignant.setMatricule("12345");
            newEnseignant.setNom("Doe");
            newEnseignant.setPrenom("John");
            newEnseignant.setSexe('M');
            newEnseignant.setDateNaissance(new java.sql.Date(System.currentTimeMillis()));
            newEnseignant.setLieuNaissance("City");
            newEnseignant.setSituationFamille('S');
            newEnseignant.setConjoint("Jane");
            newEnseignant.setEnfants(2);
            newEnseignant.setDateRecrutement(new java.sql.Date(System.currentTimeMillis()));
            newEnseignant.setDiplomeRecrutementId(1); // Remplacez par l'ID du dipl�me appropri�
            newEnseignant.setDepartementAffectationId(1); // Remplacez par l'ID du d�partement appropri�
            newEnseignant.setEtatActuel("Actif");

            DatabaseManager.insertEnseignant(newEnseignant);
            System.out.println("Insertion r�ussie dans la table Enseignant.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
        }
        */
    	
   
    	try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connexion r�ussie � la base de donn�es PostgreSQL.");

            // Exemple de r�cup�ration de tous les enseignants
            List<Enseignant> enseignants = DatabaseManager.getAllEnseignants();
            System.out.println("Liste des enseignants :");
            for (Enseignant enseignant : enseignants) {
                System.out.println("Matricule : " + enseignant.getMatricule() + ", Nom : " + enseignant.getNom() +
                        ", Pr�nom : " + enseignant.getPrenom() + ", Date de naissance : " + enseignant.getDateNaissance());
                // Ajoutez d'autres informations selon vos besoins
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
        }
      
    	/*
    	try (Connection connection = DatabaseManager.getConnection()) {
            System.out.println("Connexion r�ussie � la base de donn�es PostgreSQL.");

            // Exemple d'affichage de la liste des enseignants
            List<Enseignant> enseignants = DatabaseManager.getAllEnseignants();
            System.out.println("Liste des enseignants :");
            for (Enseignant enseignant : enseignants) {
                System.out.println("Matricule : " + enseignant.getMatricule() + ", Nom : " + enseignant.getNom() +
                        ", Pr�nom : " + enseignant.getPrenom() + ", Date de naissance : " + enseignant.getDateNaissance());
            }

            try (// S�lection de l'enseignant � mettre � jour
			Scanner scanner = new Scanner(System.in)) {
				System.out.print("Veuillez entrer le matricule de l'enseignant � mettre � jour : ");
				String matriculeToUpdate = scanner.nextLine();

				// Recherche de l'enseignant dans la liste
				Enseignant selectedEnseignant = null;
				for (Enseignant enseignant : enseignants) {
				    if (enseignant.getMatricule().equalsIgnoreCase(matriculeToUpdate)) {
				        selectedEnseignant = enseignant;
				        break;
				    }
				}

				// V�rification si l'enseignant a �t� trouv�
				if (selectedEnseignant != null) {
				    // Affichage des informations de l'enseignant avant mise � jour
				    System.out.println("Informations actuelles de l'enseignant :");
				    System.out.println("Nom : " + selectedEnseignant.getNom() + ", Pr�nom : " + selectedEnseignant.getPrenom() +
				            ", Date de naissance : " + selectedEnseignant.getDateNaissance());

				    // Saisie des nouvelles informations de l'enseignant
				    System.out.println("Entrez les nouvelles informations de l'enseignant :");
				    System.out.print("Nouveau nom : ");
				    String newNom = scanner.nextLine();
				    System.out.print("Nouveau pr�nom : ");
				    String newPrenom = scanner.nextLine();
				    // Ajoutez d'autres champs selon vos besoins

				    // Mise � jour des informations de l'enseignant
				    selectedEnseignant.setNom(newNom);
				    selectedEnseignant.setPrenom(newPrenom);
				    // Ajoutez d'autres setters selon vos besoins

				    // Appel de la m�thode pour mettre � jour l'enseignant dans la base de donn�es
				    DatabaseManager.updateEnseignant(selectedEnseignant);
				} else {
				    System.out.println("Aucun enseignant trouv� avec le matricule " + matriculeToUpdate);
				}
			}

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion � la base de donn�es : " + e.getMessage());
        } */
    }
}
