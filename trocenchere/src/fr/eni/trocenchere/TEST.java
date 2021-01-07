package fr.eni.trocenchere;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.bll.Manager;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Utilisateur;

public class TEST {

	public static void main(String[] args) {
//		List<ArticleVendu> encheres = new ArrayList<ArticleVendu>();
//		LocalDateTime art_dateDebut = LocalDateTime.now();
//		LocalDateTime art_dateFin = LocalDateTime.now();
//		ArticleVendu article = new ArticleVendu(1, "nom article", "description", art_dateDebut, art_dateFin, 0, 100, "EC", "", 1, 1);
//		ArticleVendu article1 = new ArticleVendu(1, "tapis souris", "tapis de souris tout beau", art_dateDebut, art_dateFin, 10, 1000, "TER", "", 2, 2);
//		
//		encheres.add(article);
//		encheres.add(article1);
//		
//		//System.out.println(encheres);
//		for (ArticleVendu articleVendu : encheres) {
//			System.out.println(articleVendu.getIdentUtilisateur());
//			int identUtilisateur = articleVendu.getIdentUtilisateur();
//			Manager manager = new Manager();
//			try {
//				Utilisateur utilisateur = manager.chercherUtilisateurbyId(articleVendu.getNoArticle());
//				System.out.println(utilisateur.getPseudo());
//			} catch (TrocEnchereExceptions e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		List<String> etatVente = new ArrayList<String>();
		etatVente.add("'EC'");
		etatVente.add("'TER'");
		etatVente.add("'PV'");
		
		String etatVenteString = etatVente.toString().replace("[", "").replace("]", "");
		System.out.println(etatVenteString);
		System.out.println(etatVente.toString().replace("[", "").replace("]", ""));
		
		if (etatVenteString.contains("RE")) {
			System.out.println("elle contient la demande");
		} else {
			System.out.println("elle ne contient pas la demande");
		}
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("SELECT ARTICLES.*").append(System.getProperty("line.separator"));
//		sb.append("FROM ARTICLES").append(System.getProperty("line.separator"));
//		
//		if (etatVente.size() == 1) {
//			
//		}
		
	
	}

}
