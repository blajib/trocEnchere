<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.trocenchere.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Connexion" name="title"/>
</jsp:include>
<body>
    <div class="container-fluid">
        <!--emptyHeader-->
        <jsp:include page="/WEB-INF/fragments/emptyheader.jsp"></jsp:include>

        <!--main bloc-->
        <main>
            <!--title-->
            <div class="mx-auto text-center">
                <h1>Connexion</h1>
                <img class="mb-4 large-icon rounded-circle" src="images/user.svg" alt="">
            </div>
            
            <!--erreur-->
            <c:if test="${!empty authentificationRatee}">
	            <div class="d-flex alert-danger">
	                <div class="col-3 p-2">
	                    <img class="small-icon" src="images/error.svg">
	                </div>
	            
	                <ul class="col-9 list-unstyled p-2">
	                    <li>${LecteurMessage.getMessageErreur(authentificationRatee)}</li>
	                </ul>
	            </div>
            </c:if>
            
            <!--formulaire-->
            <form class="form-login" action="ServletEnvoiDonnees" method="post">
                <label for="inputIdentifiant" class="sr-only">Pseudo ou email</label>
                <input type="text" id="inputIdentifiant" class="form-control" name="pseudo_ou_email" placeholder="Pseudo ou email" required autofocus value="${requestScope.pseudo_ou_email}">
                
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" name="motdepasse" placeholder="Mot de passe" required value="${requestScope.motdepasse}">
                
                <div class="checkbox mb-3">
                    <label>
                   		<input type="checkbox" name="remember" value="remember">Se souvenir de moi
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit" title="Me connecter">
                	<img class="small-icon" src="images/connect.svg" alt="Me connecter">
                </button>
                <a href="#">Mot de passe oublié</a>
            </form>
            
            <form id="registerButton" method="get" action="inscription" >
             	<input type="submit" value="Inscription"/>
            </form>
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