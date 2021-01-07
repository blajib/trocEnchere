package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.ArticleDAO;
import fr.eni.trocenchere.dal.TrocDAO;
import fr.eni.trocenchere.dal.TrocDAOFactory;

public class ManagerArticle {
	ArticleDAO articleDAO = TrocDAOFactory.getArticleDAO();	
	
	public void insertArticle(ArticleVendu article,Retrait retrait) throws TrocEnchereExceptions {
		verifArticle(article,retrait);
		articleDAO.insertArticle(article,retrait);
		
		
	}
	public void verifArticle(ArticleVendu article, Retrait retrait) throws TrocEnchereExceptions {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		
		if(article.getNomArticle().equals("") || article.getNomArticle() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_NOM_ARTICLE);}
		if(article.getDescription().equals("") || article.getDescription() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_DESCRIPTION);}
		if(article.getCategorie() == 0) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_CATEGORIE);}
		if(article.getDateDebutEnchere() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_DATE_DEBUT);}
		if(article.getDateFinEnchere() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_DATE_FIN);}
		if(article.getMiseAPrix() == 0) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.PRIX_INITIAL_NON_CHIFFRE);}
		if(retrait.getRue().equals("") || retrait.getRue() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_RUE_RET);}
		if(retrait.getCodePostaleRetrait().equals("") || retrait.getCodePostaleRetrait() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_CPO_RET);}
		if(retrait.getVille().equals("") || retrait.getVille() == null) {trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_VILLE_RET);}
		
		if(trocEnchereExceptions.hasErreurs()) {
			throw trocEnchereExceptions;
		}
		
		
		
	
	}
	
	public List<ArticleVendu> chercherEncheres (String typeEnchere, List<String> etatVente, List<String> etatAchat, int categorie, String filtre, int identifiantUtilisateurConnecte) {
		
		return articleDAO.selectEncheres(typeEnchere, etatVente, etatAchat, categorie, filtre, identifiantUtilisateurConnecte);
	}
	
	

}
