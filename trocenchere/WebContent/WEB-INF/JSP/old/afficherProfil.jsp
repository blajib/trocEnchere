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
            
            <div>
            	<%-- Pseudo : ${sessionScope.utilisateurSession.pseudo} --%>
            	<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="pseudo"/>
				</jsp:include>
            	<%-- <jsp:include page="/WEB-INF/fragments/modificationProfil.jsp"></jsp:include> --%>
            	</br>
            	<%-- Email : ${sessionScope.utilisateurSession.mail} --%>
            	<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="mail"/>
				</jsp:include>
            	</br>
            	<%-- Téléphone : ${sessionScope.utilisateurSession.telephone} --%>
				<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="telephone"/>
				</jsp:include>
            	</br>
            	<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="rue"/>
				</jsp:include>
				<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="codePostal"/>
				</jsp:include>
				<jsp:include page="/WEB-INF/fragments/modificationProfil.jsp">
					<jsp:param name="nomAttribut" value="ville"/>
				</jsp:include> </br>
				<%-- Adresse :
            	${sessionScope.utilisateurSession.rue}</br>
            	${sessionScope.utilisateurSession.codePostal} ${sessionScope.utilisateurSession.ville} --%>
            	<form action="${pageContext.request.contextPath}/ModifierProfil" method="post">
					<label for="motdepasse">Modifier mon mot de passe (cliquez sur le crayon)</label>
					<input class="input" type="hidden" readonly="readonly" name="motdepasse" value="${sessionScope.utilisateurSession.motdepasse}">
					<input type="image" alt="modifier" src="images/modification.png" width="20" height="20">
				</form></br>
            	</br>
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