package fr.eni.trocenchere.dal;

public interface EnchereDAO {
	static int noVendeur = 0;
	public void faireEnchere(int noArticle,int noAcheteur, int credit);

}
