 <header>
	<nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/Accueil">
	        <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
	        <strong>ENI-Encheres</strong>
	    </a>
	
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/afficherProfil" alt="G�rer mon profil" title="G�rer mon profil">
	        <img class="small-icon" src="images/${sessionScope.utilisateurSession.pseudo}.jpg">
	        <span class="align-middle text-muted">${sessionScope.utilisateurSession.pseudo}, ${sessionScope.utilisateurSession.credit} : cr�dit(s)</span>
	         <p>${sessionScope.utilisateurSession.mail}</p>
	    </a>

	    <h2 id="welcomeSentence">Vous �tes pr�s a claquer les ench�res ${sessionScope.utilisateurSession.prenom}<h2>
	    <div id="blocConnecterHeader">
		    <a class="nav-link" href="${pageContext.request.contextPath}/seDeconnecter" alt="Me d�connecter">Me d�connecter</a>
		    <a class="nav-link" href="${pageContext.request.contextPath}/supprimerCompte" alt="supprimer compte utilisateur">Supprimer votre compte</a>
		    <a class="nav-link" href="${pageContext.request.contextPath}/ServletPageCreationArticle" alt="creation article">Cration article</a>
	    </div>
	</nav>
</header>