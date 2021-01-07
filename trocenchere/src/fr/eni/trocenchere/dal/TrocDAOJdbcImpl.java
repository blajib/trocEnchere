package fr.eni.trocenchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.Utilisateur;

public class TrocDAOJdbcImpl implements TrocDAO  {
	
	PreparedStatement requeteParametree;
	
	@Override
	public boolean selectMotDePasse(String pseudo_ou_email, String motdepasse, TrocEnchereExceptions tExceptions) {
		String sql = "SELECT util_motdepasse\r\n" + 
				"FROM UTILISATEURS\r\n" + 
				"WHERE (util_pseudo = ? OR util_email = ?);";
		String motdepasseBDD = null;
		boolean mdpIdentiques = false;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(sql);
			requeteParametree.setString(1, pseudo_ou_email);
			requeteParametree.setString(2, pseudo_ou_email);
			ResultSet rs = requeteParametree.executeQuery();
			
			if (rs.next()) {
				motdepasseBDD = rs.getString(1);
				if (motdepasse.equals(motdepasseBDD)) {
					mdpIdentiques = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			tExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
		}
		
		return mdpIdentiques;
	}

	/**
	 * Fonction inserer utilisateur avec 9 para
	 * Je ne fais aucune verif dedans elles seront dans les couches superieurs.
	 * Voir pour après les exceptions sql
	 * @throws TrocEnchereExceptions 
	 */
	@Override
	public boolean insert(Utilisateur utilisateur) throws TrocEnchereExceptions{
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		boolean resultat = false;
		String sql = "INSERT INTO UTILISATEURS (util_pseudo, util_motdepasse, util_email,util_nom,util_prenom,util_telephone,util_rue,util_codePostal,util_ville,util_credit,util_administrateur) \r\n" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			requeteParametree.setString(1, utilisateur.getPseudo());
			requeteParametree.setString(2, utilisateur.getMotdepasse());
			requeteParametree.setString(3, utilisateur.getMail());
			requeteParametree.setString(4, utilisateur.getNom());
			requeteParametree.setString(5, utilisateur.getPrenom());
			requeteParametree.setString(6, utilisateur.getTelephone());
			requeteParametree.setString(7, utilisateur.getRue());
			requeteParametree.setString(8, utilisateur.getCodePostal());
			requeteParametree.setString(9, utilisateur.getVille());
			requeteParametree.setInt(10, utilisateur.getCredit());
			requeteParametree.setByte(11, utilisateur.getAdministrateur());
		
			
			 int affectedRows = requeteParametree.executeUpdate();
			 if(affectedRows == 0) {
				 throw new SQLException("Creating user failed, no rows affected.");
				 
			 }
			 if (affectedRows == 1) {
	                ResultSet rs = requeteParametree.getGeneratedKeys();
	                if(rs.next()) {
	                    utilisateur.setIdent(rs.getInt(1));  
	                    resultat = true;
	                }
	            }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.INSERTION_ECHEC);
			throw trocEnchereExceptions;


		}

