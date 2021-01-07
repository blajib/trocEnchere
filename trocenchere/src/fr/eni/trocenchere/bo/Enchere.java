package fr.eni.trocenchere.bo;

public class Enchere {
	private int identUtilisateur;
	private int noArticle;
	private String dateEnchere;
	private int montantEnchere;
	private int noEnchere;
	
	public Enchere(int identUtilisateur, int noArticle, String dateEnchere, int montantEnchere) {
		this.identUtilisateur = identUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(String dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	

	public Enchere(int identUtilisateur,int montantEnchere,int noArticle) {
		super();
		this.identUtilisateur = identUtilisateur;
		this.noArticle = noArticle;
		this.montantEnchere = montantEnchere;
	}

	public Enchere() {
		super();
	}

	public int getIdentUtilisateur() {
		return identUtilisateur;
	}

	public void setIdentUtilisateur(int identUtilisateur) {
		this.identUtilisateur = identUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(String dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	
	
	
	
	
	
	
}
