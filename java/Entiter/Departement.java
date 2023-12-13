package Entiter;

public class Departement {
    private int departementId;
    private String nom;
    
    // Constructeur sans param�tre
    public Departement() {
    }

    // Constructeur avec param�tres
    public Departement(int departementId, String nom) {
        this.departementId = departementId;
        this.nom = nom;
    }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDepartementId() {
		return departementId;
	}
	public void setDepartementId(int departementId) {
		this.departementId = departementId;
	}

    // Constructeur, getters, setters
}
