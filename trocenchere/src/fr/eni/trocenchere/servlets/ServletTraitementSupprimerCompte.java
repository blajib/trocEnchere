package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bll.Manager;

/**
 * Servlet implementation class ServletSupprimerCompte
 */
@WebServlet("/supprimerCompte")
public class ServletTraitementSupprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/JSP/supprimerCompte.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		RequestDispatcher rd;
		TrocEnchereExceptions trocEnchereExceptions = new TrocEnchereExceptions();
		boolean suppression = true;
		
		Manager mg = new Manager();
		if(mg.effacerUtilisateur(mail)== false) {
			suppression = false;
			request.setAttribute("suppression", suppression);
			//request.setAttribute("suppressionRatee", CodesResultatServlets.ERREUR_ATHENTIFICATION_SUPPRESSION);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/supprimerCompte.jsp");
			
			
		}else {
			suppression = true;
			request.setAttribute("suppression", suppression);
			rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
			request.getSession().invalidate();
			
		}
		
		
		rd.forward(request, response);	
		
		

	}

}
