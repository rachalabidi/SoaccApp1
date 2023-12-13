package Entiter;

public class Echelon {
    private int echelonId;
    private String enseignantMatricule;
    private int promotionId;
    
    // Constructeur sans param�tre
    public Echelon() {
    }

    // Constructeur avec param�tres
    public Echelon(int echelonId, String enseignantMatricule, int promotionId) {
        this.echelonId = echelonId;
        this.enseignantMatricule = enseignantMatricule;
        this.promotionId = promotionId;
    }
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public String getEnseignantMatricule() {
		return enseignantMatricule;
	}
	public void setEnseignantMatricule(String enseignantMatricule) {
		this.enseignantMatricule = enseignantMatricule;
	}
	public int getEchelonId() {
		return echelonId;
	}
	public void setEchelonId(int echelonId) {
		this.echelonId = echelonId;
	}

    // Constructeur, getters, setters
}
