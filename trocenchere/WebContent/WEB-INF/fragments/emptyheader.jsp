        <header>
            <nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
                <!-- Brand/logo -->

                <a class="navbar-brand" href="${pageContext.request.contextPath}/Accueil">
                    <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
                    <strong>ENI-Encheres</strong>
                </a>
                <a class="navbar-brand" href="#" alt="G�rer mon profil" title="G�rer mon profil">
                    <img class="small-icon" src="images/user.svg">
                    <span class="align-middle text-muted">${sessionScope.utilisateurSession.pseudo}, 0 cr�dit(s)</span>
                </a>
            </nav>
        </header>