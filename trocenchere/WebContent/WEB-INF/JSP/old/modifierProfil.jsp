<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            
            <c:if test="${!empty requestScope.pseudo}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="pseudo">Choisi ton nouveau pseudo :</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="" maxlength="30" required value="${requestScope.pseudo}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.mail}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="mail">Choisi ton nouvel email :</label>
                    <input type="email" class="form-control" id="mail" name="mail" placeholder="" maxlength="30" required value="${requestScope.mail}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.telephone}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="telephone">Choisi ton nouveau téléphone :</label>
                    <input type="text" class="form-control" id="telephone" name="telephone" placeholder="" maxlength="30" required value="${requestScope.telephone}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.rue}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="rue">Choisi ta nouvelle rue :</label>
                    <input type="text" class="form-control" id="rue" name="rue" placeholder="" maxlength="30" required value="${requestScope.rue}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.codePostal}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="codePostal">Choisi ton nouveau code postal :</label>
                    <input type="number" class="form-control" id="codePostal" name="codePostal" placeholder="" maxlength="30" required value="${requestScope.codePostal}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.ville}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="ville">Choisi ta nouvelle ville :</label>
                    <input type="text" class="form-control" id="ville" name="ville" placeholder="" maxlength="30" required value="${requestScope.ville}">
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
            </c:if>
            
            <c:if test="${!empty requestScope.motdepasse}">
            	<form class="form-register needs-validation" method="post" action="EnregistrerModifications">
            		<label for="motdepasse">Choisi ton nouveau mot de passe :</label>
                    <input type="password" class="form-control" id="motdepasse" name="motdepasse" placeholder="" maxlength="30" required value="${requestScope.motdepasse}">
            		<label for="confirmationmotdepasse">Confirme ton nouveau mot de passe :</label>
            		<input type="password" class="form-control" id="confirmationmotdepasse" name="confirmationmotdepasse" placeholder="" maxlength="30" required>
            		</br>
            		<input type="submit" value="Enregistrer la modification">
            	</form>
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