package Entiter;

public class EnseignantPromotion {
    private String enseignantMatricule;
    private int promotionId;
    
    // Constructeur sans param�tre
    public EnseignantPromotion() {
    }

    // Constructeur avec param�tres
    public EnseignantPromotion(String enseignantMatricule, int promotionId) {
        this.enseignantMatricule = enseignantMatricule;
        this.promotionId = promotionId;
    }
	public String getEnseignantMatricule() {
		return enseignantMatricule;
	}
	public void setEnseignantMatricule(String enseignantMatricule) {
		this.enseignantMatricule = enseignantMatricule;
	}
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

    // Constructeur, getters, setters
}