		return resultat;

	}
	
	@Override
	public Utilisateur selectUserByPseudo(String pseudo_ou_mail) {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();

		
		String sql = "SELECT * \r\n" + 
				"FROM UTILISATEURS\r\n" + 
				"WHERE (util_pseudo = ? OR util_email = ? );";
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(sql);
			requeteParametree.setString(1, pseudo_ou_mail);
			requeteParametree.setString(2, pseudo_ou_mail);
			ResultSet rs = requeteParametree.executeQuery();
			
			if (rs.next()) {
				 utilisateur = new Utilisateur(rs.getInt("util_ident"),rs.getString("util_pseudo"),
						  rs.getString("util_email"),rs.getString("util_motDePasse"),
						 rs.getString("util_nom"), rs.getString("util_prenom"),
						 rs.getString("util_telephone"), rs.getString("util_rue"), rs.getString("util_codePostal"),
						 rs.getString("util_ville"),rs.getInt("util_credit"));
				
			}

		} catch (SQLException e) {
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
			
		}
		
		return utilisateur;
	
	}
	@Override
	public boolean removeUser(String mail) {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();

		int delete;
		boolean resultat = true;
		
		String sql = "DELETE  \r\n" + 
				"FROM UTILISATEURS\r\n" + 
				"WHERE (util_email = ? );";
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(sql);
			requeteParametree.setString(1, mail);
			delete =  requeteParametree.executeUpdate();
			
//			if (rs.next()) {
//				 
//				
//			}

		} catch (SQLException e) {
			e.printStackTrace();
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
			return false;
		}
		if(delete == 1) {
			resultat = true;
		}else {
			resultat = false;
		}
		
		return resultat;
	}

	public void update (Utilisateur utilisateur) throws TrocEnchereExceptions {
		String SQL = "UPDATE UTILISATEURS SET util_pseudo = ?, util_motdepasse = ?, util_email = ?, util_nom = ?, util_prenom = ?, util_telephone = ?, util_rue = ?,\r\n" +
				"util_codePostal = ?, util_ville = ?, util_credit = ?\r\n" +
				"WHERE util_pseudo = ?;";
		int insert;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(SQL);
			
			requeteParametree.setString(1, utilisateur.getPseudo());
			requeteParametree.setString(2, utilisateur.getMotdepasse());
			requeteParametree.setString(3, utilisateur.getMail());
			requeteParametree.setString(4, utilisateur.getNom());
			requeteParametree.setString(5, utilisateur.getPrenom());
			requeteParametree.setString(6, utilisateur.getTelephone());
			requeteParametree.setString(7, utilisateur.getRue());
			requeteParametree.setString(8, utilisateur.getCodePostal());
			requeteParametree.setString(9, utilisateur.getVille());
			requeteParametree.setInt(10, utilisateur.getCredit());
			requeteParametree.setString(11, utilisateur.getPseudo());
			
			insert = requeteParametree.executeUpdate();
			
			// si l'insert a échoué : lève une exception
			if (insert != 1) {
				System.out.println("Echec de la mise à jour");
				TrocEnchereExceptions tExceptions = new TrocEnchereExceptions();
				tExceptions.ajouterErreur(CodeResultatDAL.MISE_A_JOUR_ECHEC);
				throw tExceptions;
			}
		
		// si la connexion à la BDD a échoué : lève une exception
		} catch (SQLException e) {
			e.printStackTrace();
			TrocEnchereExceptions tExceptions = new TrocEnchereExceptions();
			tExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
			throw tExceptions;
		}
		
	}

	@Override
	public Utilisateur selectUserByID(int utilisateurID) throws TrocEnchereExceptions {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();

		String sql = "SELECT * \r\n" + 
				"FROM UTILISATEURS\r\n" + 
				"WHERE util_ident = ?;";
		Utilisateur utilisateur = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			requeteParametree = cnx.prepareStatement(sql);
			requeteParametree.setInt(1, utilisateurID);
			ResultSet rs = requeteParametree.executeQuery();
			
			if (rs.next()) {
				 utilisateur = new Utilisateur(rs.getInt("util_ident"),rs.getString("util_pseudo"),
						 rs.getString("util_motDePasse"), rs.getString("util_email"),
						 rs.getString("util_nom"), rs.getString("util_prenom"),
						 rs.getString("util_telephone"), rs.getString("util_rue"), rs.getString("util_codePostal"),
						 rs.getString("util_ville"));
				
			} else {
				trocEnchereExceptions.ajouterErreur(CodeResultatDAL.ERREUR_LECTURE_UTILISATEUR);
				throw trocEnchereExceptions;
			}

		} catch (SQLException e) {
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
			throw trocEnchereExceptions;
		}
		
		return utilisateur;
	}
	
	@Override
	public List<Utilisateur> selectAllPseudo() throws TrocEnchereExceptions {
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();

		String sql = "SELECT DISTINCT util_ident, util_pseudo\r\n" + 
				"FROM UTILISATEURS\r\n" + 
				"ORDER BY util_ident ASC;";
		Utilisateur utilisateur = null;
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement requete = cnx.createStatement();
			ResultSet rs = requete.executeQuery(sql);
			
//			if (!rs.next()){
//				trocEnchereExceptions.ajouterErreur(CodeResultatDAL.ERREUR_LECTURE_UTILISATEUR);
//				throw trocEnchereExceptions;
//			}
//			rs.beforeFirst();
			
			while (rs.next()) {
				 utilisateur = new Utilisateur(rs.getInt("util_ident"),rs.getString("util_pseudo"));
				 listeUtilisateurs.add(utilisateur);
			} 
			
			if (listeUtilisateurs.size() == 0) {
				trocEnchereExceptions.ajouterErreur(CodeResultatDAL.ERREUR_LECTURE_UTILISATEUR);
				throw trocEnchereExceptions;
			}
			

		} catch (SQLException e) {
			trocEnchereExceptions.ajouterErreur(CodeResultatDAL.CONNEXION_BDD_ECHEC);
			throw trocEnchereExceptions;
		}
		
		return listeUtilisateurs;
	}
		
}
	


