package fr.eni.trocenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	public void insertArticle(ArticleVendu article,Retrait retrait) throws TrocEnchereExceptions {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		Enchere enchere = new Enchere();
		String sqlArticle = "INSERT INTO ARTICLES (art_nomArticle, art_description,art_ptrcatnocat, art_dateDebut,art_dateFin,art_miseAPrix,art_prixVente,art_etatVente,art_image,art_ptrutilident) \r\n" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement requeteParametree;
			requeteParametree = cnx.prepareStatement(sqlArticle,PreparedStatement.RETURN_GENERATED_KEYS);
			requeteParametree.setString(1, article.getNomArticle());
			requeteParametree.setString(2, article.getDescription());
			requeteParametree.setInt(3, article.getCategorie());
			requeteParametree.setTimestamp(4,Timestamp.valueOf(article.getDateDebutEnchere()));
			requeteParametree.setTimestamp(5,Timestamp.valueOf(article.getDateFinEnchere()));
			requeteParametree.setInt(6, article.getMiseAPrix());;
			requeteParametree.setInt(7, article.getPrixDeVente());
			requeteParametree.setString(8, article.getEtatVente());
			requeteParametree.setString(9, article.getImage());
			requeteParametree.setInt(10, article.getIdentUtilisateur());
			
			 int affectedRows = requeteParametree.executeUpdate();
			 if(affectedRows == 0) {
				 throw new SQLException("Creating user failed, no rows affected.");
				 
			 }
			 if (affectedRows == 1) {
	                ResultSet rs = requeteParametree.getGeneratedKeys();
	                if(rs.next()) {
	                    article.setNoArticle(rs.getInt(1));  

	                }
	            }
		 requeteParametree.close();
		 
		 
	 
		 String sqlRetrait = "INSERT INTO RETRAITS  \r\n" + 
						"VALUES (?,?,?,?)";
		 	requeteParametree = cnx.prepareStatement(sqlRetrait);
		 	requeteParametree.setInt(1, article.getNoArticle());
		 	requeteParametree.setString(2, retrait.getRue());
		 	requeteParametree.setString(3, retrait.getCodePostaleRetrait());
		 	requeteParametree.setString(4, retrait.getVille());
		 	
		 	requeteParametree.executeUpdate();
		 	requeteParametree.close();
		 	
		 String sqlEnchere = "INSERT INTO ENCHERES (ench_noUtilisateur,ench_noArticle, ench_dateEnchere,ench_montantEnchere) \r\n" + 
					"VALUES (?,?,?,?)";
		 requeteParametree = cnx.prepareStatement(sqlEnchere);
		 requeteParametree.setInt(1, article.getIdentUtilisateur());
		 requeteParametree.setInt(2, article.getNoArticle());
		 requeteParametree.setTimestamp(3,Timestamp.valueOf(article.getDateFinEnchere()));
		 requeteParametree.setInt(4, article.getPrixDeVente());
		 
		 requeteParametree.executeUpdate();
		 requeteParametree.close();

			
		} catch (SQLException e) {
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.ERREUR_INSERTION_ARTICLE);
				throw trocEnchereExceptions;
		}
	
	}
	
	public List<ArticleVendu> selectEncheres (String typeEnchere, List<String> etatVente, List<String> etatAchat, int categorie, String filtre, int identifiantUtilisateurConnecte) {
		
		String etatVenteString = etatVente.toString().replace("[", "").replace("]", "");
		String etatAchatString = etatAchat.toString().replace("[", "").replace("]", "");
		ArticleVendu article = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ARTICLES.*").append(System.getProperty("line.separator"));
		sb.append("FROM ARTICLES").append(System.getProperty("line.separator"));
		
		// si je veux lister mes enchères en cours :
		// Valable si typeEnchere vaut achats
		if (typeEnchere.equals("achats")) {
			sb.append("JOIN ENCHERES ON ench_noArticle = art_noArticle").append(System.getProperty("line.separator"));
			sb.append("JOIN UTILISATEURS ON ench_noUtilisateur = util_ident").append(System.getProperty("line.separator"));
		}
		
		// si je veux lister mes ventes :
		// Valable si typeEnchere vaut ventes
		if (typeEnchere.equals("ventes")) {
			sb.append("JOIN UTILISATEURS ON art_ptrutilident = util_ident").append(System.getProperty("line.separator"));
		}
		
		// sb.append("WHERE 1 = 1").append(System.getProperty("line.separator"));
		
		// Etat de la vente : 
		// si la taille de la liste est de 1 : faire une requête =
		// si la taille de la liste est supérieure à 1 : faire une requête IN
		if (etatVente.size() == 1) {
			sb.append("WHERE art_etatVente = ").append(etatVenteString).append(System.getProperty("line.separator"));
		} else if (etatVente.size() > 1) {
			sb.append("WHERE art_etatVente IN (").append(etatVenteString).append(")").append(System.getProperty("line.separator"));
		}
		
		if (etatAchat.size() == 1) {
			sb.append("WHERE art_etatVente = ").append(etatAchatString).append(System.getProperty("line.separator"));
		} else if (etatAchat.size() > 1) {
			sb.append("WHERE art_etatVente IN (").append(etatAchatString).append(")").append(System.getProperty("line.separator"));
		}
		
		if (etatVente.size() == 0 && etatAchat.size() == 0) {
			sb.append("WHERE art_etatVente IN ('PV', 'EC', 'TER')").append(System.getProperty("line.separator"));
		}
		
		// filtre sur le nom d'article :
		// à faire apparaître si le filtre n'est pas vide
		if (!filtre.isEmpty()) {
			sb.append("AND art_nomArticle LIKE '%").append(filtre).append("%'").append(System.getProperty("line.separator"));
		}
		
		// filtre sur la catégorie : 
		// à faire apparaître si la catégorie ne vaut pas 0
		if (categorie != 0) {
			sb.append("AND art_ptrcatnocat = ").append(categorie).append(System.getProperty("line.separator"));
		}
		
		// filtre sur l'identifiant utilisateur :
		// à faire apparaître si l'identifiant ne vaut pas 0 (autrement dit, si on est connecté)
		// MAIS ne pas faire apparaître si Vente et si liste.size == 0
		if (identifiantUtilisateurConnecte != 0 && etatVente.size() >= 1) {
			sb.append("AND util_ident = ").append(identifiantUtilisateurConnecte).append(System.getProperty("line.separator"));
		}
		
		sb.append(";");
		
		String sql = sb.toString();
		
//		String sql = "SELECT * \r\n" + 
//				"FROM ARTICLES\r\n" + 
//				"WHERE art_etatVente = 'EC'\r\n" + 
//				"AND art_nomArticle LIKE ? \r\n" + 
//				"AND (? IS NULL OR art_ptrcatnocat = ?);";
		List<ArticleVendu> encheres = new ArrayList<ArticleVendu>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			// Requête paramétrée : vaut pour l'ancienne méthode
//			PreparedStatement requeteParametree = cnx.prepareStatement(sql);
//			requeteParametree.setString(1, "%"+filtre+"%");
//
//			if(categorie > 0) {
//				requeteParametree.setInt(2,  categorie);
//				requeteParametree.setInt(3,  categorie);
//			}
//			else {
//				requeteParametree.setNull(2,  Types.NULL);
//				requeteParametree.setNull(3,  Types.NULL);
//			}
//			
//			//requeteParametree.setString(2, categorie); // ATTENTION à remanier : transformer ce string en liste de int
//			ResultSet rs = requeteParametree.executeQuery();
			
			Statement requete = cnx.createStatement();
			ResultSet rs = requete.executeQuery(sql);
			
			while (rs.next()) {
				Timestamp timestamp = new Timestamp(rs.getDate(4).getTime());
				LocalDateTime art_dateDebut = timestamp.toLocalDateTime();
				
				timestamp = new Timestamp(rs.getDate(5).getTime());
				LocalDateTime art_dateFin = timestamp.toLocalDateTime();
				
				article = new ArticleVendu(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						art_dateDebut, 
						art_dateFin, 
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9), 
						rs.getInt(10),
						rs.getInt(11));
				encheres.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return encheres;
	}
}
