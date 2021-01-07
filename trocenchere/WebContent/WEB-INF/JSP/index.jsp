<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<jsp:include page="/WEB-INF/fragments/head.jsp">
		<jsp:param value="ENI-Encheres : Liste des enchères" name="title"/>
	</jsp:include>
	
	<body>
    	<div class="container-fluid">
	        <!--fullHeader-->
		 	<c:if test="${empty utilisateurSession}">
		 		<jsp:include page="/WEB-INF/fragments/headerDeconnecter.jsp"></jsp:include>
		 	</c:if>
		 	<c:if test="${!empty utilisateurSession}">
		 		<jsp:include page="/WEB-INF/fragments/headerConnecter.jsp"></jsp:include>
		 	</c:if>
		 	
		 	<!-- message suppression du compte -->
		 	<c:if test="${suppression == true }">
		    	<div id="blocSupressionReussie">  
			 		<p> Votre compte a bien été supprimé </p>
		 		</div> 
		 	</c:if>
		 	
	        <!--main bloc-->
	        <main>
	            <!--title-->
	            <div class="mx-auto text-center">
	                <h1>Enchères</h1>
	            </div>
	            <c:if test="${!empty retourMiseEnchere }">
	            <p id="enchereValide">Votre article a bien été mis aux encheres</p>
	            
	            </c:if>
	            
	           <!-- erreur
	            <div class="d-flex alert-danger">
	                <div class="col-3 p-2">
	                    <img class="small-icon" src="images/error.svg">
	                </div>
	            
	                <ul class="col-9 list-unstyled p-2">
	                    <li>un message d'erreur éventuellement !</li>
	                    <li>un autre message....</li>
	                </ul>
	            </div> -->
	            
	            <!--filtre-->
	            <form class="form-filter border mb-3" action="RechercherEncheres" method="post">
	                <div class="row">
	                    <!--Partie gauche-->
	                    <div class="col-md-6 mb-3">
	                        <div class="form-group">
	                                <label for="filter-input">Filtre</label>
	                                <input type="text" class="form-control" id="filter-input" name="filtre" placeholder="articles contenant..." value="${filtre}">
	                        </div>
	                        <div class="form-group">
	                            <label for="categories-select">Catégories</label>
	                            <select class="form-control" id="categories-select" name="categorie">
	                                <option name="categorie" value="0" <c:if test="${categorie == 0}">selected</c:if> >Toutes</option>
	                                <option name="categorie" value="1" <c:if test="${categorie == 1}">selected</c:if> >Informatique</option>
	                                <option name="categorie" value="2" <c:if test="${categorie == 2}">selected</c:if> >Ameublement</option>
	                                <option name="categorie" value="3" <c:if test="${categorie == 3}">selected</c:if> >Vêtement</option>
	                                <option name="categorie" value="4" <c:if test="${categorie == 4}">selected</c:if> >Sport & Loisirs</option>
	                            </select>
	                        </div>
	                    </div>
	                    <!--Partie droite-->
	                    <div class="col-md-6 mb-3">  	
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="radio" class="form-check-input" checked name="type-encheres" value="achats" id="achats" <c:if test="${typeEnchere.equalsIgnoreCase('achats')}">checked</c:if> >Achats
	                            </label>
	                        </div>
	                        <div class="form-group">
	                            <div class="form-check">
	                                <label class="form-check-label">
	                                    <input type="checkbox" class="form-check-input" name="etatAchat" value="'EC'" id="ouvertes" <c:if test="${etatAchatString.contains('EC')}">checked</c:if> >Enchères ouvertes
	                                </label>
	                            </div>
	                            <c:if test="${!empty utilisateurSession}">
		                            <div class="form-check">
		                                <label class="form-check-label">
		                                    <input type="checkbox" class="form-check-input" name="etatAchat" value="'EC'" id="encours" <c:if test="${etatAchatString.contains('EC')}">checked</c:if> >Mes enchères en cours
		                                </label>
		                            </div>
		                            <div class="form-check">
		                                <label class="form-check-label">
		                                    <input type="checkbox" class="form-check-input" name="etatAchat" value="'TER'" id="remportees" <c:if test="${etatAchatString.contains('TER')}">checked</c:if> >Mes enchères remportées
		                                </label>
		                            </div>
		                        </c:if>
	                        </div>
	                        <c:if test="${!empty utilisateurSession}">
		                        <div class="form-check">
		                            <label class="form-check-label">
		                                <input type="radio" class="form-check-input" name="type-encheres" value="ventes" id="ventes" <c:if test="${typeEnchere.equalsIgnoreCase('ventes')}">checked</c:if> >Ventes
		                            </label>
		                        </div>
		                        <div class="form-group">
		                            <div class="form-check">
		                                <label class="form-check-label">
		                                    <input type="checkbox" class="form-check-input" name="etatVente" value="'EC'" id="venteencours" <c:if test="${etatVenteString.contains('EC')}">checked</c:if> >Mes ventes en cours
		                                </label>
		                            </div>
		                            <div class="form-check">
		                                <label class="form-check-label">
		                                    <input type="checkbox" class="form-check-input" name="etatVente" value="'PV'" id="nondebutees" <c:if test="${etatVenteString.contains('PV')}">checked</c:if> >Mes ventes non débutées
		                                </label>
		                            </div>
		                            <div class="form-check">
		                                <label class="form-check-label">
		                                    <input type="checkbox" class="form-check-input" name="etatVente" value="'TER'" id="terminees" <c:if test="${etatVenteString.contains('TER')}">checked</c:if> >Mes ventes terminées
		                                </label>
		                            </div>
		                        </div>
	                        </c:if>
	
	                    </div>
	                </div>
	                <button class="btn btn-primary btn-lg btn-block" type="submit">
	                	<img class="small-icon" src="images/search.svg" alt="Eni Ecole">
	                </button>
	            </form>

				<!-- si la requête select associée au formulaire plus haut a donné quelque chose : attention à si connecté ou pas connecté -->
				<c:if test="${!empty encheres}">
	            	<!--enchères-->
	            	<c:forEach var="articleVendu" items="${encheres}">
			            <div class="row justify-content-center border-top card-deck">
			                <div class="col-12 col-sm-6 p-2" >
			                    <div class="card">
			                        <div class="card-header text-center">
			                            <h4 class="my-0 font-weight-normal">${articleVendu.getNomArticle()}</h4>
			                        </div>
			                        <div class="d-flex">
			                            <div class="col-3 p-2">
			                                <img class="img-fluid img-thumbnail" src="images/photo.svg" alt="pas de photo" />
			                            </div>
			                            <ul class="col-9 list-unstyled p-2">
			                                <li>Prix : ${articleVendu.getMiseAPrix()} point(s)</li>
			                                <li>Meilleure enchère : ${articleVendu.getPrixDeVente()} point(s)</li>
			                                <li>Fin de l'enchère : ${articleVendu.getDateFinEnchere()}</li>
			                                <li>
			                                	Vendeur : 
												<c:forEach var="utilisateur" items="${listeUtilisateurs}">
			                                		<c:if test="${articleVendu.identUtilisateur == utilisateur.ident}">
			                                			${utilisateur.pseudo}
			                                		</c:if>
			                                	</c:forEach>
			                                </li>
			                                <li>Identifiant article : ${articleVendu.getNoArticle()}</li>
			                                <!-- si l'utilisateur n'a pas été trouvé -->
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
			                                
			                                <c:if test="${!empty utilisateurSession}">
				                                <form  method="post" action="ServletTraitementFaireEnchere" >
				                                	<p>Met des thunes</p>
				                                	<input type="number" name="credit" value="Met des thunes" />
				                                	<input type="hidden" name="noArticle" value="${articleVendu.noArticle}"/>
				                                	<button type="submit" value="Yeah">Yeah</button>
				                                	
				                           		</form>
				                           		<li>Ton flouse est de : ${sessionScope.utilisateurSession.credit}</li>
			                           		</c:if>
			                            </ul>
			                        </div>
