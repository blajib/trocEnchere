package fr.eni.trocenchere.dal;

public class TrocDAOFactory {
	
	public static TrocDAO getTrocDAO() {
		TrocDAO troc = new TrocDAOJdbcImpl();
		return troc;
		}
	public static ArticleDAO getArticleDAO() {
		ArticleDAO article = new ArticleDAOJdbcImpl();
		return article;
		}
	public static EnchereDAO getEnchereDAO() {
		EnchereDAO enchere = new EnchereDAOJdbcImpl();
		return enchere;		
	}

}
