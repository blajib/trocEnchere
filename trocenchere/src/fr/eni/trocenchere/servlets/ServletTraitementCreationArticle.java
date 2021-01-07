package fr.eni.trocenchere.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.tomcat.jni.Time;
import org.eclipse.jdt.internal.compiler.tool.Archive;

import fr.eni.trocenchere.Format;
import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bll.CodeResultatBLL;
import fr.eni.trocenchere.bll.ManagerArticle;
import fr.eni.trocenchere.bo.ArticleVendu;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Retrait;
import fr.eni.trocenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTraitementCreationArticle
 */
@WebServlet("/ServletTraitementCreationArticle")
public class ServletTraitementCreationArticle extends HttpServlet {
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
		RequestDispatcher rd;
		String retourMiseEnchere = null;
		ManagerArticle ma = new ManagerArticle(); 
		TrocEnchereExceptions tException = new TrocEnchereExceptions();
		TrocEnchereExceptions tException2 = new TrocEnchereExceptions();
		LocalDateTime dateToday = LocalDateTime.now();		
		int noUtilisateurInt = 0;
		int categorie = 0;

		
		
		
		Utilisateur utilisateurSession = (Utilisateur)request.getSession().getAttribute("utilisateurSession");
		noUtilisateurInt = utilisateurSession.getIdent();
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("descriptionArticle");
		LocalDateTime dateDebutEnchere = null;
		LocalDateTime dateFinEnchere = null;
		String etat = null;
		int prixInitial = 0;
		try {
			categorie = Integer.parseInt(request.getParameter("categorie"));
		} catch (NumberFormatException e1) {
			tException.ajouterErreur(CodeResultatBLL.ERREUR_CATEGORIE);
			
		}
		
		// Si on ne récupère pas une date je récupère l'exception dansDateTimeException puis je rajoute mon code
		String dateDebut = request.getParameter("dateDebut");
		String dateDebutHeure = request.getParameter("heureDebut");
		try {
			dateDebutEnchere = Format.convertStringToLocalDateTime(dateDebut+" "+dateDebutHeure);
		} catch (DateTimeException de) {
			tException.ajouterErreur(CodeResultatBLL.ERREUR_DATE_DEBUT);
		}
		
		//pareil qu'au dessus
		String dateFin = request.getParameter("dateFin");
		String dateFinHeure = request.getParameter("heureFin");

		try {
			dateFinEnchere = Format.convertStringToLocalDateTime(dateFin+" "+dateFinHeure);
		} catch (DateTimeException de) {
			tException.ajouterErreur(CodeResultatBLL.ERREUR_DATE_FIN);
		}
		try {
			if(dateDebutEnchere.isBefore(dateToday)) {
				 etat = "PV";
				}
			if(dateDebutEnchere.isAfter(dateToday)) {
				 etat = "EC";
				}
			if(dateFinEnchere.isBefore(dateToday)) {
				 etat = "TER";
				}
			
		} catch (Exception e) {
			tException.ajouterErreur(CodeResultatBLL.ERREUR_DATE_DEBUT);
		}
		
		
		
		// verif si le prix initial est bien un chiffre et pas des lettres
		try {
			prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
		} catch (NumberFormatException e) {
			tException.ajouterErreur(CodeResultatBLL.PRIX_INITIAL_NON_CHIFFRE);


		}
		String lienImage = request.getParameter("lienImage");
		
		String rue = request.getParameter("rue");
		String cpo = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		ArticleVendu article = new ArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, prixInitial, noUtilisateurInt, categorie, etat, lienImage);
		Retrait retrait = new Retrait(rue,cpo,ville);
		try {
			ma.insertArticle(article,retrait);
		} catch (TrocEnchereExceptions e) {
			tException.ajouterErreur(CodeResultatBLL.ERREUR_INSERTION);
			tException2 = e;
			request.setAttribute("exceptionsBLL", tException.getListeCodesErreur());
			request.setAttribute("exceptionsManager", e.getListeCodesErreur());


		}
		
		retourMiseEnchere = "yeah ça marche";
		request.setAttribute("retourMiseEnchere", retourMiseEnchere );
		rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		rd.forward(request, response);

	}

}