<!-- 			                        <input  class="mt-3 btn btn-lg btn-block btn-primary" href="#" title="faire une enchère"/> -->
<!-- 			                            <img class="small-icon" src="images/bid.svg"> -->
			                      
			                    </div>
			                </div>
		 				</div>
	 				</c:forEach>
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
	    <script>
	        // Example starter JavaScript for disabling form submissions if there are invalid fields
	        (function() {
	            'use strict';
	    
	            window.addEventListener('load', function() {
	            	checkAchats();
	            	checkVentes();
	                achats.addEventListener('change', function(event) {
	                	checkAchats();
	                }, false);
	                ventes.addEventListener('change', function(event) {
	                	checkVentes();
	                }, false);
	                
	                function checkAchats() {
	                	//id radio button achats
	                	var achats = document.getElementById('achats');
	                    if (achats.checked){
	                    	//id des checkbox
	                        document.getElementById('venteencours').disabled = true;
	                        document.getElementById('nondebutees').disabled = true;
	                        document.getElementById('terminees').disabled = true;
	                        document.getElementById('encours').disabled = false;
	                        document.getElementById('ouvertes').disabled = false;
	                        document.getElementById('remportees').disabled = false;
	                    }
	                }
	                function checkVentes(){
	                	//id radio button ventes
	                	var ventes = document.getElementById('ventes');
	                    if (ventes.checked){
	                    	//id des checkbox
	                        document.getElementById('venteencours').disabled = false;
	                        document.getElementById('nondebutees').disabled = false;
	                        document.getElementById('terminees').disabled = false;
	                        document.getElementById('encours').disabled = true;
	                        document.getElementById('ouvertes').disabled = true;
	                        document.getElementById('remportees').disabled = true;
	                    }
	                }
	            }, false);
	        })();
	    </script>
	</body>
</html>