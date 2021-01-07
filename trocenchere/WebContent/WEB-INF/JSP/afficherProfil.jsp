<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Affichage profil" name="title"/>
</jsp:include>
<body>
    <div class="container-fluid">
        <!--emptyHeader-->
		<jsp:include page="/WEB-INF/fragments/emptyheader.jsp"></jsp:include>

        <!--main bloc-->
        <main>
            <!--title-->
            <div class="mx-auto text-center">
                <h1>Bienvenue ${sessionScope.utilisateurSession.prenom} ${sessionScope.utilisateurSession.nom}</h1>
                <img class="mb-4 large-icon rounded-circle" src="images/${sessionScope.utilisateurSession.pseudo}.jpg" alt="">
            </div>
            
            <div class="form-register needs-validation">
				<div class="row">
		            <div class="col-md-6 mb-3">
		                <label for="pseudo">Pseudo</label>
		                <input readonly="readonly" type="text" class="form-control" id="pseudo" name="pseudo" maxlength="30" required value="${sessionScope.utilisateurSession.pseudo}">
		            </div>
		        
		            <div class="col-md-6 mb-3">
		                <label for="nom">Nom</label>
		                <input readonly="readonly" type="text" class="form-control" id="nom" name="nom" maxlength="30" required value="${sessionScope.utilisateurSession.nom}">
		            </div>
		        </div>
		        
		        <div class="row">
		            <div class="col-md-6 mb-3">
		                <label for="prenom">Prénom</label>
		                <input readonly="readonly" type="text" class="form-control" id="prenom" name="prenom" maxlength="30" required value="${sessionScope.utilisateurSession.prenom}">
		            </div>
		        
		            <div class="col-md-6 mb-3">
		                <label for="mail">Email</label>
		                <input readonly="readonly" type="email" class="form-control" id="mail" name="mail" maxlength="100" required value="${sessionScope.utilisateurSession.mail}">
		            </div>
		        </div>
		        
		        <div class="row">
		            <div class="col-md-4 mb-3">
		                <label for="telephone">Téléphone</label>
		                <input readonly="readonly" type="text" class="form-control" id="telephone" name="telephone" maxlength="15" value="${sessionScope.utilisateurSession.telephone}">
		            </div>
		            <div class="col-md-8 mb-3">
		                <label for="rue">Rue</label>
		                <input readonly="readonly" type="text" class="form-control" id="rue" name="rue" maxlength="30" required value="${sessionScope.utilisateurSession.rue}">
		            </div>
		        </div>
		        
		        <div class="row">
		            <div class="col-md-4 mb-3">
		                <label for="codePostal">Code postal</label>
		                <input readonly="readonly" type="number" class="form-control" id="codePostal" name="codePostal" min="01000" max="99999" required value="${sessionScope.utilisateurSession.codePostal}">
		            </div>
		            <div class="col-md-8 mb-3">
		                <label for="ville">Ville</label>
		                <input readonly="readonly" type="text" class="form-control" id="ville" name="ville" maxlength="30" required value="${sessionScope.utilisateurSession.ville}">
	                </div>
	           </div>
				
				<hr class="mb-4">
	            <a href="${pageContext.request.contextPath}/ModifierProfil">
	            	<button class="btn btn-primary btn-lg btn-block">Modifier mes informations</button>
	            </a>  
	            
	            <hr class="mb-4">
	            <a href="${pageContext.request.contextPath}/ModifierMotDePasse">
	            	<button class="btn btn-primary btn-lg btn-block">Modifier mon mot de passe</button>
	            </a>  
            
            </div>           
		            
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