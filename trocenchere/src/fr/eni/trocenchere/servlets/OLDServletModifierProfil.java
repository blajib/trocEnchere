package fr.eni.trocenchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/")
public class OLDServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pseudo", request.getParameter("pseudo"));
		request.setAttribute("mail", request.getParameter("mail"));
		request.setAttribute("telephone", request.getParameter("telephone"));
		request.setAttribute("rue", request.getParameter("rue"));
		request.setAttribute("codePostal", request.getParameter("codePostal"));
		request.setAttribute("ville", request.getParameter("ville"));
		request.setAttribute("motdepasse", request.getParameter("motdepasse"));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/modifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
