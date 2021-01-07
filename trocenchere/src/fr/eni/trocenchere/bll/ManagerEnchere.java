package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.dal.EnchereDAO;
import fr.eni.trocenchere.dal.TrocDAOFactory;

public class ManagerEnchere {
	EnchereDAO enchereDAO = TrocDAOFactory.getEnchereDAO();
	
	public void mettreEnchere(int noArticle,int noAcheteur, int credit ) {
		enchereDAO.faireEnchere(noArticle,noAcheteur, credit);
		
		
		
		}

}
