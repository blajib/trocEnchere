package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bll.Manager;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletEnregistrerModifications
 */
@WebServlet("/EnregistrerModificationsMotDePasse")
public class ServletTraitementEnregistrerModificationsMotDePasse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * Au clic sur "enregistrer la modification", récupération du mot de passe et du mot de passe confirmés
		 * vérification des données (les deux mots de passe sont bien identiques)
		 * une fois la vérification de base faite, appel à la méthode manager modification des données
		 * le manager appellera la méthode update au sein de la DAL
		 * si la méthode est en succès : depuis la ServletEnvoiDonnees, récupérer l'appel à la méthode selectall et valoriser listeUtilisateurs
		 * puis faire pointer sur afficherProfil
		 */

		TrocEnchereExceptions tException = new TrocEnchereExceptions();
		RequestDispatcher rd;
		request.setCharacterEncoding("UTF-8");
		
		// récupération de la session : récupération des données de l'utilisateur
		HttpSession session = request.getSession();
		Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurSession");

		String motDePasse = request.getParameter("motDePasse");
		String motDePasseConfirm = request.getParameter("motDePasseConfirm");

		// si le nouveau mot de passe et la confirmation du mot de passe ne sont pas identiques
		if (!motDePasse.equals(motDePasseConfirm)) {
			tException.ajouterErreur(CodesResultatServlets.MDP_NON_IDENTIQUES);
		}
		
		// si le nouveau mot de passe est le même que l'ancien
		if (utilisateurSession.getMotdepasse().equals(motDePasse)) {
			tException.ajouterErreur(CodesResultatServlets.NOUVEAU_MDP_IDENTIQUE_ANCIEN);
		}
		
		// s'il y a des erreurs de validation servlet
		if(tException.hasErreurs()) {
			request.setAttribute("listeCodesErreurs", tException.getListeCodesErreur());
			rd = request.getRequestDispatcher("/WEB-INF/JSP/modifierMotDePasse.jsp");
			rd.forward(request, response);
		}

		// si aucune anomalie sur le mot de passe, on le remplace dans l'utilisateur
		utilisateurSession.setMotdepasse(motDePasse);
		
		// création du manager
		Manager manager = new Manager();

		// appel à la méthode du manager modifierUtilisateur : le manager devra vérifier
		try {
			manager.modifierUtilisateur(utilisateurSession);
			request.getSession().setAttribute("utilisateurSession", utilisateurSession);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/afficherProfil.jsp");
		} catch (TrocEnchereExceptions e) {
			request.setAttribute("listeCodesErreurs",e.getListeCodesErreur());
			rd = request.getRequestDispatcher("/WEB-INF/JSP/modifierMotDePasse.jsp");
		}
		rd.forward(request, response);

	}

}
