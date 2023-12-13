package Entiter;

import java.sql.Date;

public class PromotionGrade {
    private String gradePromotion;
    private String promotionId;
    public PromotionGrade(String gradePromotion, String promotionId, int diplomePromotionId, 
			String matricule) {
		super();
		this.gradePromotion = gradePromotion;
		this.promotionId = promotionId;
		this.diplomePromotionId = diplomePromotionId;
		
		this.matricule = matricule;
	}

	public String getGradePromotion() {
		return gradePromotion;
	}

	public void setGradePromotion(String gradePromotion) {
		this.gradePromotion = gradePromotion;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public int getDiplomePromotionId() {
		return diplomePromotionId;
	}

	public void setDiplomePromotionId(int diplomePromotionId) {
		this.diplomePromotionId = diplomePromotionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	private int diplomePromotionId;
	private Date date;
    private String matricule;
    
    public PromotionGrade() {
    }
   


	public PromotionGrade(String gradepromotion, int diplomepromotionId, Date date) {
        this.gradePromotion = gradepromotion;
        this.diplomePromotionId = diplomepromotionId;
        this.date = date;
    }

 
}