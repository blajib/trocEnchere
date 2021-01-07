package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bll.CodeResultatBLL;
import fr.eni.trocenchere.bll.ManagerArticle;
import fr.eni.trocenchere.bll.ManagerEnchere;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTraitementFaireEnchere
 */
@WebServlet("/ServletTraitementFaireEnchere")
public class ServletTraitementFaireEnchere extends HttpServlet {
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
		ManagerEnchere me = new ManagerEnchere();
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateurSession");
		RequestDispatcher rd;
	
		int noArticle = 0;
		int noAcheteur = 0;
		int credit = 0;
		try {
			noArticle = Integer.parseInt(request.getParameter("noArticle"));
			noAcheteur = utilisateur.getIdent();
			
			
			credit = Integer.parseInt(request.getParameter("credit"));
		} catch (NumberFormatException e) {
			trocEnchereExceptions.ajouterErreur(CodeResultatBLL.ERREUR_CHIFFRE_SAISI);
			e.printStackTrace();
		}
		
		
		
		me.mettreEnchere(noArticle,noAcheteur,credit);
		rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		rd.forward(request, response);
		
		
		

	}

}
