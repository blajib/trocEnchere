 <header>
            <nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/Accueil">
                    <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
                    <strong>ENI-Encheres</strong>
                </a>


                    <img class="small-icon" src="images/user.svg">
                    <span class="align-middle text-muted"></span>

                
                   
                

                <ul class="navbar-nav ml-auto">
<!--                     Dropdown for small screen -->
                    <li class="nav-item dropdown d-lg-none">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            <img class="small-icon" src="images/menu.svg" alt="Menu ENI-Encheres">
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#" alt="Administrer le site">Administrer</a> 
                            <a class="dropdown-item" href="#" alt="Vendre un article">Vendre un article</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletDecconexion" alt="Me déconnecter" >Me déconnecter</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/inscription" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
                            <a class="dropdown-item" href="<%=request.getContextPath()%>/SeConnecter" alt="Se connecter à ENI-Encheres">Me connecter</a>
                        </div>
                        
                    </li>  
<!--                     Links for medium screen -->
                                  
                    <li class="nav-item d-none d-lg-block">
                        <a class="nav-link" href="#" alt="Administrer le site">Administrer</a>
                    </li> 
                    <li class="nav-item d-none d-lg-block">
                        <a class="nav-link" href="#" alt="Vendre un article">Vendre un article</a>
                    </li>
                    <li class="nav-item d-none d-lg-block">
                        <a class="nav-link" href="${pageContext.request.contextPath}/seDeconnecter" alt="Me déconnecter">Me déconnecter</a>
                    </li>
                    <li class="nav-item d-none d-lg-block">
                        <a class="nav-link" href="${pageContext.request.contextPath}/inscription" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
                    </li>
                    <li class="nav-item d-none d-lg-block">
                        <a class="nav-link" href="${pageContext.request.contextPath}/SeConnecter" alt="Se connecter à ENI-Encheres">Me connecter</a>
                    </li>
                    
                </ul>
 
            </nav>
        </header>