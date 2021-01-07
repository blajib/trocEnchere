package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ServletCreerCompte
 */
@WebServlet("/ServletCreerCompte")
public class ServletTraitementCreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrocEnchereExceptions tException = new TrocEnchereExceptions();
		int codePostalInt = 0;
		String codePostal = "";
		RequestDispatcher rd;
		request.setCharacterEncoding("UTF-8");
		boolean resultatInsertion = false;
		
		boolean exister = false;
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");
		String motDePasseConfirm = request.getParameter("motDePasseConfirm");
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
		
	
		//je fais la verif de la confirmation du mot de passe dans la servlet
		if(motDePasseConfirm.equals(motDePasse)){
			Utilisateur utilisateur = new Utilisateur(pseudo,mail,motDePasse,nom,prenom,telephone,rue,codePostal,ville);

			try {
				resultatInsertion = manager.creerCompte(utilisateur);
			} catch (TrocEnchereExceptions e) {
				request.setAttribute("listeCodesErreurs",e.getListeCodesErreur());	
			}

			if(tException.hasErreurs() || request.getAttribute("listeCodesErreurs") != null || resultatInsertion == false) {
				rd = request.getRequestDispatcher("/WEB-INF/JSP/register.jsp");}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("utilisateurSession", utilisateur);
				rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
			}
			rd.forward(request, response);
	
		} else {
			tException.ajouterErreur(CodesResultatServlets.MDP_NON_IDENTIQUES);
			request.setAttribute("listeCodesErreurs", tException.getListeCodesErreur());
			rd = request.getRequestDispatcher("/WEB-INF/JSP/register.jsp");
			rd.forward(request, response);	
		}

	}
}
