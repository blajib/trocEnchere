package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocenchere.bll.Manager;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletEnvoiDonnees
 */
@WebServlet("/ServletEnvoiDonnees")
public class ServletTraitementSeConnecter extends HttpServlet {
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
		
		String pseudo_ou_email = request.getParameter("pseudo_ou_email");
		String motdepasse = request.getParameter("motdepasse");
		RequestDispatcher rd;
		
		Manager manager = new Manager();
		
		boolean mdpIdentiques = manager.verifLogin(pseudo_ou_email, motdepasse);
		
		if (mdpIdentiques) {
			
			/**
			 * Essai par la suite d'ouvrir une session. Mais je dois d'abord faire une methose select by pseudo pour récupérer les 
			 * attribut de l'utilisateur pour pouvoir par la suite les inserer dans ça page de session
			 */
			// récupération de la session, ou s'il n'y en a pas, créé une session
			HttpSession session = request.getSession();
			Utilisateur utilisateurSession = manager.chercherUtilisateurParPseudo(pseudo_ou_email);
			session.setAttribute("utilisateurSession", utilisateurSession);
			session.setAttribute("idUtilisateur", utilisateurSession.getIdent());
			rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		} else {
			request.setAttribute("pseudo_ou_email", pseudo_ou_email);
			request.setAttribute("motdepasse", motdepasse);
			request.setAttribute("authentificationRatee", CodesResultatServlets.MAUVAISE_COMBINAISON_ERREUR);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
		}

		rd.forward(request, response);		
		
	}

}
