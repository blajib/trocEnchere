package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Retrait;

public interface ArticleDAO {

	public void insertArticle(ArticleVendu article,Retrait retrait) throws TrocEnchereExceptions;
	public List<ArticleVendu> selectEncheres (String typeEnchere, List<String> etatVente, List<String> etatAchat, int categorie, String filtre, int identifiantUtilisateurConnecte);

}
