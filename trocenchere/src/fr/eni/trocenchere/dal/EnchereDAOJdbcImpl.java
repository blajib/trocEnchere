package fr.eni.trocenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	static int noVendeur = 0;
	

	@Override
	public void faireEnchere(int noArticle,int noAcheteur,int credit) {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		Enchere vieilleEnchere = null;
		Utilisateur utilisateurVieux = null ;
		Utilisateur utilisateurNouveau = null;
		TrocDAO trocDAO = TrocDAOFactory.getTrocDAO();
		int thuneVieilleEnchere = 0;
		
		String sql = "SELECT ench_noUtilisateur,ench_montantEnchere FROM ENCHERES WHERE ench_noArticle = ?";

		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(sql);
			pst.setInt(1, noArticle);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				vieilleEnchere = new Enchere(rs.getInt("ench_noUtilisateur"), rs.getInt("ench_montantEnchere"),noArticle);
				thuneVieilleEnchere = vieilleEnchere.getMontantEnchere();
				pst.close();
			}
//			if (vieilleEnchere == null) {
//				String sql5 = "INSERT INTO ENCHERES (ench_noUtilisateur, ench_noArticle,)"
//				
//			}
			
			
			//Update l'enchere
			String sq2 = "UPDATE ENCHERES SET ench_noUtilisateur = ?, ench_montantEnchere = ? WHERE ench_noArticle = ?";
			pst = cnx.prepareStatement(sq2);
			pst.setInt(1, noAcheteur);
			pst.setInt(2, credit );
			pst.setInt(3, noArticle);
			pst.executeUpdate();
			
			pst.close();
			
			utilisateurVieux = trocDAO.selectUserByID(vieilleEnchere.getIdentUtilisateur());
			utilisateurNouveau = trocDAO.selectUserByID(noAcheteur);
			//Rendre les thunes à l'ancien enchereur
			String sq3 = "UPDATE UTILISATEURS SET util_credit = ? WHERE util_ident = ?";
			pst = cnx.prepareStatement(sq3);
			pst.setInt(1, thuneVieilleEnchere + utilisateurVieux.getCredit() );
			pst.setInt(2, utilisateurVieux.getIdent());
			pst.executeUpdate();
			
			pst.close();
			
			//enlever les thunes à l'ancien enchereur
			String sq4 = "UPDATE UTILISATEURS SET util_credit = ? WHERE util_ident = ?";
			pst = cnx.prepareStatement(sq3);
			pst.setInt(1, utilisateurNouveau.getCredit() - credit );
			pst.setInt(2, utilisateurNouveau.getIdent());
			pst.executeUpdate();
			
			pst.close();
			
			
			
		
		} catch (SQLException | TrocEnchereExceptions sl) {
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.ERREUR_FAIRE_ENCHERE);
			
		}

		
		
		
		
	}
	

}
