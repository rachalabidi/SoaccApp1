package Entiter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import java.sql.Date;
import java.time.LocalDate;

public class DatabaseManager {
    // Informations de connexion � la base de donn�es 123456
    private static final String URL = "jdbc:postgresql://localhost:5432/Sooac";
    private static final String USER = "postgres";
    private static final String PASSWORD = "coffee";

    // M�thode de connexion � la base de donn�es
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (log it or throw a custom exception)
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

 

    
   
      
    public static void insertEnseignant(Enseignant enseignant) {
        try (Connection connection = getConnection()) {
        	
            // Split diplomeRecrutementId into id and nomDeDiplome
            int existingDiplomeId = enseignant.getDiplome().getDiplomeId();
            String nomDeDiplome = enseignant.getDiplome().getNom();;
            String matricule = enseignant.getMatricule();

            // Check if the DiplomeRecrutementId already exists
           

            // Proceed with the Enseignant insertion
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Enseignant(matricule, nom, prenom, sexe, dateNaissance, lieuNaissance, " +
                            "situationFamille, conjoint, enfants, dateRecrutement, diplomeRecrutement_id, " +
                            "departementAffectation_id, etatActuel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                preparedStatement.setString(1, enseignant.getMatricule());
                preparedStatement.setString(2, enseignant.getNom());
                preparedStatement.setString(3, enseignant.getPrenom());
                preparedStatement.setString(4, String.valueOf(enseignant.getSexe()));
                preparedStatement.setDate(5, enseignant.getDateNaissance());
                preparedStatement.setString(6, enseignant.getLieuNaissance());
                preparedStatement.setString(7, String.valueOf(enseignant.getSituationFamille()));
                preparedStatement.setString(8, enseignant.getConjoint());
                preparedStatement.setInt(9, enseignant.getEnfants());
                preparedStatement.setDate(10, enseignant.getDateRecrutement());
                preparedStatement.setInt(11, existingDiplomeId);
                preparedStatement.setInt(12, enseignant.getDepartement().getDepartementId());
                preparedStatement.setString(13, enseignant.getEtatActuel());

                preparedStatement.executeUpdate();
                if (getDiplomeById(existingDiplomeId) == -1) {
                    // DiplomeRecrutementId does not exist, insert into Diplome table
                    insertDiplome(existingDiplomeId, nomDeDiplome , matricule);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get DiplomeId by id
    private static int getDiplomeById(int diplomeId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT diplome_id FROM Diplome WHERE diplome_id = ?")) {

            preparedStatement.setInt(1, diplomeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("diplome_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1; // Return -1 if Diplome does not exist
    }

    // Helper method to insert into Diplome table
    private static void insertDiplome(int diplomeId, String nomDeDiplome, String matricule) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Diplome(diplome_id, nom, matricule) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, diplomeId);
            preparedStatement.setString(2, nomDeDiplome);
            preparedStatement.setString(3, matricule);  // Provide a valid matricule value from Enseignant
            System.out.println("New DIPLOME inserted: ki T3RFI  " );

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        
        // M�thode de r�cup�ration de tous les enseignants
        public static List<Enseignant> getAllEnseignants() {
            List<Enseignant> enseignants = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Enseignant");
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Enseignant enseignant = new Enseignant();
                    enseignant.setMatricule(resultSet.getString("matricule"));
                    enseignant.setNom(resultSet.getString("nom"));
                    enseignant.setPrenom(resultSet.getString("prenom"));
                    enseignant.setDateRecrutement(resultSet.getDate("dateRecrutement"));
                    enseignant.setSituationFamille(resultSet.getString("situationFamille").charAt(0));
                    enseignant.setConjoint(resultSet.getString("conjoint"));
                    enseignant.setEnfants(resultSet.getInt("enfants"));
                    if (enseignant.getDepartement() == null) {
                        enseignant.setDepartement(new Departement());
                    }

                    // Set the departementId in the Departement object
                    enseignant.getDepartement().setDepartementId(resultSet.getInt("departementAffectation_id"));
                    enseignant.setEtatActuel(resultSet.getString("etatActuel"));
                    enseignants.add(enseignant);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return enseignants;
        }
     

        public static Enseignant getTeacherByMatricule(String matricule) {
            Enseignant teacher = null;
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "SELECT * FROM Enseignant WHERE matricule = ?")) {

                preparedStatement.setString(1, matricule);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    teacher = mapResultSetToEnseignant(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return teacher;
        }

        // Helper method to map ResultSet to Enseignant object
        private static Enseignant mapResultSetToEnseignant(ResultSet resultSet) throws SQLException {
            Enseignant enseignant = new Enseignant();
            enseignant.setMatricule(resultSet.getString("matricule"));
            enseignant.setNom(resultSet.getString("nom"));
            enseignant.setPrenom(resultSet.getString("prenom"));
            enseignant.setSexe(resultSet.getString("sexe").charAt(0));
            enseignant.setDateNaissance(resultSet.getDate("dateNaissance"));
            enseignant.setLieuNaissance(resultSet.getString("lieuNaissance"));
            enseignant.setSituationFamille(resultSet.getString("situationFamille").charAt(0));
            enseignant.setConjoint(resultSet.getString("conjoint"));
            enseignant.setEnfants(resultSet.getInt("enfants"));
            enseignant.setDateRecrutement(resultSet.getDate("dateRecrutement"));
            Diplome diplome = new Diplome();

            diplome.setDiplomeId(resultSet.getInt("diplomeRecrutement_id"));
            Departement departement = new Departement();
            departement.setDepartementId(resultSet.getInt("departementAffectation_id"));

            // Set the Departement object in the Enseignant
            enseignant.setDepartement(departement);
            enseignant.setEtatActuel(resultSet.getString("etatActuel"));

            return enseignant;
        }

        
        
        
        
        
        
        
        
		public static void updateTeacherData(String matricule, String situationFamille, String conjoint, int enfants,
				int departementAffectationId, String etatActuel) {
			// TODO Auto-generated method stub
			try (Connection connection = DatabaseManager.getConnection();
	                PreparedStatement preparedStatement = connection.prepareStatement(
	                        "UPDATE Enseignant SET situationFamille = ?, conjoint = ?, enfants = ?, "
	                                + "departementAffectation_id = ?, etatActuel = ? WHERE matricule = ?")) {

	            preparedStatement.setString(1, situationFamille);
	            preparedStatement.setString(2, conjoint);
	            preparedStatement.setInt(3, enfants);
	            preparedStatement.setInt(4, departementAffectationId);
	            preparedStatement.setString(5, etatActuel);
	            preparedStatement.setString(6, matricule);
	           

	            preparedStatement.executeUpdate();
	             

	        } catch (SQLException e) {
	            System.out.print(" ECHEC DE CONX ");        // Update teacher data in the database

	            e.printStackTrace();
	        }
		}
		






// helper  PROMOTION EN GRADE :
		

		private static void insertGrade(PromotionGrade promotionGrade) {
		    try (Connection connection = getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(
		                 "INSERT INTO promotiongrade( promotion_id,gradepromotion, diplomepromotion_id, matricule , date  ) VALUES (?, ?, ?, ?, ?)")) {
		        preparedStatement.setString(1, promotionGrade.getPromotionId());
		        preparedStatement.setString(2, promotionGrade.getGradePromotion());
		        preparedStatement.setInt(3, promotionGrade.getDiplomePromotionId());
		        preparedStatement.setString(4, promotionGrade.getMatricule());
		        // Use java.sql.Date and java.time.LocalDate to get the current date
		        LocalDate currentDate = LocalDate.now();
		        preparedStatement.setDate(5, Date.valueOf(currentDate));
		     //   preparedStatement.setString(5, promotionGrade.getMatricule());
		        System.out.println("IT EXISTS: "+ Date.valueOf(currentDate));


		        preparedStatement.executeUpdate();
		        System.out.println("New Grade inserted: ");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		
		
		
		
		
		
		
		public static void AjouterLaPromoGrade(PromotionGrade promotionGrade, int diplomeId, String nomDeDiplome, String matricule) throws SQLException {
          try (Connection connection = getConnection()) {
		    // Insert into Diplome table
			insertDiplome(diplomeId, nomDeDiplome, matricule);
			System.out.println("New diplome inserted " + nomDeDiplome );

			// Insert into PromotionGrade table
			insertGrade(promotionGrade);

			// If both inserts are successful, commit the transaction
      
			System.out.println("Transaction committed successfully.");
		}
		}
		
		
		public static void insertEchlon(PromotionEchelon PromotionEchelon) {
			try (Connection connection = getConnection();
			         PreparedStatement preparedStatement = connection.prepareStatement(
			                 "INSERT INTO promotionechelon( promotion_id,nombreechelon, date, matricule) VALUES (?, ?, ?, ?)")) {
			        preparedStatement.setString(1, PromotionEchelon.getPromotionId());
			        preparedStatement.setInt(2, PromotionEchelon.getNombreEchelon());
			        // Use java.sql.Date and java.time.LocalDate to get the current date
			        LocalDate currentDate = LocalDate.now();
			        preparedStatement.setDate(3, Date.valueOf(currentDate));
			        preparedStatement.setString(4, PromotionEchelon.getMatricule());


			        preparedStatement.executeUpdate();
			        System.out.println("New echelon inserted: ");

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			
		}
		
		
		 public static Integer getNombreEchelonByMatricule(String matricule) {
			    Integer nombreechelon = null;

			    try (Connection connection = DatabaseManager.getConnection()) {
			        String query = "SELECT nombreechelon FROM promotionechelon WHERE matricule = ?";
			        
			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			            preparedStatement.setString(1, matricule);

			            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                if (resultSet.next()) {
			                    // Retrieve the value from the result set
			                    nombreechelon = resultSet.getInt("nombreechelon");
			                }
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace(); // Handle the exception appropriately in a real application
			    }

			    return nombreechelon;

		    }
		 
		 public static PromotionGrade getPromotionGradeDataByMatricule(String matricule) {
			 PromotionGrade promotionGradeData = null;

			    try (Connection connection = DatabaseManager.getConnection()) {
			        String query = "SELECT gradepromotion, diplomepromotion_id, date FROM promotiongrade WHERE matricule = ?";

			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			            preparedStatement.setString(1, matricule);

			            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                if (resultSet.next()) {
			                    // Retrieve the values from the result set
			                    String gradepromotion = resultSet.getString("gradepromotion");
			                    int diplomepromotionId = resultSet.getInt("diplomepromotion_id");
			                    Date date = resultSet.getDate("date");

			                    // Create a PromotionGradeData object with the retrieved values
			                    promotionGradeData = new PromotionGrade(gradepromotion, diplomepromotionId, date);
			                }
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace(); // Handle the exception appropriately in a real application
			    }

			    return promotionGradeData;
			}


      

}