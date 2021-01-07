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
import fr.eni.trocenchere.bll.CodeResultatBLL;
import fr.eni.trocenchere.bll.Manager;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletEnregistrerModifications
 */
@WebServlet("/EnregistrerModificationsProfil")
public class ServletTraitementEnregistrerModificationsProfil extends HttpServlet {
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
		 * Au clic sur "enregistrer la modification", récupération de toutes les données
		 * vérification des données (code postal est bien un chiffre, les Strings ne sont pas vides...)
		 * une fois la vérification de base faite, appel à la méthode manager modification des données
		 * le manager appellera la méthode update au sein de la DAL
		 * si la méthode est en succès : depuis la ServletEnvoiDonnees, récupérer l'appel à la méthode selectall et valoriser listeUtilisateurs
		 * puis faire pointer sur afficherProfil
		 */

		TrocEnchereExceptions tException = new TrocEnchereExceptions();
		int codePostalInt = 0;
		String codePostal = "";
		RequestDispatcher rd;
		request.setCharacterEncoding("UTF-8");

		String pseudo = request.getParameter("pseudo");
		String mail = request.getParameter("mail");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		try {
			codePostalInt = Integer.parseInt(request.getParameter("codePostal"));
			codePostal = request.getParameter("codePostal");
		} catch (NumberFormatException e1) {
			tException.ajouterErreur(CodeResultatBLL.CODE_POSTAL_LETTRE);

		}
		String ville = request.getParameter("ville");

		Manager manager = new Manager();
		
		HttpSession session = request.getSession();
		Utilisateur utilisateurSession = (Utilisateur) session.getAttribute("utilisateurSession");
		//Utilisateur utilisateurSession = new Utilisateur(pseudo,mail,motDePasse,nom,prenom,telephone,rue,codePostal,ville);
		
		utilisateurSession.setPseudo(pseudo);
		utilisateurSession.setMail(mail);
		utilisateurSession.setNom(nom);
		utilisateurSession.setPrenom(prenom);
		utilisateurSession.setTelephone(telephone);
		utilisateurSession.setRue(rue);
		utilisateurSession.setCodePostal(codePostal);
		utilisateurSession.setVille(ville);

		// appel à la méthode du manager modifierUtilisateur : le manager devra vérifier
		try {
			manager.modifierUtilisateur(utilisateurSession);
			request.getSession().setAttribute("utilisateurSession", utilisateurSession);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/afficherProfil.jsp");
		} catch (TrocEnchereExceptions e) {
			request.setAttribute("listeCodesErreurs",e.getListeCodesErreur());
			rd = request.getRequestDispatcher("/WEB-INF/JSP/modifierProfil.jsp");
		}

		rd.forward(request, response);

	}

}
