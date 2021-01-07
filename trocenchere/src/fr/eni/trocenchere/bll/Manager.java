package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.TrocDAO;
import fr.eni.trocenchere.dal.TrocDAOFactory;


public class Manager {

	TrocDAO trocDAO =TrocDAOFactory.getTrocDAO();

	public boolean verifLogin(String pseudo_ou_email, String motdepasse)   {

		//		String motdepasseBDD = trocDAO.selectMotDePasse(pseudo);
		//		
		//		return motdepasseBDD;

		TrocEnchereExceptions tException = new TrocEnchereExceptions();

		return trocDAO.selectMotDePasse(pseudo_ou_email, motdepasse, tException);
	}


	public boolean creerCompte(Utilisateur utilisateur) throws TrocEnchereExceptions {
		boolean resultat;

		TrocEnchereExceptions tException = new TrocEnchereExceptions();

		this.checkUtilisateur(utilisateur, tException);
		if(!tException.hasErreurs()) {

			try {
				resultat = trocDAO.insert(utilisateur);
			} catch (TrocEnchereExceptions e) {
				throw e;
			}
		}

		else {
			throw tException;
		}
		return resultat;
	}

	public Utilisateur chercherUtilisateurParPseudo(String pseudo_ou_mail) {

		TrocEnchereExceptions tException = new TrocEnchereExceptions();

		Utilisateur utilisateur = trocDAO.selectUserByPseudo(pseudo_ou_mail);
		return utilisateur;
	}
	
	public Utilisateur chercherUtilisateurbyId(int utilisateurID) throws TrocEnchereExceptions {

		return trocDAO.selectUserByID(utilisateurID);
	}

	public void checkUtilisateur(Utilisateur utilisateur, TrocEnchereExceptions tException) {

		if(utilisateur.getPseudo().equals("") ) {tException.ajouterErreur(CodeResultatBLL.PSEUDO_NULL);}
		if(utilisateur.getMotdepasse().equals("")) {tException.ajouterErreur(CodeResultatBLL.MOT_DE_PASSE_NULL);}
		if(utilisateur.getMail().equals("")) {tException.ajouterErreur(CodeResultatBLL.MAIL_NULL);}
		if(utilisateur.getNom().equals("")) {tException.ajouterErreur(CodeResultatBLL.NOM_NULL);}
		if(utilisateur.getPrenom().equals("")) {tException.ajouterErreur(CodeResultatBLL.PRENOM_NULL);}
		if(utilisateur.getRue().equals("")) {tException.ajouterErreur(CodeResultatBLL.RUE_NULL);}
		if(utilisateur.getCodePostal().equals("")) {tException.ajouterErreur(CodeResultatBLL.CODE_POSTAL_NULL);}
		if(utilisateur.getVille().equals("")) {tException.ajouterErreur(CodeResultatBLL.VILLE_NULL);}

	}

	public boolean effacerUtilisateur(String mail) {

		TrocEnchereExceptions tExceptions = new TrocEnchereExceptions();

		return trocDAO.removeUser(mail);
	}


	public void modifierUtilisateur (Utilisateur utilisateurSession) throws TrocEnchereExceptions {

		// teste la validité de l'utilisateur : ses champs textes ne doivent pas être vides
		TrocEnchereExceptions tException = new TrocEnchereExceptions();
		this.checkUtilisateur(utilisateurSession, tException);

		// s'il y a des erreurs : lever une exception
		if(tException.hasErreurs()) {
			throw tException;
		} else { // s'il n'y a pas d'erreur : lancer l'update
			trocDAO.update(utilisateurSession);

			// si après l'update, il y a des erreurs (type échec connexion, ou rien n'a été inséré : pseudo non trouvé, par exemple),
			// lève l'erreur et la propage à la méthode appelante (la Servlet)
			if (tException.hasErreurs()) {
				throw tException;
			}
		}

	}
	
	public List<Utilisateur> selectionnerTousUtilisateurs() throws TrocEnchereExceptions {
		return trocDAO.selectAllPseudo();
	}
	
}
