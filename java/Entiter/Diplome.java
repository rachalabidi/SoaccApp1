package Entiter;

public class Diplome {
    private int diplomeId;
    private String nom;
    

    // Constructeur sans param�tre
    public Diplome() {
    }

    // Constructeur avec param�tres
    public Diplome(int diplomeId, String nom) {
        this.diplomeId = diplomeId;
        this.nom = nom;
    }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDiplomeId() {
		return diplomeId;
	}
	public void setDiplomeId(int diplomeId) {
		this.diplomeId = diplomeId;
	}

    // Constructeur, getters, setters
}
