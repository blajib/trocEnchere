package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bll.Manager;
import fr.eni.trocenchere.bll.ManagerArticle;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTraitementRechercherEncheres
 */
@WebServlet("/RechercherEncheres")
public class ServletTraitementRechercherEncheres extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		request.setAttribute("categorie", categorie);
		
		String filtre = request.getParameter("filtre");
		request.setAttribute("filtre", filtre);
		
		Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("utilisateurSession");
		int identifiantUtilisateurConnecte = 0;
		if (utilisateurConnecte != null) {
			identifiantUtilisateurConnecte = utilisateurConnecte.getIdent();
		}
		
		// récupération du type de l'enchère : "achats" ou "ventes"
		String typeEnchere = request.getParameter("type-encheres");
		request.setAttribute("typeEnchere", typeEnchere);
		
		// récupération des valeurs des différentes checkbox : il peut y en avoir jusqu'à 3
		// transformation en liste de ces paramètres
		String[] etatVenteTableau = request.getParameterValues("etatVente");
		List<String> etatVente = new ArrayList<String>();
		if (etatVenteTableau != null) {
			etatVente = Arrays.asList(etatVenteTableau);
		}
		String etatVenteString = etatVente.toString().replace("[", "").replace("]", "");
		request.setAttribute("etatVenteString", etatVenteString);
		
		String[] etatAchatTableau = request.getParameterValues("etatAchat");
		List<String> etatAchat = new ArrayList<String>();
		if (etatAchatTableau != null) {
			etatAchat = Arrays.asList(etatAchatTableau);
		}
		String etatAchatString = etatAchat.toString().replace("[", "").replace("]", "");
		request.setAttribute("etatAchatString", etatAchatString);
		
		ManagerArticle managerArticle = new ManagerArticle();
		Manager manager = new Manager();
		
		List<ArticleVendu> encheres = managerArticle.chercherEncheres(typeEnchere, etatVente, etatAchat, categorie, filtre, identifiantUtilisateurConnecte);
		try {
			List<Utilisateur> listeUtilisateurs = manager.selectionnerTousUtilisateurs();
			request.setAttribute("listeUtilisateurs", listeUtilisateurs);
		} catch (TrocEnchereExceptions e) {
			request.setAttribute("listeCodesErreurs", e.getListeCodesErreur());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		request.setAttribute("encheres", encheres);
		rd.forward(request, response);
	}

}
