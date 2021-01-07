<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.trocenchere.messages.LecteurMessage" %>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Mettre article" name="title" />
</jsp:include>
<body>
	<div class="container-fluid">
		<!--emptyHeader-->
		<jsp:include page="/WEB-INF/fragments/emptyheader.jsp"></jsp:include>

		<!--main bloc-->
		<main>
			<!--title-->
			<div class="mx-auto text-center">
				<h1>${sessionScope.utilisateurSession.prenom}
					${sessionScope.utilisateurSession.nom}</h1>
				<img class="mb-4 large-icon rounded-circle"
					src="images/${sessionScope.utilisateurSession.pseudo}.jpg" alt="">
			</div>

			<h2 class="mx-auto text-center">Envoyer article</h2>

			<form class="form-register needs-validation" method="post"
				action="ServletTraitementCreationArticle">
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="nomArticle">Nom article</label> <input type="text" class="form-control" id="nomArticle" name="nomArticle" maxlength="30" required >
							
							
					</div>

					<div class="col-md-6 mb-3">
						<label for="description">Description</label>
						<textarea name="descriptionArticle" id="descriptionArticle"
							rows="10" cols="50" maxlength="50"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 mb-3">
						<p>
						       <label for="categorie">Categorie</label><br />
						       <select name="categorie" id="categorie">
						           <option value="1">informatique</option>
						           <option value="2">ameublement</option>
						           <option value="3">Vetement</option>
						           <option value="4">Sport</option>
						       </select>
						   </p>
					</div>
				</div>
				

				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="dateDebut">Date début enchère</label> <input type="date" class="form-control" id="dateDebut" name="dateDebut" maxlength="30" required >
							
							
					</div>

					<div class="col-md-6 mb-3">
						<label for="heureDebut">Heure début enchere</label> <input type="time" class="form-control" id="heureDebut" name="heureDebut" maxlength="100" required >
							
							
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="dateFin">Date fin d'enchere</label> <input type="date" class="form-control" id="dateFin" name="dateFin" maxlength="100" required>
							
							
					</div>

					<div class="col-md-6 mb-3">
						<label for="heureFin">Heure fin d'enchere</label> <input type="time" class="form-control" id="heureFin" name="heureFin" maxlength="100" required>
							
							
					</div>
				</div>

				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="prixInitial">Prix initial</label> <input type="number" class="form-control" id="prixInitial" name="prixInitial" maxlength="30" required>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="etatVente">Lien image si image</label> 
						<input type="text" class="form-control" id="lienImage" name="lienImage">
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="rue">Nom de la rue</label>
						<input type="text" class="form-control" id="rue" name="rue" value="${sessionScope.utilisateurSession.rue}" required>
					</div>

					<div class="col-md-4 mb-3">
						<label for="codePostal">Code postale</label> 
						<input type="number" class="form-control" id="codePostal" name="codePostal" min="01000" max="99999" value="${sessionScope.utilisateurSession.codePostal}" required>
					</div>

					<div class="col-md-4 mb-3">
						<label for="ville">Ville</label> 
						<input type="text" class="form-control" id="villeRetrait" name="ville" value="${sessionScope.utilisateurSession.ville}"required>
					</div>	
				</div>

				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit">Envoyer l'article</button>
			</form>
			<c:if test="${!empty exceptionsBLL}">
	           <div class="d-flex alert-danger">
		                <div class="col-3 p-2">
		                    <img class="small-icon" src="images/error.svg">
		                </div>
		            
		                <ul>
							<c:forEach var="code" items="${exceptionsBLL}">
								<li>${LecteurMessage.getMessageErreur(code)}</li>
							</c:forEach>	
						</ul>
	            </div>   
            </c:if>	   
            <c:if test="${!empty exceptionsManager}">
	           <div class="d-flex alert-danger">
		                <div class="col-3 p-2">
		                    <img class="small-icon" src="images/error.svg">
		                </div>
		            
		                <ul>
							<c:forEach var="code" items="${exceptionsManager}">
								<li>${LecteurMessage.getMessageErreur(code)}</li>
							</c:forEach>	
						</ul>
	            </div>   
            </c:if>

		</main>
		<!--footer-->
		<jsp:include page="/WEB-INF/fragments/footer.jsp"></jsp:include>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>