<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.trocenchere.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Supprimer Compte" name="title"/>
</jsp:include>
<jsp:include page="/WEB-INF/fragments/headerConnecter.jsp"></jsp:include>
<body>
				<c:if test="${empty suppressionRatee}">
					<form class="form-login" method="post" action="supprimerCompte">
						<label for="inputIdentifiant" class="sr-only">Pseudo ou email</label>
							<input type="text" id="inputIdentifiant" class="form-control" name="mail" placeholder="Pseudo ou email" required autofocus value="${requestScope.pseudo_ou_email}">
			                <input type="submit" value="Suppression définitive"/>
					
					</form>
				</c:if>	
				<c:if test="${!empty suppressionRatee}">
                	<form class="form-login" method="post" action="supprimerCompte">
						<label for="inputIdentifiant" class="sr-only">Pseudo ou email</label>
               			 <input type="text" id="inputIdentifiant" class="form-control" name="mail" placeholder="Pseudo ou email" required autofocus value="${requestScope.pseudo_ou_email}">
                		<input type="submit" value="Suppression définitive"/>
						

					</form>
						<div id="blocErreurSupression">
								<p >Votre compte n'a pas été supprimer car votre mail n'est pas correct</p>
								<p>${LecteurMessage.getMessageErreur(suppressionRatee)}</p>
						</div>
                </c:if>
                

<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>
</body>
</html>