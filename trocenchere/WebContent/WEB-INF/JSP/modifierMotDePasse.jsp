<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.trocenchere.messages.LecteurMessage" %>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Modification profil" name="title"/>
</jsp:include>
<body>
    <div class="container-fluid">
        <!--emptyHeader-->
		<jsp:include page="/WEB-INF/fragments/emptyheader.jsp"></jsp:include>

        <!--main bloc-->
        <main>
            <!--title-->
            <div class="mx-auto text-center">
                <h1>${sessionScope.utilisateurSession.prenom} ${sessionScope.utilisateurSession.nom}</h1>
                <img class="mb-4 large-icon rounded-circle" src="images/${sessionScope.utilisateurSession.pseudo}.jpg" alt="">
            </div>
            
            <h2 class="mx-auto text-center">Modification</h2>
            
            <form class="form-register needs-validation" method="post" action="EnregistrerModificationsMotDePasse">                   
				<div class="row">
				    <div class="col-md-6 mb-3">
				        <label for="motDePasse">Mot de passe</label>
				        <input type="password" class="form-control" id="motDePasse" name="motDePasse" minlength="6" maxlength="30" value="${sessionScope.utilisateurSession.motdepasse}" required>
				    </div>
				
				    <div class="col-md-6 mb-3">
				        <label for="motDePasseConfirm">Confirmation</label>
				        <input type="password" class="form-control" id="motDePasseConfirm" name="motDePasseConfirm" required>
				    </div>
				</div>                
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Enregistrer les modifications</button>
            </form>
            
            <c:if test="${!empty listeCodesErreurs}">
	           <div class="d-flex alert-danger">
		                <div class="col-3 p-2">
		                    <img class="small-icon" src="images/error.svg">
		                </div>
		            
		                <ul>
							<c:forEach var="code" items="${listeCodesErreurs}">
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>