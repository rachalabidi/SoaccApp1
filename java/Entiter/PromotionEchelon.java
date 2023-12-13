package Entiter;

import java.util.Date;

public class PromotionEchelon {
    private int nombreEchelon;
    private String promotionId;
    private String matricule;
    private Date  date ;
	public int getNombreEchelon() {
		return nombreEchelon;
	}
	public void setNombreEchelon(int nombreEchelon) {
		this.nombreEchelon = nombreEchelon;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public PromotionEchelon( String promotionId,int nombreEchelon,  String matricule) {
		super();
		this.nombreEchelon = nombreEchelon;
		this.promotionId = promotionId;
		this.matricule = matricule;
	} 
    
    
    
}
