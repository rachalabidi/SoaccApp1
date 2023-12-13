package Entiter;

import java.sql.Date;

public class Enseignant {
    private String matricule;
    private String nom;
    private String prenom;
    private char sexe;
    private Date dateNaissance;
    private String lieuNaissance;
    private char situationFamille;
    private String conjoint;
    private int enfants;
    private Date dateRecrutement;
    //private String diplomeRecrutementId;
   // private int departementAffectationId;
    private Departement departement;
   

	private String etatActuel;
    private Diplome diplome;

    // Constructeur sans param�tre
    public Enseignant() {
    }

    // Constructeur avec param�tres
    public Enseignant(String matricule, String nom, String prenom, char sexe, java.util.Date dateNaissance,
            String lieuNaissance, char situationFamille, String conjoint, int enfants, java.util.Date dateRecrutement,
             Diplome diplome,Departement departement, String etatActuel) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = (Date) dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.situationFamille = situationFamille;
        this.conjoint = conjoint;
        this.enfants = enfants;
        this.dateRecrutement = (Date) dateRecrutement;
        this.diplome=diplome;
        this.departement = departement; // Set the Departement

        this.etatActuel = etatActuel;
    }


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public char getSituationFamille() {
		return situationFamille;
	}
	public void setSituationFamille(char situationFamille) {
		this.situationFamille = situationFamille;
	}
	public String getConjoint() {
		return conjoint;
	}
	public void setConjoint(String conjoint) {
		this.conjoint = conjoint;
	}
	public int getEnfants() {
		return enfants;
	}
	public void setEnfants(int enfants) {
		this.enfants = enfants;
	}
	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	
	public String getEtatActuel() {
		return etatActuel;
	}
	public void setEtatActuel(String etatActuel) {
		this.etatActuel = etatActuel;
	}
	  public Departement getDepartement() {
		  if (departement == null) {
	            departement = new Departement();
	        }
	        return departement;
	    }

	    public void setDepartement(Departement departement) {
	        this.departement = departement;
	    }
	    public Diplome getDiplome() {
	    	if (diplome == null) {
	    		diplome = new Diplome();
	        }
			return diplome;
		}

		public void setDiplome(Diplome diplome) {
			this.diplome = diplome;
		}

    // Constructeur, getters, setters
}
