<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.trocenchere.messages.LecteurMessage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page="/WEB-INF/fragments/head.jsp">
	<jsp:param value="ENI-Encheres : Inscription" name="title"/>
</jsp:include>
<body>
    <div class="container-fluid">
        <!--emptyHeader-->
		<jsp:include page="/WEB-INF/fragments/emptyheader.jsp"></jsp:include>

        <!--main bloc-->
        <main>
            <!--title-->
            <div class="mx-auto text-center">
                <h1>Inscription</h1>
                <img class="mb-4 large-icon rounded-circle" src="images/user.svg" alt="">
            </div>
            <!--erreur-->
           
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
            <!--formulaire-->
            <form class="form-register needs-validation" method="post" action="ServletCreerCompte">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="" maxlength="30" required value="${requestScope.pseudo}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                
                    <div class="col-md-6 mb-3">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="" maxlength="30" required value="${requestScope.nom}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" placeholder="" maxlength="30" required value="${requestScope.prenom}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                
                    <div class="col-md-6 mb-3">
                        <label for="mail">Email</label>
                        <input type="email" class="form-control" id="mail" name="mail" placeholder="you@example.com" maxlength="100" required value="${requestScope.mail}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="telephone">Téléphone <span class="text-muted">(Optional)</span></label>
                        <input type="text" class="form-control" id="telephone" name="telephone" placeholder="" maxlength="15" value="${requestScope.telephone}">
                    </div>
                    <div class="col-md-8 mb-3">
                        <label for="rue">Rue</label>
                        <input type="text" class="form-control" id="rue" name="rue" placeholder="" maxlength="30" required value="${requestScope.rue}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <label for="codePostal">Code postal</label>
                        <input type="number" class="form-control" id="codePostal" name="codePostal" placeholder="" min="01000" max="99999" required value="${requestScope.codePostal}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                    <div class="col-md-8 mb-3">
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" id="ville" name="ville" placeholder="" maxlength="30" required value="${requestScope.ville}">
                        <!-- <div class="invalid-feedback">
                            Ce champ est invalide !
                        </div> -->
                    </div>
                </div>
                                
				<div class="row">
				    <div class="col-md-6 mb-3">
				        <label for="motDePasse">Mot de passe</label>
				        <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="" minlength="6" maxlength="30" value="" required>
				        <!-- <div class="invalid-feedback">
				            Ce champ est invalide !
				        </div> -->
				    </div>
				
				    <div class="col-md-6 mb-3">
				        <label for="motDePasseConfirm">Confirmation</label>
				        <input type="password" class="form-control" id="motDePasseConfirm" name="motDePasseConfirm" placeholder="" required>
				        <!-- <div class="invalid-feedback">
				            Ce champ est invalide ou les mots de passe sont différents !
				        </div> -->
				    </div>
				</div>                
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Créer mon compte</button>
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
    <script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';

        window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');

        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                //validation du mot de passe
                var password = document.getElementById("password")
                , confirm_password = document.getElementById("confirm_password");
                if(password.value != confirm_password.value) {
                    confirm_password.setCustomValidity("Les mots de passe sont différents");
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    confirm_password.setCustomValidity('');
                }
                //validations des saisies obligatoires
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });            
    }, false);
    })();
    </script>
</body>

</html>