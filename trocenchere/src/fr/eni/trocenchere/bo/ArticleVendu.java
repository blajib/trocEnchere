package fr.eni.trocenchere.bo;

import java.sql.Date;
import java.time.LocalDateTime;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEnchere;
	private LocalDateTime dateFinEnchere;
	private int miseAPrix;
	private int prixDeVente;
	private int identUtilisateur;
	private int categorie;
	private String etatVente;
	private String image;
	
	
	
	public ArticleVendu(String nomArticle, String description, LocalDateTime dateDebutEnchere,
			LocalDateTime dateFinEnchere, int miseAPrix, int identUtilisateur, int categorie,
			String etatVente, String image) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.identUtilisateur = identUtilisateur;
		this.prixDeVente = 0;
		this.categorie = categorie;
		this.etatVente = etatVente;
		this.image = image;
	}
	
	// constructeur avec identifiant article : généré dans l'ordre de la création des champs sous SQL
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEnchere,
			LocalDateTime dateFinEnchere, int miseAPrix, int prixDeVente, String etatVente, String image,
			int identUtilisateur, int categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.prixDeVente = prixDeVente;
		this.etatVente = etatVente;
		this.image = image;
		this.identUtilisateur = identUtilisateur;
		this.categorie = categorie;
	}




	public int getNoArticle() {
		return noArticle;
	}




	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}




	public String getNomArticle() {
		return nomArticle;
	}




	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public LocalDateTime getDateDebutEnchere() {
		return dateDebutEnchere;
	}




	public void setDateDebutEnchere(LocalDateTime dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}




	public LocalDateTime getDateFinEnchere() {
		return dateFinEnchere;
	}




	public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}




	public int getMiseAPrix() {
		return miseAPrix;
	}




	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}




	public int getPrixDeVente() {
		return prixDeVente;
	}




	public void setPrixDeVente(int prixDeVente) {
		this.prixDeVente = prixDeVente;
	}




	public int getIdentUtilisateur() {
		return identUtilisateur;
	}




	public void setIdentUtilisateur(int identUtilisateur) {
		this.identUtilisateur = identUtilisateur;
	}




	public int getCategorie() {
		return categorie;
	}




	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}




	public String getEtatVente() {
		return etatVente;
	}




	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEnchere=");
		builder.append(dateDebutEnchere);
		builder.append(", dateFinEnchere=");
		builder.append(dateFinEnchere);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixDeVente=");
		builder.append(prixDeVente);
		builder.append(", identUtilisateur=");
		builder.append(identUtilisateur);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append(", image=");
		builder.append(image);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	





	
	
	

}

